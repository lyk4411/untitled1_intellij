package com.cfets.sms.rest.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SmsUtil {
	private static Logger logger = LogManager.getLogger(SmsUtil.class);

	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		logger.info("isMobileNO");
		return m.matches();
	}

	public static boolean isUniconNum(String unionNum) {
		boolean result = false;
		for (int i = 0; i < unionMobileStartNumber.length; i++) {
			if (unionNum.startsWith(unionMobileStartNumber[i])) {
				result = true;
				break;
			}
		}
		logger.info("isUniconNum");
		return result;
	}

	public static boolean isMatchUniconSmsFormat(String message) {
		boolean result = false;
		for (int i = 0; i < unionMobileSmsFormat.length; i++) {
			// if (message.startsWith("【中国外汇交易中心】" + unionMobileSmsFormat[i])) {
			if (message.startsWith(unionMobileSmsFormat[i])) {
				result = true;
				break;
			}
		}
		logger.info("isMatchUniconSmsFormat");

		return result;
	}

	private static String[] unionMobileStartNumber;
	private static String[] unionMobileSmsFormat;

	

		
}
