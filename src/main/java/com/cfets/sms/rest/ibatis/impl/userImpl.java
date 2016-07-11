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
					logger.info("selectUserByUsername成功：" + userName);
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsername失败：" + userName);

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
					logger.info("selectUserByUsernameAndPassword成功："
							+ user.toString());
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsernameAndPassword失败");

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
					logger.info("selectUserByUsernameAndPasswordAndUsertype成功："
							+ user.toString());
				}
			}
		} catch (SQLException e) {
			logger.error("selectUserByUsernameAndPasswordAndUsertype失败");

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
