package com.cfets.sms.rest.ibatis.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.sms.rest.entity.User;
import com.cfets.sms.rest.ibatis.mapper.UserMapper;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class userImpl implements UserMapper {
	private static Logger logger = LogManager.getLogger(userImpl.class);

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
	public User selectUserByUsername(String userName) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			List<User> b = (List<User>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.UserMapper.selectUserByUsername",
							userName);
			if (!b.isEmpty()) {
				if (b.get(0).getID() != null) {
					user = b.get(0);
					logger.info("selectUserByUsername�ɹ���" + userName);
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsernameʧ�ܣ�" + userName);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectUserByUsernameAndPassword(Map paraMap) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			List<User> b = (List<User>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.UserMapper.selectUserByUsernameAndPassword",
							paraMap);
			if (!b.isEmpty()) {
				if (b.get(0).getID() != null) {
					user = b.get(0);
					logger.info("selectUserByUsernameAndPassword�ɹ���"
							+ user.toString());
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsernameAndPasswordʧ��");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User selectUserByUsernameAndPasswordAndUsertype(Map paraMap) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			List<User> b = (List<User>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.UserMapper.selectUserByUsernameAndPasswordAndUsertype",
							paraMap);
			if (!b.isEmpty()) {
				if (b.get(0).getID() != null) {
					user = b.get(0);
					// System.out.println("=============================" +
					// user.getID());
					logger.info("selectUserByUsernameAndPasswordAndUsertype�ɹ���"
							+ user.toString());
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsernameAndPasswordAndUsertypeʧ��");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
