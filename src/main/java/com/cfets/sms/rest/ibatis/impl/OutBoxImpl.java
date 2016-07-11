package com.cfets.sms.rest.ibatis.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cfets.sms.rest.entity.OutBoxModel;
import com.cfets.sms.rest.ibatis.mapper.OutBoxMapper;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class OutBoxImpl implements OutBoxMapper {
	private static Logger logger = LogManager.getLogger(OutBoxMapper.class);

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
	public OutBoxModel selectOutBoxByTaskID(Long taskID) {
		// TODO Auto-generated method stub
		OutBoxModel obm = null;
		try {
			List<OutBoxModel> b = (List<OutBoxModel>) sqlMapClient
					.queryForList(
							"com.cfets.sms.rest.ibatis.mapper.OutBoxMapper.selectOutBoxTypeByTaskID",
							taskID);
			if (!b.isEmpty()) {
				if (b.get(0).getTASK_ID() != null) {
					obm = b.get(0);
					logger.info("selectOutBoxByTaskID成功，taskid：" + taskID);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("selectOutBoxByTaskID失败，taskid：" + taskID);

			e.printStackTrace();
		}
		return obm;
	}

}
