package com.cfets.sms.rest.ibatis.mapper;


import java.sql.Timestamp;

import com.cfets.sms.rest.entity.TokenModel;

public interface TokenAllMapper {
	public void addToken(TokenModel tm);

	public TokenModel selectTokenModelByToken();

	public TokenModel selectTokenModelByTokenValue(String token);

//	public TokenModel selectTokenModelByUsername(
//			String username,
//			String expire_date);
//	
//	public TokenModel selectTokenModelByUsernameAndToken(
//			 String token,
//			 String expire_date);
	
	public void updateTokenModelByToken(TokenModel tm);



	void updateTokenInvalidate(TokenModel tm);

	TokenModel selectTokenModelByUsernameAndCurrentTime(String username,
														Timestamp current_time);
	
//	public void updateRefeshTokenModelByToken(
//			 String expire_date,
//			 String token);
}
