package com.cfets.sms.rest.util;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author JiangDeliang
 * @date Jun 3, 2015
 */
public class CommonUtils {
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	// private static String mobileNumPatternStr =
	// "^(((86)|(\\+86))?(13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
	private static String mobileNumPatternStr = "^1\\d{10}$";
	private static String chinaAreaCodePatterStr = "((\\+)?86)(.)+";

	public static String formatNull(Object o) {
		return formatNull(o, "");
	}

	public static String formatNull(Object o, String nullValue) {
		if (o == null) {
			return nullValue;
		}
		return o.toString();
	}

	public static boolean isValidPhoneNumber(String phoneNum) {
		Pattern pattern = Pattern.compile(mobileNumPatternStr);
		Matcher matcher = pattern.matcher(phoneNum);
		logger.info("是否合法手机号。");
		return matcher.matches();
	}

	public static String formatPhoneNum(String phoneNum) {
		String result = null;
		Pattern pattern = Pattern.compile(chinaAreaCodePatterStr);
		Matcher matcher = pattern.matcher(phoneNum);
		if (matcher.matches()) {
			result = phoneNum.substring(matcher.end(1));
		} else {
			result = phoneNum;
		}
		return result;
	}

	public static String SHA_1_Encode(String str) {
		StringBuffer buf = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("SHA-1");
			md5.update(str.getBytes());
			byte bytes[] = md5.digest();
			for (int i = 0; i < bytes.length; i++) {
				String s = Integer.toHexString(bytes[i] & 0xff);
				if (s.length() == 1) {
					buf.append("0");
				}
				buf.append(s);
			}

		} catch (Exception ex) {
		}
		return buf.toString();
	}

}
