package com.cfets.sms.rest.ibatis.mapper;

import com.cfets.sms.rest.entity.OutBoxModel;


public interface OutBoxMapper {
	public OutBoxModel selectOutBoxByTaskID(Long taskID);

}
