package com.cfets.common.constants;

public class RestReturnCodeConstants {
	public static final String SEND_CODE_SUCCESS = "000000";
	public static final String SEND_CODE_FAIL = "404010";
	public static final String SEND_CODE_TOKEN_WRONG = "404002";
	public static final String SEND_CODE_WRONG_PHONENUMBER = "404013";
	public static final String SEND_CODE_JSONCODE_WRONG = "404014";
	public static final String SEND_CODE_TOKEN_EXPIRED = "404012";
	public static final String SEND_CODE_USER_WRONG = "404112";

	
	public static final String SEND_CODE_WRONG_TASKID = "406022";
	public static final String SEND_CODE_TASKID_OK = "000000";
	public static final String SEND_CODE_JSONCODE_TASKID_WRONG = "406104";

	
	
	public static final String SEND_MESSAGE_WRONG_PHONENUMBER = "WRONG PHONE NUMBER";
	public static final String SEND_MESSAGE_SUCCESS = "SUCCESS";
	public static final String SEND_MESSAGE_FAIL = "FAIL";
	public static final String SEND_MESSAGE_TOKEN_WRONG = "TOKEN 失效或错误";
	public static final String SEND_MESSAGE_JSONCODE_WRONG = "JSON TYPE IS WRONG";
	public static final String SEND_MESSAGE_TOKEN_EXPIRED = "无效Token";
	public static final String SEND_MESSAGE_WRONG_TASKID = "WRONG TASK ID";
	public static final String SEND_MESSAGE_TASKID_OK = "TaskID OK!";
	public static final String SEND_MESSAGE_JSONCODE_TASKID_WRONG = "JSON TYPE IS WRONG. TASKID 必须为整数.";
	public static final String SEND_MESSAGE_USER_WRONG = "无此用户。";





	
	public static final int TOKEN_WRONG = -1;
	public static final int TOKEN_EXIRED = 0;
	public static final int TOKEN_ONE_YEAR = 31536000;

	public static final String TOKEN_CODE_SUCCESS = "000000";
	public static final String TOKEN_MESSAGE_SUCCESS = "SUCCESS";
	public static final String TOKEN_CODE_USER_PASSWORD_WRONG = "403001";
	public static final String TOKEN_MESSAGE_USER_PASSWORD_WRONG = "USER OR PASSWORD IS WRONG";
	public static final String TOKEN_CODE_JSON_WRONG = "403016";
	public static final String TOKEN_MESSAGE_JSON_WRONG = "JSON TYPE IS WRONG";
	public static final String TOKEN_CODE_USERNAME_PASSWORD_WRONG = "403007";
	public static final String TOKEN_MESSAGE_USERNAME_PASSWORD_WRONG = "USERNAME OR PASSWORD IS NULL";

	public static final String REFRESH_TOKEN_CODE_SUCCESS = "000000";
	public static final String REFRESH_TOKEN_MESSAGE_SUCCESS = "SUCCESS";
	public static final String REFRESH_TOKEN_CODE_FAIL = "405003";
	public static final String REFRESH_TOKEN_MESSAGE_FAIL = "token无效或用户名/密码错误，刷新失败，请重新登录！";
	public static final String REFRESH_TOKEN_TYPE_CODE_FAIL = "405018";
	public static final String REFRESH_TOKEN_TYPE_MESSAGE_FAIL = "grant_type is not refresh_token!";
	public static final String REFRESH_TOKEN_USERNAME_PASSWORD_CODE_FAIL = "405019";
	public static final String REFRESH_TOKEN_USERNAME_PASSWORD_MESSAGE_FAIL = "JSONTYPE PASSWORD OR USERNAME OR REFRESH IS WRONG!";
	public static final String REFRESH_TOKEN_CODE_EXPIRED = "403020";
	public static final String REFRESH_TOKEN_MESSAGE_EXPIRED = "token过期";
}
