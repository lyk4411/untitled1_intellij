package com.cfets.sms.rest.resource;

import com.cfets.common.constants.RestReturnCodeConstants;
import com.cfets.sms.rest.dao.ibatisDAO;
import com.cfets.sms.rest.entity.OutBoxModel;
import com.cfets.sms.rest.entity.TokenModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Path("/result")
public class ResultTaskID {
	private static Logger logger = LogManager.getLogger(ResultTaskID.class);

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String resultOfTask(String inputJson,
			@Context HttpServletResponse servletResponse,
			@Context HttpServletRequest request) {
		JSONObject input_info = (JSONObject) JSONSerializer.toJSON(inputJson);
		try {
			String taskID = input_info.getString("taskid");
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
				logger.error("SmsResource: ��Чtoken��");
				return jsonObject.toString();
			} else {
				String[] taskIDs = taskID.split(";");

				for (int i = 0; i < taskIDs.length; i++) {

					OutBoxModel obm = null;
					obm = ibatisDAO.GetOutBoxResultFormTaskID(Long
							.valueOf(taskIDs[i]));
					if (obm == null) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("res_code",
								RestReturnCodeConstants.SEND_CODE_WRONG_TASKID);
						map.put("res_message",
								RestReturnCodeConstants.SEND_MESSAGE_WRONG_TASKID);
						map.put("taskID", taskIDs[i]);
						// JSONObject jsonObject = (JSONObject) JSONSerializer
						// .toJSON(map);
						logger.error("resultOfTask: �޴�taskID");
						jsonArray.add(map.toString());

						// return jsonObject.toString();
					} else {
						Map<String, String> map = new HashMap<String, String>();
						map.put("res_code",
								RestReturnCodeConstants.SEND_CODE_TASKID_OK);
						map.put("res_message",
								RestReturnCodeConstants.SEND_MESSAGE_TASKID_OK);
						map.put("taskID", taskIDs[i]);
						String CHNL_TP = obm.getCHNL_TP();
						Timestamp ts = obm.getSENT_TM();
						String content = obm.getCNTNT();
						int rcv = obm.getRCV_ST();
						String status = null;
						if (rcv == 0) {
							status = "SUCCESS";
						} else if (rcv == 1) {
							status = "Sending...";
						} else if (rcv == 4) {
							status = "In balcklist.";
						} else {
							status = "failed!";
						}
						map.put("status", status);
						map.put("content", content);
						map.put("send_time", String.valueOf(ts));
						map.put("CHNL_TP", CHNL_TP);
						// JSONObject jsonObject = (JSONObject) JSONSerializer
						// .toJSON(map);
						// return jsonObject.toString();
						logger.info(String.valueOf(map));
						jsonArray.add(map.toString());
					}
				}
				return jsonArray.toString();
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}

		// JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
		Map<String, String> map = new HashMap<String, String>();
		map.put("res_code",
				RestReturnCodeConstants.SEND_CODE_JSONCODE_TASKID_WRONG);
		map.put("res_message",
				RestReturnCodeConstants.SEND_MESSAGE_JSONCODE_TASKID_WRONG);
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
		logger.error("resultOfTask: ����ʧ�ܣ�json code �д��� Task id ����Ϊ������");
		return jsonObject.toString();
	}
}
