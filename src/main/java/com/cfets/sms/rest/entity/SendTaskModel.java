package com.cfets.sms.rest.entity;
import java.sql.Timestamp;

public class SendTaskModel {

	@Override
	public String toString() {
		return "SendTaskModel [id=" + id + ", userid=" + userid
				+ ", phonenumber=" + phonenumber + ", content=" + content
				+ ", sendTime=" + sendTime + ", subbmitTime=" + subbmitTime
				+ ", count=" + count + ", MBL_NO=" + MBL_NO + ", UNCM_NO="
				+ UNCM_NO + "]";
	}
	private Long id;
	private Long userid;
	private String phonenumber;
	private String content;
	private Timestamp sendTime;
	private Timestamp subbmitTime;
	private int count;
	private String MBL_NO;
	private String UNCM_NO;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMBL_NO() {
		return MBL_NO;
	}
	public void setMBL_NO(String mBL_NO) {
		MBL_NO = mBL_NO;
	}
	public String getUNCM_NO() {
		return UNCM_NO;
	}
	public void setUNCM_NO(String uNCM_NO) {
		UNCM_NO = uNCM_NO;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Timestamp getSubbmitTime() {
		return subbmitTime;
	}
	public void setSubbmitTime(Timestamp subbmitTime) {
		this.subbmitTime = subbmitTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
