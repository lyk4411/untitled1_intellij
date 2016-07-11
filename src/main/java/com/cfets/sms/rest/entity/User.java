package com.cfets.sms.rest.entity;

import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	@Override
	public String toString() {
		return "User [PSWD=" + PSWD + ", NM=" + NM + ", ID=" + ID + ", TP="
				+ TP + ", MBL_NO=" + MBL_NO + ", UNCM_NO=" + UNCM_NO + "]";
	}

	private String PSWD;
	private String NM;
	private Long ID;
	private int TP;
	private String MBL_NO;
	private String UNCM_NO;

	// private String USR_NM;
	// private String NM ;
	// private String PSWD ;

	// private Long ID ;
	// private Long GRP_ID ;
	// private Date CRT_TM ;
	// private Long ST ;
	// private String USR_DESC;
	// private String TP ;
	// private Long IP ;
	// private Date LOG_TM ;
	// private String MBL_NO ;
	// private String UNCM_NO ;
	// private Long LMT_AMNT ;
	// private Long SEND_NO ;
	// private String OLD_PSWD ;
	// private Long TRY_TMS ;
	// private Date TRY_TM ;

	public int getTP() {
		return TP;
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

	public void setTP(int tP) {
		TP = tP;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getPSWD() {
		return PSWD;
	}

	public void setPSWD(String pSWD) {
		PSWD = pSWD;
	}

	public String getNM() {
		return NM;
	}

	public void setNM(String nM) {
		NM = nM;
	}

	// public Long getID() {
	// return ID;
	// }
	//
	// public void setID(Long iD) {
	// ID = iD;
	// }
	//
	// public Long getGRP_ID() {
	// return GRP_ID;
	// }
	//
	// public void setGRP_ID(Long gRP_ID) {
	// GRP_ID = gRP_ID;
	// }
	//
	// public Date getCRT_TM() {
	// return CRT_TM;
	// }
	//
	// public void setCRT_TM(Date cRT_TM) {
	// CRT_TM = cRT_TM;
	// }
	//
	// public Long getST() {
	// return ST;
	// }
	//
	// public void setST(Long sT) {
	// ST = sT;
	// }
	//
	// public String getUSR_DESC() {
	// return USR_DESC;
	// }
	//
	// public void setUSR_DESC(String uSR_DESC) {
	// USR_DESC = uSR_DESC;
	// }
	//
	// public String getTP() {
	// return TP;
	// }
	//
	// public void setTP(String tP) {
	// TP = tP;
	// }
	//
	// public Long getIP() {
	// return IP;
	// }
	//
	// public void setIP(Long iP) {
	// IP = iP;
	// }
	//
	// public Date getLOG_TM() {
	// return LOG_TM;
	// }
	//
	// public void setLOG_TM(Date lOG_TM) {
	// LOG_TM = lOG_TM;
	// }
	//
	// public String getMBL_NO() {
	// return MBL_NO;
	// }
	//
	// public void setMBL_NO(String mBL_NO) {
	// MBL_NO = mBL_NO;
	// }
	//
	// public String getUNCM_NO() {
	// return UNCM_NO;
	// }
	//
	// public void setUNCM_NO(String uNCM_NO) {
	// UNCM_NO = uNCM_NO;
	// }
	//
	// public Long getLMT_AMNT() {
	// return LMT_AMNT;
	// }
	//
	// public void setLMT_AMNT(Long lMT_AMNT) {
	// LMT_AMNT = lMT_AMNT;
	// }
	//
	// public Long getSEND_NO() {
	// return SEND_NO;
	// }
	//
	// public void setSEND_NO(Long sEND_NO) {
	// SEND_NO = sEND_NO;
	// }
	//
	// public String getOLD_PSWD() {
	// return OLD_PSWD;
	// }
	//
	// public void setOLD_PSWD(String oLD_PSWD) {
	// OLD_PSWD = oLD_PSWD;
	// }
	//
	// public Long getTRY_TMS() {
	// return TRY_TMS;
	// }
	//
	// public void setTRY_TMS(Long tRY_TMS) {
	// TRY_TMS = tRY_TMS;
	// }
	//
	// public Date getTRY_TM() {
	// return TRY_TM;
	// }
	//
	// public void setTRY_TM(Date tRY_TM) {
	// TRY_TM = tRY_TM;
	// }
}
