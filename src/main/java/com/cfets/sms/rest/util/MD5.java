package com.cfets.sms.rest.util;

import java.security.MessageDigest;

public class MD5 {
	// ------------------------------ FIELDS ------------------------------
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	// -------------------------- STATIC METHODS --------------------------
	public static String MD5Encode(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);

			MessageDigest md = MessageDigest.getInstance("MD5");

			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
		}

		return resultString;
	}

	/**
	 * ת���ֽ�����Ϊ16�����ַ���
	 *
	 * @param b
	 *            �ֽ�����
	 *
	 * @return 16�����ַ���
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;

		if (n < 0) {
			n = 256 + n;
		}

		int d1 = n / 16;
		int d2 = n % 16;

		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 *	����ض��ַ�ƴ��תMD5 
	 *	origin Դ�ַ�
	 *	str	�ض��ַ� 
	 * */
	public static String toMD5(String origin, String str) {
		String resultString = null;

		try {
			resultString = new String(origin + str);

			MessageDigest md = MessageDigest.getInstance("MD5");

			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes()));
		} catch (Exception ex) {
		}

		return resultString;
	}
}
