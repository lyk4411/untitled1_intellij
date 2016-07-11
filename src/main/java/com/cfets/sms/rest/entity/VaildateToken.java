package com.cfets.sms.rest.entity;

public class VaildateToken {
	public VaildateToken() {
		super();
		this.isVaildate = false;
		this.token = null;
		this.reseason = null;
	}

	private boolean isVaildate;
	private String reseason;
	private String token;

	public boolean isVaildate() {
		return isVaildate;
	}

	public void setVaildate(boolean isVaildate) {
		this.isVaildate = isVaildate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getReseason() {
		return reseason;
	}

	public void setReseason(String reseason) {
		this.reseason = reseason;
	}
}
