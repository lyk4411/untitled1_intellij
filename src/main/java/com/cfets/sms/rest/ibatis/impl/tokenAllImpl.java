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
	// ��ȡ�����ļ�
	static {
		try {
			Reader reader = Resources.getResourceAsReader("ibatisConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			logger.info("��ȡibatisConfig���ݿ����ӡ�");

			reader.close();
		} catch (IOException e) {
			logger.error("��ȡibatisConfig���ݿ�����ʧ�ܡ�");

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
			logger.info("addToken�ɹ���" + tm.toString());

		} catch (SQLException e) {
			logger.error("addTokenʧ�ܣ�" + tm.toString());

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
					logger.info("selectTokenModelByUsernameAndCurrentTime�ɹ�,username:"
							+ username);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByUsernameAndCurrentTimeʧ��,username:"
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
					logger.info("selectTokenModelByTokenValue�ɹ�,tokenName:"
							+ tokenName);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByTokenValueʧ��,tokenName:"
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
			logger.info("updateTokenModelByToken�ɹ�:" + tm.toString());

		} catch (SQLException e) {
			logger.error("updateTokenModelByTokenʧ��:" + tm.toString());

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
			logger.info("updateTokenInvalidate�ɹ�:" + tm.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("updateTokenInvalidateʧ��:" + tm.toString());

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
					logger.info("selectTokenModelByToken�ɹ�");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectTokenModelByTokenʧ��");

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
			logger.info("refreshToken�ɹ�:" + tm.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("refreshTokenʧ��:" + tm.toString());

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
					logger.info("tokenIsValidate�ɹ�:" + auth_token);
					return b.get(0);
				}
			}
		} catch (SQLException e) {
			logger.error("tokenIsValidateʧ��:" + auth_token);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub

	}

}
