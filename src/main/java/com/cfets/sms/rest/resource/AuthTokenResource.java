package com.cfets.sms.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.cfets.sms.rest.util.Utils;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.common.constants.CommonConstants;
import com.cfets.common.constants.RestReturnCodeConstants;
import com.cfets.sms.rest.util.CommonUtils;
import com.cfets.sms.rest.dao.ibatisDAO;
import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.entity.VaildateToken;

@Path("/authorize")
public class AuthTokenResource {
	private static Logger logger = LogManager
			.getLogger(AuthTokenResource.class);

	// private static Logger logger = LogManager
	// .getLogger(AuthTokenResource.class);

	@SuppressWarnings("deprecation")
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String parseTokenBean(String inputJson,
			@Context HttpServletResponse servletResponse) {

		InputStream inStream = AuthTokenResource.class
				.getResourceAsStream("/message/message.properties");
		Timestamp current_time = new Timestamp(System.currentTimeMillis());
		Timestamp tsexpire = new Timestamp(System.currentTimeMillis());
		tsexpire.setMinutes(tsexpire.getMinutes() -1);
		
		Properties prop = new Properties();
		try {
			prop.load(inStream);
			logger.info("导入message.properties");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			logger.error("导入message.properties数据错误。");
			// System.out.println("导入message.properties数据错误。");
		}
		int token_life = Integer.parseInt(prop.getProperty("TOKEN_TIME"));

		Timestamp d_time = new Timestamp(System.currentTimeMillis());
		long expire_time = ((long) d_time.getTime() / 1000) + token_life;

		d_time.setTime(expire_time * 1000);

		JSONObject input_info = (JSONObject) JSONSerializer.toJSON(inputJson);
		try {
			String username = input_info.getString("username");
			String password = input_info.getString("password");
			// System.out.println("=============================================="+
			// username);
			// System.out.println("==============================================="+
			// password);

			if (username == null || password == null
					|| password.trim().length() == 0
					|| username.trim().length() == 0) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("auth_token", "");
				map.put("res_code",
						RestReturnCodeConstants.TOKEN_CODE_USERNAME_PASSWORD_WRONG);
				map.put("res_message",
						RestReturnCodeConstants.TOKEN_MESSAGE_USERNAME_PASSWORD_WRONG);
				map.put("expires_in",
						String.valueOf(RestReturnCodeConstants.TOKEN_WRONG));
				JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
				logger.error("用户名或密码为空");
				return jsonObject.toString();
			}
			// System.out.println(token_life);
			// System.out.println(username);
			String password_sha2 = Utils.toSHA2(password,
					CommonConstants.SHA2_ADMIN_USER_PASSWORD);
			VaildateToken vt = ibatisDAO.validateUserPassword(username,
					password_sha2, d_time);
			// System.out.println("======================" + vt.isVaildate());
			if (vt.isVaildate()) {

				TokenModel tm = null;

				tm = ibatisDAO.hasVaildateToken(username, current_time);
				// System.out.println("==============="+ username);
				// System.out.println("==============="+ current_time);
				while (tm != null) {
					tm.setExpire_date(tsexpire);
					ibatisDAO.updateTokenInvalidate(tm);
					
					tm = ibatisDAO.hasVaildateToken(username, current_time);
				}
				String SHA_1_Str = CommonUtils.SHA_1_Encode(username + password
						+ d_time.toString());
				ibatisDAO.addToken(username, SHA_1_Str, d_time);

				Map<String, String> map = new HashMap<String, String>();
				map.put("auth_token", SHA_1_Str);
				map.put("res_code", RestReturnCodeConstants.TOKEN_CODE_SUCCESS);
				map.put("res_message",
						RestReturnCodeConstants.TOKEN_MESSAGE_SUCCESS);
				map.put("expires_in", String.valueOf(token_life));
				JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
				logger.info("parseTokenBean:用户名密码正确");
				return jsonObject.toString();

			} else {
				String auth_token = "";
				Map<String, String> map = new HashMap<String, String>();
				map.put("auth_token", auth_token);
				map.put("res_code",
						RestReturnCodeConstants.TOKEN_CODE_USER_PASSWORD_WRONG);
				map.put("res_message",
						RestReturnCodeConstants.TOKEN_MESSAGE_USER_PASSWORD_WRONG);
				map.put("expires_in",
						String.valueOf(RestReturnCodeConstants.TOKEN_WRONG));
				JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
				logger.error("用户名或密码错误");
				return jsonObject.toString();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("auth_token", "");
		map.put("res_code",
				RestReturnCodeConstants.REFRESH_TOKEN_USERNAME_PASSWORD_CODE_FAIL);
		map.put("res_message",
				RestReturnCodeConstants.REFRESH_TOKEN_USERNAME_PASSWORD_MESSAGE_FAIL);
		map.put("expires_in",
				String.valueOf(RestReturnCodeConstants.TOKEN_WRONG));
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
		logger.error("RefreshTokenResource: json code type错误");
		return jsonObject.toString();
	}
}