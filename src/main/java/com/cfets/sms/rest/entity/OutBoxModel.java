package com.cfets.sms.rest.entity;

import java.sql.Timestamp;

public class OutBoxModel {
	private Timestamp SENT_TM;// �ѷ���ʱ��
	private int RCV_ST;// ����״̬
	private String CHNL_TP;// ͨ������
	private Long CRTR_ID;// �����û�ID
	private Long TASK_ID;// ������
	private String CNTNT;// ����

	public Timestamp getSENT_TM() {
		return SENT_TM;
	}

	public void setSENT_TM(Timestamp sENT_TM) {
		SENT_TM = sENT_TM;
	}

	public int getRCV_ST() {
		return RCV_ST;
	}

	public void setRCV_ST(int rCV_ST) {
		RCV_ST = rCV_ST;
	}

	public String getCHNL_TP() {
		return CHNL_TP;
	}

	public void setCHNL_TP(String cHNL_TP) {
		CHNL_TP = cHNL_TP;
	}

	public Long getCRTR_ID() {
		return CRTR_ID;
	}

	public void setCRTR_ID(Long cRTR_ID) {
		CRTR_ID = cRTR_ID;
	}

	public Long getTASK_ID() {
		return TASK_ID;
	}

	public void setTASK_ID(Long tASK_ID) {
		TASK_ID = tASK_ID;
	}

	public String getCNTNT() {
		return CNTNT;
	}

	public void setCNTNT(String cNTNT) {
		CNTNT = cNTNT;
	}

	@Override
	public String toString() {
		return "OutBoxModel [SENT_TM=" + SENT_TM + ", RCV_ST=" + RCV_ST
				+ ", CHNL_TP=" + CHNL_TP + ", CRTR_ID=" + CRTR_ID
				+ ", TASK_ID=" + TASK_ID + ", CNTNT=" + CNTNT + "]";
	}

}
