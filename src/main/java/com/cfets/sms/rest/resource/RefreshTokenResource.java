package com.cfets.sms.rest.resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.common.constants.CommonConstants;
import com.cfets.common.constants.RestReturnCodeConstants;
import com.cfets.sms.rest.dao.ibatisDAO;
import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.entity.VaildateToken;
import com.cfets.sms.rest.util.Utils;

@Path("/refresh_token")
public class RefreshTokenResource {
	private static Logger logger = LogManager
			.getLogger(RefreshTokenResource.class);

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public String refreshToken(String inputjson,
			@Context HttpServletResponse servletResponse) {
		InputStream inStream = RefreshTokenResource.class
				.getResourceAsStream("/message/message.properties");
		Properties prop = new Properties();
		try {
			prop.load(inStream);
			logger.info("refreshToken load /message/message.properties");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			logger.error(e2.getMessage());
		}
		int refresh_token_life = Integer.parseInt(prop
				.getProperty("REFRESH_TOKEN_TIME"));

		JSONObject input_info = (JSONObject) JSONSerializer.toJSON(inputjson);
		try {
			String username = input_info.getString("username");
			String password = input_info.getString("password");
			String grant_type = input_info.getString("grant_type");
			String password_sha2 = Utils.toSHA2(password, CommonConstants.SHA2_ADMIN_USER_PASSWORD);

			// String auth_token;
			Timestamp d_time = new Timestamp(System.currentTimeMillis());

			long expire_time = ((long) d_time.getTime() / 1000)
					+ refresh_token_life;// 修改成可以配置时间
			// long expire_time = ((long) d_time.getTime() / 1000) + 60 * 60 *
			// 24;// 修改成可以配置时间
			d_time.setTime(expire_time * 1000);

			if (grant_type.equals("refresh_token")) {
				VaildateToken vt = ibatisDAO.validateUserPassword(username,
						password_sha2, d_time);
				if (vt.isVaildate()) {
					Timestamp current_time = new Timestamp(
							System.currentTimeMillis());
					TokenModel tm = null;

					tm = ibatisDAO.hasVaildateToken(username, current_time);

					if (tm == null) {
						String auth_token = "";
						Map<String, String> map = new HashMap<String, String>();

						map.put("auth_token", auth_token);
						map.put("res_code",
								RestReturnCodeConstants.REFRESH_TOKEN_CODE_EXPIRED);
						map.put("res_message",
								RestReturnCodeConstants.REFRESH_TOKEN_MESSAGE_EXPIRED);
						map.put("expires_in",
								String.valueOf(RestReturnCodeConstants.TOKEN_WRONG));
						JSONObject jsonObject = (JSONObject) JSONSerializer
								.toJSON(map);
						logger.error("无有效token");
						return jsonObject.toString();
					} else {
						String SHA_1_Str = tm.getToken();
						ibatisDAO.refreshToken(username, SHA_1_Str, d_time);
						
						Map<String, String> map = new HashMap<String, String>();

						map.put("auth_token", SHA_1_Str);
						map.put("res_code", RestReturnCodeConstants.REFRESH_TOKEN_CODE_SUCCESS);
						map.put("res_message",
								RestReturnCodeConstants.REFRESH_TOKEN_MESSAGE_SUCCESS);
						map.put("expires_in", String.valueOf(d_time));
						JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
						logger.info("parseTokenBean:用户名密码正确");
						return jsonObject.toString();
					}
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
					JSONObject jsonObject = (JSONObject) JSONSerializer
							.toJSON(map);
					logger.error("用户名或密码错误");
					return jsonObject.toString();
				}
			} else {
				Map<String, String> map = new HashMap<String, String>();

				map.put("auth_token", "");
				map.put("res_code",
						RestReturnCodeConstants.REFRESH_TOKEN_TYPE_CODE_FAIL);
				map.put("res_message",
						RestReturnCodeConstants.REFRESH_TOKEN_TYPE_MESSAGE_FAIL);
				map.put("expires_in",
						String.valueOf(RestReturnCodeConstants.TOKEN_WRONG));
				JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(map);
				logger.error("RefreshTokenResource: json type错误");
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
