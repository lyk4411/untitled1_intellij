package com.cfets.sms.rest.ibatis.mapper;


import java.util.Map;

import com.cfets.sms.rest.entity.User;

public interface UserMapper {
	
	//public User selectUserByUsername();

	public User selectUserByUsername(String userName);
	

	public User selectUserByUsernameAndPassword(
			Map paramMap);

	public User selectUserByUsernameAndPasswordAndUsertype(
			Map paramMap);
}
