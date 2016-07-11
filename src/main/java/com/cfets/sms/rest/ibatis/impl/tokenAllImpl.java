package com.cfets.sms.rest.ibatis.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.ibatis.mapper.TokenAllMapper;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class tokenAllImpl implements TokenAllMapper {
	private static Logger logger = LogManager.getLogger(tokenAllImpl.class);

	private static SqlMapClient sqlMapClient = null;
	// 读取配置文件
	static {
		try {
			Reader reader = Resources.getResourceAsReader("ibatisConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			logger.info("获取ibatisConfig数据库链接。");

			reader.close();
		} catch (IOException e) {
			logger.error("获取ibatisConfig数据库链接失败。");

			e.printStackTrace();
		}
	}

	@Override
	public void addToken(TokenModel tm) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert(
					"com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.addToken",
					tm);
			logger.info("addToken成功：" + tm.toString());

		} catch (SQLException e) {
			logger.error("addToken失败：" + tm.toString());

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TokenModel selectTokenModelByUsernameAndCurrentTime(String username,
			Timestamp current_time) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("username", username);
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		String str = sdf.format(current_time);
		map.put("expire_date", str);
		TokenModel tm = null;

		try {
			List<TokenModel> b = new ArrayList();
			b = (List<TokenModel>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.selectTokenModelByUsernameAndCurrentTime",
							map);
			if (!b.isEmpty()) {
				if (b.get(0).getToken() != null) {
					tm = b.get(0);
					logger.info("selectTokenModelByUsernameAndCurrentTime成功,username:"
							+ username);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByUsernameAndCurrentTime失败,username:"
					+ username);

			e.printStackTrace();
		}

		return tm;
	}

	@Override
	public TokenModel selectTokenModelByTokenValue(String tokenName) {
		// TODO Auto-generated method stub
		TokenModel token = null;
		try {
			List<TokenModel> b = (List<TokenModel>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.selectTokenModelByToken",
							tokenName);
			if (!b.isEmpty()) {
				if (b.get(0).getToken() != null) {
					token = b.get(0);
					logger.info("selectTokenModelByTokenValue成功,tokenName:"
							+ tokenName);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByTokenValue失败,tokenName:"
					+ tokenName);

			e.printStackTrace();
		}
		return token;
	}

	// @Override
	// public TokenModel selectTokenModelByUsername(String username,
	// String expire_date) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// @Override
	// public TokenModel selectTokenModelByUsernameAndToken(String token,
	// String expire_date) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public void updateTokenModelByToken(TokenModel tm) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient
					.update("com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.updateTokenModelByToken",
							tm);
			logger.info("updateTokenModelByToken成功:" + tm.toString());

		} catch (SQLException e) {
			logger.error("updateTokenModelByToken失败:" + tm.toString());

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateTokenInvalidate(TokenModel tm) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient
					.update("com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.updateTokenModelByToken",
							tm);
			logger.info("updateTokenInvalidate成功:" + tm.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("updateTokenInvalidate失败:" + tm.toString());

			e.printStackTrace();
		}
	}

	// @Override
	// public void updateRefeshTokenModelByToken(String expire_date, String
	// token) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public TokenModel selectTokenModelByToken() {
		// TODO Auto-generated method stub
		TokenModel token = null;
		try {
			List<TokenModel> b = (List<TokenModel>) sqlMapClient
					.queryForList("com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.selectTokenModelByToken");
			if (!b.isEmpty()) {
				if (b.get(0).getToken() != null) {
					token = b.get(0);
					logger.info("selectTokenModelByToken成功");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByToken失败");

			e.printStackTrace();
		}
		return token;
	}

	public void refreshToken(TokenModel tm) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient
					.update("com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.refreshToken",
							tm);
			logger.info("refreshToken成功:" + tm.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("refreshToken失败:" + tm.toString());

			e.printStackTrace();
		}
	}

	public TokenModel tokenIsValidate(String auth_token) {
		Map map = new HashMap();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		map.put("token", auth_token);
		map.put("currenttime", ts);

		try {
			List<TokenModel> b = (List<TokenModel>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.TokenAllMapper.tokenIsValidate",
							map);

			if (!b.isEmpty()) {
				if (b.get(0).getToken() != null) {
					logger.info("tokenIsValidate成功:" + auth_token);
					return b.get(0);
				}
			}
		} catch (SQLException e) {
			logger.error("tokenIsValidate失败:" + auth_token);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub

	}

}
