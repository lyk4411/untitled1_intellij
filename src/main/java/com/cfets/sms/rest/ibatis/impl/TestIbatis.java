package com.cfets.sms.rest.ibatis.impl;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.cfets.common.constants.CommonConstants;
import com.cfets.sms.rest.entity.OutBoxModel;
import com.cfets.sms.rest.entity.SendTaskModel;
import com.cfets.sms.rest.entity.TokenModel;
import com.cfets.sms.rest.entity.User;
import com.cfets.sms.rest.util.MD5;
import com.cfets.sms.rest.util.Utils;

public class TestIbatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Charset.defaultCharset().name());
		System.out.println(Utils.toSHA2("123456",
				CommonConstants.SHA2_ADMIN_USER_PASSWORD));
		System.out.println(Utils.toSHA2("aaaa1111",
				CommonConstants.SHA2_ADMIN_USER_PASSWORD));
		System.out.println("�ӿ��û�");

		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		ts.setMinutes(ts.getMinutes()-1);
		System.out.println(ts);

//		List<User> a = new ArrayList<User>();
//		User b = new User();
//		b.setID((long) 1);
//		b.setMBL_NO("1");
//		b.setNM("1");
//		a.add(b);
//		System.out.println(a.get(0));
//		System.out.println(a.get(0));
//
//		TokenModel tm = new TokenModel();
//		if (tm != null) {
//			System.out.println(tm.getToken());
//			System.out.println(tm.getExpire_date());
//			System.out.println(tm.getUsername());
//		}

		// Timestamp d_time = new Timestamp(System.currentTimeMillis());
		// long expire_time = ((long) d_time.getTime() / 1000) + 86400;
		// System.out.println("expire_time"+expire_time);
		// d_time.setTime(expire_time * 1000);
		// System.out.println("d_time"+d_time);
		//
		//
		// Map map = new HashMap();
		// map.put("a", "aaaa");
		// map.put("b", "bbbb");
		// System.out.println(String.valueOf(map));
		//
		// while(true) {
		// tokenAllImpl tai = new tokenAllImpl();
		//
		// SendTaskImpl sti = new SendTaskImpl();
		// OutBoxImpl obi = new OutBoxImpl();
		// tai.selectTokenModelByUsernameAndCurrentTime("hello", new
		// Timestamp(System.currentTimeMillis()));
		// }
		// User user = ui.selectUserByUsername("�ӿ��û�");
		// System.out.println(user.getMBL_NO());
		// System.out.println(user.getUNCM_NO());
		//
		// OutBoxModel obm = new OutBoxModel();
		// obm = obi.selectOutBoxByTaskID((long) 90);
		//
		// System.out.println(obm.getCNTNT());
		// System.out.println(obm.toString());

		// SendTaskModel sm = new SendTaskModel();
		// sm.setContent("aaaa");
		// sm.setCount(1);
		// sm.setPhonenumber("13816480967");
		// sm.setSendTime(new Timestamp(System.currentTimeMillis()));
		// sm.setSubbmitTime(new Timestamp(System.currentTimeMillis()));
		// sm.setUserid((long) 1);
		// //
		// sti.addSendTask(sm);
		//
		// System.out.println(sm.getId());

		//
		// TokenModel tm = tai.selectTokenModelByToken();
		//
		// System.out.println(tm.getExpire_date());
		// System.out.println(tm.getUsername());
		// System.out.println(tm.getToken());
		//
		// TokenModel tm1 = tai.selectTokenModelByTokenValue("bbbb");
		//
		// System.out.println(tm1.getExpire_date());
		// System.out.println(tm1.getUsername());
		// System.out.println(tm1.getToken());
		//
		// TokenModel tm2 = new TokenModel();
		// tm2.setToken("cccc");
		// tm2.setUsername("hhhh");
		// tm2.setExpire_date(new Timestamp(System.currentTimeMillis()));

		// tai.addToken(tm2);
		// tai.updateTokenModelByToken(tm2);

		// java.util.Date utilDate = new java.util.Date();
		// System.out
		// .println("==========================================================");
		// System.out.println(utilDate);
		//
		// java.sql.Timestamp stp=new java.sql.Timestamp(utilDate.getTime());
		// System.out.println("stp:"+stp);
		//
		// TokenModel tm3 = tai.selectTokenModelByUsernameAndCurrentTime(
		// "liu", stp);
		// if (tm3 != null) {
		// System.out.println("tm3:"+tm3.getUsername());
		// System.out.println("tm3:"+tm3.getToken());
		// System.out.println("tm3:"+tm3.getExpire_date());
		// Timestamp current_time = new Timestamp(System.currentTimeMillis());
		// tm3.setExpire_date(current_time);
		// tai.updateTokenInvalidate(tm3);
		// } else {
		// tm3 = new TokenModel();
		// System.out.println("empty");
		// tm3.setToken("asdfafasfg");
		// tm3.setUsername("liu");
		// tm3.setExpire_date(stp);
		// tai.addToken(tm3);
		// }
		// System.out
		// .println("==========================================================");

		// User mohuLists = ui.selectUserByUsername("�ӿ��û�");
		// System.out.println(mohuLists.getNM());
		// System.out.println(mohuLists.getPSWD());
		// System.out.println(mohuLists.getID());
		// System.out.println(mohuLists.getTP());
		//
		// Long id = ui.GetUseridFromUserName("�ӿ��û�");
		// System.out.println("id:" + id);
		//
		// Map map = new HashMap();
		// map.put("USR_NM", "liuyongkai");
		// map.put("PSWD", "aaaa");
		//
		// User m1 = ui.selectUserByUsernameAndPassword(map);
		// System.out.println(m1.getNM());
		// System.out.println(m1.getPSWD());
		// System.out.println(m1.getUSR_NM());
		//
		// Map map1 = new HashMap();
		// TokenModel tm =
		// tai.tokenIsValidate("fd56f04dbe5f887e1f896d6fc64cd4e7111d8a63");
		// System.out.println("bo:" + tm.getUsername());
		// System.out.println("bo:" + tm.getToken());
	}

}
