package com.cfets.sms.rest.resource;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.common.constants.RestReturnCodeConstants;
import com.cfets.sms.rest.dao.ibatisDAO;
import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.entity.User;
import com.cfets.sms.rest.util.SmsUtil;

@Path("/sms")
public class SmsResource {
	private static Logger logger = LogManager.getLogger(SmsResource.class);

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String sendMessage(String inputJson,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest request) {
		JSONObject input_info = (JSONObject) JSONSerializer.toJSON(inputJson);
		// servletResponse.setCharacterEncoding("GBK"); //test
		try {
			String acceptor_phones = input_info.getString("acceptor_phones");
			String content = input_info.getString("content");
			String auth_token = request.getHeader("Authorization");

			JSONArray jsonArray = new JSONArray();
			TokenModel tm = null;
			tm = ibatisDAO.tokenIsValidate(auth_token);
			if (tm == null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("res_code",
						RestReturnCodeConstants.SEND_CODE_TOKEN_EXPIRED);
				map.put("res_message",
						RestReturnCodeConstants.SEND_MESSAGE_TOKEN_EXPIRED);
				JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
				logger.error("SmsResource: 无效token！");
				return jsonObject.toString();
			} else {
				String[] phone = acceptor_phones.split(";");
				// boolean b_phones_num[] = new boolean[phone.length];
				// boolean flag = true;
				//
				// for (int i = 0; i < b_phones_num.length; i++) {
				// b_phones_num[i] = false;
				// }
				User user = null;
				user = ibatisDAO.GetUserFromUserName(tm
						.getUsername());
				if(user == null){
					Map<String, String> map = new HashMap<String, String>();
					map.put("res_code",
							RestReturnCodeConstants.SEND_CODE_USER_WRONG);
					map.put("res_message",
							RestReturnCodeConstants.SEND_MESSAGE_USER_WRONG);
					JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
					logger.error("SmsResource: 无此用户！");
					return jsonObject.toString();
				}
				
				for (int i = 0; i < phone.length; i++) {
					if (SmsUtil.isMobileNO(phone[i])) {
						StringBuffer[] returnString = new StringBuffer[] { new StringBuffer(
								" ") };
						String subSentContent = "";
						int count = content.length() / 65 + 1;
						int right = 0;
						for (int j = 0; j < count; j++) {
							int k = j + 1;
							if ((j + 1) * 65 < content.length()) {
								right = (j + 1) * 65;
							} else {
								right = content.length();
							}
							subSentContent = content.substring(j * 65, right);
						
								Long resultSendID = ibatisDAO.SendMessage(
										phone[i],
										subSentContent,
										auth_token,
										tm.getUsername(),
										new Timestamp(System
												.currentTimeMillis()), user
												.getID(), user.getMBL_NO(),
										user.getUNCM_NO(), returnString);
								System.out.println(resultSendID);
								System.out.println(tm.getUsername());
								Map<String, String> map = new HashMap<String, String>();
								map.put("res_code",
										RestReturnCodeConstants.SEND_CODE_SUCCESS);
								map.put("res_message",
										RestReturnCodeConstants.SEND_MESSAGE_SUCCESS);
								map.put("Conetnt", subSentContent + "(" + k
										+ "/" + count + ")");
								map.put("acceptor_phone:", phone[i]);
								map.put("resultSendID",
										String.valueOf(resultSendID));
								logger.info("Conetnt:" + subSentContent
										+ "; phone:" + phone[i]
										+ "; SendTaskID:"
										+ String.valueOf(resultSendID)
										+ "  任务创建成功。");
								jsonArray.add(map.toString());
							
						}

					} else {
						Map<String, String> map = new HashMap<String, String>();
						map.put("res_code",
								RestReturnCodeConstants.SEND_CODE_WRONG_PHONENUMBER);
						map.put("res_message",
								RestReturnCodeConstants.SEND_MESSAGE_WRONG_PHONENUMBER);
						map.put("acceptor_phone", phone[i]);

						jsonArray.add(map.toString());
						logger.error("SmsResource: 非法手机号:" + phone[i]);
					}
				}

				// for (int i = 0; i < b_phones_num.length; i++) {
				// if (!b_phones_num[i]) {
				// flag = false;
				// break;
				// }
				// }
				// if (flag) {
				// map.put("res_code",
				// RestReturnCodeConstants.SEND_CODE_SUCCESS);
				// map.put("res_message",
				// RestReturnCodeConstants.SEND_MESSAGE_SUCCESS);
				// JSONObject jsonObject = (JSONObject) JSONSerializer
				// .toJSON(map);
				// logger.info("SmsResource: 发送成功");
				// jsonArray.add(map.toString());
				// return jsonArray.toString();
				// }
				return jsonArray.toString();

			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}

		// JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
		Map<String, String> map = new HashMap<String, String>();

		map.put("res_code", RestReturnCodeConstants.SEND_CODE_JSONCODE_WRONG);
		map.put("res_message",
				RestReturnCodeConstants.SEND_MESSAGE_JSONCODE_WRONG);
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
		logger.error("SmsResource: 发送失败，json code 有错误！");
		return jsonObject.toString();
	}
}
