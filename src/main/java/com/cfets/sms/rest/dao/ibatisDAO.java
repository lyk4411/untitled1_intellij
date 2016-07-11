package com.cfets.sms.rest.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.sms.rest.entity.OutBoxModel;
import com.cfets.sms.rest.entity.SendTaskModel;
import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.entity.User;
import com.cfets.sms.rest.entity.VaildateToken;
import com.cfets.sms.rest.ibatis.impl.OutBoxImpl;
import com.cfets.sms.rest.ibatis.impl.SendTaskImpl;
import com.cfets.sms.rest.ibatis.impl.tokenAllImpl;
import com.cfets.sms.rest.ibatis.impl.userImpl;

public class ibatisDAO {
	private static Logger logger = LogManager.getLogger(ibatisDAO.class);

	public static VaildateToken validateUserPassword(String username,
			String password, Timestamp d_time) {
		VaildateToken vt = new VaildateToken();
		logger.info("ibatis-config验证用户名密码是否正确。用户名：" + username + " 登入时间："
				+ String.valueOf(d_time));

		if (username == null || username.length() == 0) {
			vt.setVaildate(false);
			vt.setToken("");
			vt.setReseason("username is null");
			return vt;
		}
		if (password == null || password.length() == 0) {
			vt.setVaildate(false);
			vt.setToken("");
			vt.setReseason("password is null");
			return vt;
		}
		if (d_time == null) {
			vt.setVaildate(false);
			vt.setToken("");
			vt.setReseason("d_time is null");
			return vt;
		}
		userImpl ui = new userImpl();

		Map paraMap = new HashMap();
		paraMap.put("NM", username);
		paraMap.put("PSWD", password);
		paraMap.put("TP", "3");
		try {
			User user = ui.selectUserByUsernameAndPasswordAndUsertype(paraMap);

			if (user != null && user.getNM() != null) {
				System.out.println("vaildate user.");
				System.out.println("user:" + user.getNM());
				vt.setVaildate(true);
				logger.info("ibatis-config验证用户名密码是否正确。用户名：" + username
						+ " 登入时间：" + String.valueOf(d_time) + "用户名密码正确。");
			}
		} catch (Exception ex) {
			vt.setToken(" ");
			vt.setVaildate(false);
			vt.setReseason("No vaildate user.");
			logger.error("selectUserByUsernameAndPasswordAndUsertype 用户名，密码，用户类型错误。"
					+ "selectUserByUsernameAndPasswordAndUsertype 验证失败"
					+ ex.getMessage());
			ex.printStackTrace();
			// System.out.println("No vaildate user.");

		}
		return vt;
	}

	public static TokenModel hasVaildateToken(String username,
			Timestamp current_time) {
		if (username == null || username.length() == 0) {
			return null;
		}
		if (current_time == null) {
			return null;
		}
		tokenAllImpl tai = new tokenAllImpl();

		// java.sql.Date sqlDate=new java.sql.Date(current_time.getTime());
		TokenModel tm = null;
		tm = tai.selectTokenModelByUsernameAndCurrentTime(username,
				current_time);

		if (tm == null) {
			logger.error("token无效");
			return null;
		} else if (tm != null && tm.getToken() == null) {
			logger.error("token无效");
			return null;
		} else if (tm != null && tm.getToken() != null
				&& tm.getToken().length() <= 1) {
			logger.error("token无效");
			return null;
		}

		logger.info("token有效。");
		return tm;
	}

	public static boolean updateTokenInvalidate(TokenModel tm) {
		if (tm == null) {
			logger.error("token为空。");
			return false;
		}
		tokenAllImpl tai = new tokenAllImpl();
		tai.updateTokenModelByToken(tm);
		logger.info("使token失效成功。");
		return false;
	}

	public static VaildateToken addToken(String username, String token,
			Timestamp d_time) {
		VaildateToken vt = new VaildateToken();
		if (username == null || username.length() == 0) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("username is empty.");
			return vt;
		}
		if (token == null || token.length() == 0) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("token is empty.");
			return vt;
		}
		if (d_time == null) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("d_time is empty.");
			return vt;
		}
		tokenAllImpl tai = new tokenAllImpl();
		TokenModel tm = new TokenModel();
		tm.setToken(token);
		tm.setExpire_date(d_time);
		tm.setUsername(username);
		tai.addToken(tm);
		vt.setToken(token);
		vt.setReseason("Success");
		vt.setVaildate(true);
		logger.info("用户" + username + "在" + String.valueOf(d_time)
				+ "新增token成功。");
		return vt;
	}

	public static VaildateToken refreshToken(String username, String sHA_1_Str,
			Timestamp d_time) {
		// TODO Auto-generated method stub
		VaildateToken vt = new VaildateToken();
		if (username == null || username.length() == 0) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("username is empty.");
			return vt;
		}
		if (sHA_1_Str == null || sHA_1_Str.length() == 0) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("token is empty.");
			return vt;
		}
		if (d_time == null) {
			vt.setToken("");
			vt.setVaildate(false);
			vt.setReseason("d_time is empty.");
			return vt;
		}

		tokenAllImpl tai = new tokenAllImpl();
		TokenModel tm = new TokenModel();
		tm.setToken(sHA_1_Str);
		tm.setExpire_date(d_time);
		tm.setUsername(username);
		tai.refreshToken(tm);
		vt.setToken(sHA_1_Str);
		vt.setReseason("Success");
		vt.setVaildate(true);
		logger.info("用户" + username + "在" + String.valueOf(d_time) + "刷新token:"
				+ sHA_1_Str + "成功。");
		return vt;
	}

	public static TokenModel tokenIsValidate(String auth_token) {
		if (auth_token == null || auth_token.length() == 0) {
			return null;
		}
		tokenAllImpl tai = new tokenAllImpl();
		TokenModel tm = tai.tokenIsValidate(auth_token);
		// TODO Auto-generated method stub
		logger.info("token是否有效。");
		return tm;
	}

	public static Long SendMessage(String phonenumber, String content,
			String auth_token, String username, Timestamp timestamp, Long ID,
			String MBL_NO, String UNCM_NO, StringBuffer[] returnString) {
		// TODO Auto-generated method stub
		if (phonenumber == null || phonenumber.length() == 0) {
			return null;
		}
		if (content == null || content.length() == 0) {
			return null;
		}
		if (auth_token == null || auth_token.length() == 0) {
			return null;
		}
		if (username == null || username.length() == 0) {
			return null;
		}
		if (returnString == null || username.length() == 0) {
			return null;
		}
		if (timestamp == null) {
			return null;
		}
		if (ID == null) {
			return null;
		}
		if (MBL_NO == null || MBL_NO.length() == 0) {
			return null;
		}
		if (UNCM_NO == null || UNCM_NO.length() == 0) {
			return null;
		}
		SendTaskImpl sti = new SendTaskImpl();
		SendTaskModel sm = new SendTaskModel();
		sm.setContent(content);
		sm.setCount(1);
		sm.setUserid(ID);
		sm.setSendTime(timestamp);
		sm.setSubbmitTime(timestamp);
		sm.setMBL_NO(MBL_NO);
		sm.setPhonenumber(phonenumber);
		sm.setUNCM_NO(UNCM_NO);
		// System.out.println(sm.toString());
		try {
			Long taskID;
			sti.addSendTask(sm);
			taskID = sm.getId();
			if (taskID != null) {
				// System.out.println(taskID.toString());
				logger.info("发送消息：" + content + ";" + "手机号：：" + phonenumber
						+ ";" + "token：" + auth_token + ";" + "用户名：" + username
						+ ";" + "时间：" + String.valueOf(timestamp) + ";"
						+ "用户ID：" + ID + ";" + "成功。");
				return taskID;
			}
		} catch (Exception ex) {
			logger.error("发送消息：" + content + ";" + "手机号：：" + phonenumber + ";"
					+ "token：" + auth_token + ";" + "用户名：" + username + ";"
					+ "时间：" + String.valueOf(timestamp) + ";" + "用户ID：" + ID
					+ ";" + "失败。");
			ex.printStackTrace();
		}

		return null;
	}

	public static User GetUserFromUserName(String username) {
		// TODO Auto-generated method stub
		User user = null;
		if (username == null || username.length() == 0) {
			return null;
		}
		userImpl ui = new userImpl();
		try {
			user = ui.selectUserByUsername(username);

			if (user != null) {
				logger.info("获取用户信息：" + username);
				return user;
			}
		} catch (Exception ex) {
			logger.error("获取用户信息：" + username + "失败");
			ex.printStackTrace();
		}
		return null;
	}

	public static OutBoxModel GetOutBoxResultFormTaskID(Long taskID) {
		OutBoxModel obm = null;
		if (taskID == null) {
			return null;
		}
		OutBoxImpl obi = new OutBoxImpl();
		try {
			obm = obi.selectOutBoxByTaskID(taskID);
			if (obm != null) {
				logger.info("获取taskid信息：" + taskID);
				return obm;
			}
		} catch (Exception ex) {
			logger.error("获取taskid信息：" + taskID + "失败。");

			ex.printStackTrace();
		}
		return null;
	}
}
