package com.cfets.sms.rest.entity;

import java.sql.Timestamp;

public class TokenModel {
	private String username;
	private String token;
	private Timestamp expire_date;

	public TokenModel(String username, String token, Timestamp expire_date) {
		super();
		this.username = username;
		this.token = token;
		this.expire_date = expire_date;
	}

	public TokenModel() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenModel [username=" + username + ", token=" + token
				+ ", expire_date=" + expire_date + "]";
	}

	public Timestamp getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(Timestamp expire_date) {
		this.expire_date = expire_date;
	}
}
