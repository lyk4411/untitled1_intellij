package com.cfets.sms.rest.ibatis.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.sms.rest.entity.SendTaskModel;
import com.cfets.sms.rest.ibatis.mapper.SendTaskMapper;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SendTaskImpl implements SendTaskMapper {
	private static Logger logger = LogManager.getLogger(SendTaskImpl.class);

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
	public void addSendTask(SendTaskModel sm) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert(
					"com.cfets.sms.rest.ibatis.mapper.SendTaskMapper.addSendTask",
					sm);
			logger.info("addSendTask成功：" + sm.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("addSendTask失败：" + sm.toString());

			e.printStackTrace();
		}
	}
	
	
}
