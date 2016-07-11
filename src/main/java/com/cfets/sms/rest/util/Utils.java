package com.cfets.sms.rest.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
//import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
//import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
//import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.struts2.ServletActionContext;

//import com.chinamoney.commodity.entity.Commodity;
//import com.chinamoney.user.action.UserConsultAction;

/**
 * 
 * <li>描述:公用�?/li><br> <li>This is about <code>Utils</code></li>
 * 
 * @author eric
 * @version 1.0
 * @date 2011-6-22 下午04:36:55
 */
@SuppressWarnings({ "unchecked", "static-access" })
public class Utils {
	private static final Log log = LogFactory.getLog(Utils.class);
	// 默认除法运算精度,即保留小数点多少�?
	private static final int DEFAULT_DIV_SCALE = 10;

	public static final int SINGLE_SMS_LENGTH = 67;
	public static final int SMS_LENGTH = 70;
	public static final int MAX_SMS_LENGTH = 300;

	/**
	 * 取出字符�?[1,2,3]中最大��?
	 * */
	public static int getMaxValue(String str) {
		int max = 0;
		// String values=null;
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] strs = str.split(",");
		for (String s : strs) {
			if (max < Integer.parseInt(Utils.trim(s))) {
				max = Integer.parseInt(Utils.trim(s));
			}
		}

		return max;
	}

	/**
	 * 判断字符串数组中是否包含某字符串元素
	 * 
	 * @param substring
	 * @param source
	 * @return
	 */
	public static boolean isIn(String substring, String[] source) {
		for (int i = 0; i < source.length; i++) {
			if (source[i].trim().equals(substring)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 对list棢�查是否包含某元素
	 * 
	 * @author zhouxy
	 * @param list
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static boolean isItEquals(List list, String str) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			if (str.trim().equals(list.get(i).toString())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 数据库表记录主键�?
	 */
	public static String getTablePK() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	/**
	 * 生成制定位随机数�?
	 */
	public static String randomNumeric(int i) {
		return RandomStringUtils.randomNumeric(i);
	}

	/**
	 * //保留小数点后3位（四舍五入），且不按科学计数法输出
	 * */
	public static String FormatPrice(double price, int i) {
		String revalue = null;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(i);
		df.setMinimumFractionDigits(i);
		revalue = df.format(price);
		revalue = revalue.replaceAll(",", "");
		return revalue;
	}

	/**
	 * 生成制定位随机字母和数字 生成优惠券号用此（去除了�?’，�?’，‘I’，‘O’）
	 */
	public static String randomAlphanumeric(int i) {
		return RandomStringUtils.random(i, new char[] { '2', '3', '4', '5',
				'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' });
		// return RandomStringUtils.randomAlphanumeric(i);
	}

	/**
	 * 判断字符串是否是GB2312编码�?
	 * */
	public static boolean isGB2312(String str) {
		if (Utils.isObjectNotEmpty(str)) {
			return java.nio.charset.Charset.forName("GB2312").newEncoder()
					.canEncode(str);
		} else {
			return false;
		}
	}

	/**
	 * 获得字符串的实际长度 GBK 编码格式 中文占两个字�?
	 * */
	public static int getStrLenth(String str) {
		if (str == null || str.length() < 0) {
			return 0;
		}
		int len = 0;
		char c;
		for (int i = str.length() - 1; i >= 0; i--) {
			c = str.charAt(i);
			if (c > 255) {
				len += 2;
			} else {
				len++;
			}
		}
		return len;
	}

	/**
	 * 将字符串数字转化为int型数�?
	 * 
	 * @param str�
	 *            �转化字符串
	 * @param defValue�
	 *            �化失败后的默认�?
	 * @return int
	 */
	public static int parseInt(String str, int defValue) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static long parseLong(String str, long defValue) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	public static Long strToLong(String str, Long defValue) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 将字符串数字转化为double型数�?
	 * 
	 * @param str�
	 *            �转化字符串
	 * @param defValue�
	 *            �化失败后的默认�?
	 * @return double
	 */
	public static double parseDouble(String str, double defValue) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 棢�测字符串是否为空
	 */
	public static boolean strIsNull(String str) {
		return ((str == null) || "".equals(str) || "null".equalsIgnoreCase(str));
	}

	/**
	 * 去空格，如为null则转化为空字符串
	 */
	public static String trim(String str) {
		if (str == null || "null".equalsIgnoreCase(str)
				|| "undefined".equalsIgnoreCase(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "'a','b','c'"
	 */
	public static String getRecordIds(String[] recordIds) {
		if (recordIds == null || recordIds.length == 0)
			return "";
		if (recordIds.length == 1)
			return recordIds[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < recordIds.length; i++) {
			if (i == recordIds.length - 1) {
				ids.append("'" + recordIds[i] + "'");
			} else {
				ids.append("'" + recordIds[i] + "'" + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrs(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i].trim());
			} else {
				ids.append(strs[i].trim() + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrsRep(String[] strs, String rep, String newStr) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i].replace(rep, newStr));
			} else {
				ids.append(strs[i].replace(rep, newStr) + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrsBySplit(String[] strs, String split) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i]);
			} else {
				ids.append(strs[i] + split);
			}
		}
		return ids.toString();
	}

	/**
	 * 处理Url与其参数的组�?
	 * 
	 * @param url页面Url
	 * @param param�
	 *            �加入到该Url后的参数
	 * @return 丢�个完整的Url,包括参数
	 */
	public static String dealUrl(String url, String param) {
		if (url == null || url.length() < 1)
			return "";
		url = url.trim();
		if (param == null || param.length() < 1)
			return url;
		param = param.trim();
		if (url.endsWith("?") || url.endsWith("&")) {
			url = url.substring(0, url.length() - 1);
		}
		if (url.indexOf("?") != -1) {
			if (param.startsWith("&") || param.startsWith("?")) {
				return url + param.substring(1);
			} else {
				return url + "&" + param;
			}
		} else {
			if (param.startsWith("&") || param.startsWith("?")) {
				return url + "?" + param.substring(1);
			} else {
				return url + "?" + param;
			}
		}
	}

	/**
	 * 得到指定符号前或后的字符
	 */
	// private static String getPreOrSufStr(String str, int action) {
	// if (str == null && "".equals(str))
	// return "";
	// int index = -1;
	// if ((index = str.indexOf(Constants.SPLIT_SIGN)) != -1) {
	// if (action == 0)
	// return str.substring(index + 1).trim();
	// return str.substring(0, index).trim();
	// }
	// return str;
	// }

	/**
	 * 得到指定符号前的字符
	 */
	// public static String getPreStr(String str) {
	// return getPreOrSufStr(str, 1);
	// }
	//
	// /**
	// * 得到指定符号后的字符
	// */
	// public static String getSufStr(String str) {
	// return getPreOrSufStr(str, 0);
	// }

	/**
	 * 验证EMAIL方法
	 * 
	 * @param str
	 *            被验证的email字符�?
	 * @return 成功返回true 失败返回false
	 */
	public static boolean isEmail(String str) {
		if (str == null)
			return false;
		str = str.trim();
		if (str.length() < 6)
			return false;
		return true;
	}

	public static boolean isEmail(String value, String expression) {

		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(value);

		return matcher.find();
	}

	/**
	 * 在不足len位的数字前面自动补零
	 */
	public static String getLimitLenStr(String str, int len) {
		if (str == null) {
			return "";
		}
		while (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 字符串GBK到UTF-8码的转化
	 * 
	 * @param inStr
	 *            GBK编码的字符串
	 * @return UTF-8编码的字符串
	 */
	public static String wapGbkToUtf(String inStr) {
		char temChr;
		int ascInt;
		int i;
		String result = new String("");
		if (inStr == null) {
			inStr = "";
		}
		for (i = 0; i < inStr.length(); i++) {
			temChr = inStr.charAt(i);
			ascInt = temChr + 0;
			if (ascInt > 255) {
				result = result + "&#x" + Integer.toHexString(ascInt) + ";";
			} else {
				result = result + temChr;
			}
		}
		return result;
	}

	/**
	 * 特殊字符替换
	 */
	public static String replaceStrHtml(String inStr) {
		String result = inStr;
		if (result != null && !("".equals(result))) {
			result = result.replaceAll("\r\n", "<br>");
			result = result.replaceAll(" ", "&nbsp;");
		}
		return result;
	}

	/**
	 * 特殊字符&替换&amp;
	 */

	public static String replaceStrForWap(String inStr) {
		String result = inStr;
		if (!Utils.strIsNull(inStr)) {
			result = result.replaceAll("&amp;", "&");
			result = result.replaceAll("&", "&amp;");
		}
		return result;
	}

	/**
	 * 判断对象是否为null�?"(条件成立则返回ture,否则返回false)
	 * 
	 * @param objects
	 * @return
	 */
	public static boolean isObjectEmpty(Object objects) {
		// if (objects == null || objects.equals("")) {
		// return true;
		// }
		if (objects == null || "".equals(objects)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否不为null�?"(条件成立则返回ture,否则返回false)
	 * 
	 * @param objects
	 * @return
	 */
	public static boolean isObjectNotEmpty(Object objects) {
		return !isObjectEmpty(objects);
	}

	// ------------------------------用户请求数据-----------------------------------

	/**
	 * 得到当前请求的URL
	 * 
	 * @param request
	 * @return
	 */
	public static String getActionURL(HttpServletRequest req) {
		// 请求地址
		String hearderString = req.getHeader("referer");
		String path = req.getContextPath();
		Integer port = req.getServerPort();
		StringBuffer sbf = new StringBuffer();
		if (port.compareTo(80) != 0) {
			sbf.append(req.getScheme()).append("://")
					.append(req.getServerName()).append(":")
					.append(req.getServerPort() + path).append("/");
		} else {
			sbf.append(req.getScheme()).append("://")
					.append(req.getServerName()).append(path).append("/");
		}
		return hearderString.substring(sbf.length());
	}

	/**
	 * 得到客户端请求IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		try {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			return ip;
		} catch (Exception e) {
			log.error("Utils-getIpAddr==>", e);
			return null;
		}
	}

	/***
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// Cookie 数据获得
	// public static String getCookieValue(Cookie[] cookies, String str) {
	// String result = null;
	// if (Utils.isObjectNotEmpty(cookies)) {
	// for (Cookie cookie : cookies) {
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookie.getName().equals(str)) {
	// result = cookie.getValue();
	// break;
	// }
	// }
	// }
	// return result;
	// }
	//
	// // 获取前缀COOKIE名称列表
	// public static ArrayList getCookieByPrefix(HttpServletRequest req,
	// String prefix) {
	// Cookie[] cookies = req.getCookies();
	// ArrayList al = new ArrayList();
	// if (cookies != null) {
	// for (int i = 0; i < cookies.length; i++) {
	// Cookie cookie = cookies[i];
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookie.getName().startsWith(prefix)) {
	// al.add(cookie.getName());
	// }
	// }
	// }
	// return al;
	// }
	//
	// /**
	// * 获取指定名字的Cookie值，找不到则返回null
	// *
	// * @return 成功返回 Cookie的��? 否则返回 null
	// */
	// public static String getCookie(HttpServletRequest req, String cookieName)
	// {
	// String result = null;
	// Cookie[] cookies = req.getCookies();
	// if (cookies != null) {
	// for (int i = 0; i < cookies.length; i++) {
	// Cookie cookie = cookies[i];
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookieName.equals(cookie.getName())) {
	// result = cookie.getValue();
	// break;
	// }
	// }
	// }
	// return result;
	// }
	//
	// /**
	// * 获取指定名字的Cookie值，找不到则返回null
	// *
	// * @return 成功返回 Cookie的��? 否则返回 null
	// */
	// public static String getCookieWithDomain(HttpServletRequest req,
	// String cookieName) {
	// String result = null;
	// Cookie[] cookies = req.getCookies();
	// if (cookies != null) {
	// for (int i = 0; i < cookies.length; i++) {
	// Cookie cookie = cookies[i];
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookieName.equals(cookie.getName())) {
	// result = cookie.getValue();
	// break;
	// }
	// }
	// }
	// return result;
	// }

	// /**
	// * 获取指定名字弢�头的Cookie值列表，找不到则返回null
	// *
	// * @return 成功返回 Cookie的��? 否则返回 null
	// */
	// public static List<String> getCookies(HttpServletRequest req,
	// String startwith) {
	// List<String> list = new ArrayList<String>();
	// Cookie[] cookies = req.getCookies();
	// if (cookies != null) {
	// for (int i = 0; i < cookies.length; i++) {
	// Cookie cookie = cookies[i];
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookie.getName().startsWith(startwith)) {
	// list.add(cookie.getValue());
	// // break;
	// }
	// }
	// }
	// return list;
	// }
	//
	// /**
	// * 添加 cookie
	// *
	// * @param resp
	// * resp
	// */
	// public static Cookie addCookie(HttpServletResponse resp, String key,
	// String value) {
	// resp.setHeader("P3P", "CP=CAO PSA OUR");
	// Cookie u = new Cookie(key, value);
	// u.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// u.setPath("/");
	// u.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// u.setMaxAge(Constants.COOKIE_MAX_AGE * 60 * 60);
	// resp.addCookie(u);
	// u = null;
	// return u;
	// }
	//
	// public static void addCookie(HttpServletResponse resp, String key,
	// String value, int maxage) {
	// resp.setHeader("P3P", "CP=CAO PSA OUR");
	// Cookie cookie = new Cookie(key, value);
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// cookie.setMaxAge(maxage);
	// resp.addCookie(cookie);
	// cookie = null;
	// }
	//
	// /**
	// * 清除前缀的的cookie
	// * */
	// public static void clearCookieByPrefix(HttpServletRequest req,
	// HttpServletResponse resp, String prefix) {
	// Cookie[] cookies = req.getCookies();
	// if (cookies != null) {
	// for (int i = 0; i < cookies.length; i++) {
	// Cookie cookie = cookies[i];
	// cookie.setPath("/");
	// cookie.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// if (cookie.getName().startsWith(prefix)) {
	// Utils.clearCookie(resp, cookie.getName());
	// }
	// }
	// }
	// }
	//
	// /**
	// * 清除COOKIE
	// *
	// * @param resp
	// */
	// public static void clearCookie(HttpServletResponse resp, String key) {
	// resp.setHeader("P3P", "CP=CAO PSA OUR");
	// Cookie u = new Cookie(key, null);
	// u.setPath("/");
	// u.setDomain(Constants.COOKIE_PREFIX_DOMAIN);
	// u.setMaxAge(0);
	// resp.addCookie(u);
	// u = null;
	//
	// }

	// 根据Map输出JSON，返回null
	// public static String ajaxJson(Map<String, String> jsonMap) {
	// JSONObject jsonObject = JSONObject.fromObject(jsonMap);
	// return ajax(jsonObject.toString(), "text/html");
	// }
	//
	// // 根据Map输出JSON，返回null
	// public static String ajaxJsonObject(Map<String, Object> jsonMap) {
	// JSONObject jsonObject = JSONObject.fromObject(jsonMap);
	// return ajax(jsonObject.toString(), "text/html");
	// }
	//
	// // 根据Object输出JSON，返回null
	// public static String ajaxJsonObj(Object obj) {
	// JSONObject jsonObject = JSONObject.fromObject(obj);
	// return ajax(jsonObject.toString(), "text/html");
	// }
	//
	// // 根据List输出JSON，返回NULL
	// public static String ajaxJson(List list) {
	// JSONArray jsonArray = new JSONArray();
	// if (Utils.isObjectNotEmpty(list)) {
	// jsonArray.addAll(list);
	// }
	// return ajax(jsonArray.toString(), "text/html");
	// }

	// AJAX输出，返回null
	// public static String ajax(String content, String type) {
	// try {
	// HttpServletResponse response = ServletActionContext.getResponse();
	// response.setContentType(type + ";charset=UTF-8");
	// response.setHeader("Pragma", "No-cache");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setDateHeader("Expires", 0);
	// response.getWriter().write(content);
	// response.getWriter().flush();
	// } catch (IOException e) {
	// log.error("Utils-ajax==>", e);
	// }
	// return null;
	// }

	// -------------------------日期处理----------------------------------------------

	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Format the specified date using the specified format String. The format
	 * String follows the rules specified in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 * 
	 * @param 输入日期
	 * @param 输入�
	 *            �换 (规则)格式
	 * @return 返回日期字符�?
	 */

	public static String format(Date date, String format) {
		if (date == null || date.equals(""))
			return null;
		SimpleDateFormat sft = new SimpleDateFormat(format);
		return sft.format(date);
	}

	/**
	 * Parse the specified date String using the specified format String. The
	 * format String follows the rules specified in the
	 * <code>java.text.SimpleDateFormat</code> class.
	 * 
	 * @param 输入字�
	 *            ��型日�? ,�?2007-2-20
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 * @return 返回日期
	 * @throws ParseException
	 */

	public static Date parse(String date, String format) throws ParseException {
		SimpleDateFormat sft = new SimpleDateFormat(format);
		return sft.parse(date);
	}

	/**
	 * 获得系统当前时间,以分隔符"-"分开
	 * 
	 * @return返回当前系统日期 �?当前时间�?007�?0�?5�?则��过该函数得到的字符串为"2007-10-15"
	 */
	public String getToday() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 获得系统当前时间,以分隔符"-"分开
	 * 
	 * @return返回当前系统时间 �?当前时间�?007�?0�?5�?1�?5�?5�?
	 *                     则��过该函数得到的字符串为"2007-10-15-21-45-25"
	 */
	public String getTimeNoSeparate() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyy-MM-dd-HH-mm-ss");
	}

	/**
	 * 获得当前系统时间字符�?
	 * 
	 * @return 返回当前系统时间字符�?精确到秒 �?当前时间�?007�?0�?5�?1�?5�?5�?
	 *         则��过该函数得到的字符串为"20071015214525"
	 */
	public static String getTime() {
		GregorianCalendar gc = new GregorianCalendar();
		return format(gc.getTime(), "yyyyMMddHHmmss");
	}

	/**
	 * 获得当前日期字符�?格式:20071015
	 * 
	 * @return 当前日期字符�?
	 */
	public String getNow() {
		GregorianCalendar gc = new GregorianCalendar();
		return this.format(gc.getTime(), "yyyyMMdd");
	}

	/**
	 * 获得当前日期Date
	 * 
	 * @return Date
	 */
	public Date getDate() {
		GregorianCalendar gc = new GregorianCalendar();
		return gc.getTime();
	}

	/**
	 * 得到当前时间加上多少分钟以后的时�?
	 * 
	 * @param minute
	 * @return
	 */
	public long getTimeMillisOfAddMinute(Long num, int minute) {
		Long t = num + minute * 1000 * 60;
		return t;
	}

	/**
	 * 获得当前时间Timestamp类型
	 */
	public Timestamp getNowTime() {
		GregorianCalendar gc = new GregorianCalendar();
		Timestamp time = new Timestamp(gc.getTimeInMillis());
		return time;
	}

	/**
	 * @param 输入字�
	 *            ��型日�? ,�?2007-2-20
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 * @return 返回日期
	 */
	public Date format(String str, String format) {
		Date result = null;
		try {
			str += " ";
			int endStr = str.indexOf(" ");
			String dateString = str.substring(0, endStr);
			result = this.parse(dateString, format);
		} catch (Exception ex) {
			log.error("Utils-format==>", ex);
		}
		return result;
	}

	/**
	 * 得到当前时间
	 * 
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getNow(String format) {
		Calendar cal = Calendar.getInstance();
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少天以前的日期(负数表示多少天以后的日期)
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getDayNumOfDate(int dayNum, String format) {
		int day = -dayNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少天以前的日期(负数表示多少天以后的日期)
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public Date getDayNumOfDate(int dayNum) {
		int day = -dayNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 得到指定的日期以前多少天
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getDayNumOfAppointDate(Date appointDate, int dayNum,
			String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DATE, -dayNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到指定的日期以前多少天
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public static Date getDayNumOfAppointDate(Date appointDate, int dayNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DATE, -dayNum);
		return cal.getTime();
	}

	/**
	 * 得到指定的日期以前多少天
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getMonthNumOfAppointDate(Date appointDate, int monthNum,
			String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.MONTH, -monthNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 根据指定的日期得到多少个月以前的日期
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public static Date getMonthNumOfAppointDate(Date appointDate, int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(appointDate);
		cal.add(Calendar.DAY_OF_MONTH, -monthNum);
		return cal.getTime();
	}

	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getMonthNumOfMonth(int monthNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, monthNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少月以前的日期
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getMonthNumOfMonth(int monthNum, int dateNum, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -monthNum);
		cal.add(Calendar.DATE, -dateNum);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到多少年以前的日期
	 * 
	 * @param输入int�?
	 * @param 输入字�
	 *            ��型日期的排列规则 ,�?yyyy-MM-dd,MM/dd/yyyy.
	 *            根据上述输入字符型日�?此处应填写的规则�?yyyy-MM-dd
	 */
	public String getYearNumOfYear(int yearNum, String format) {
		int year = -yearNum;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, year);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到上一月的第一�?
	 * 
	 * @param format
	 * @return
	 */
	public String getStartOfLastMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到第num个月后的第一�?负数表示�?正为�?
	 * 
	 * @param format
	 * @return
	 */
	public String getStartOfMonth(int num, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, num);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到当月的第丢��?
	 * 
	 * @param format
	 * @return
	 */
	public String getStartOfMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到当月的第丢��?
	 * 
	 * @param format
	 * @return
	 */
	public String getStartOfMonth_test(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 得到下一月的第一�?
	 * 
	 * @param format
	 * @return
	 */
	public String getStartOfNextMonth(String format) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DATE, 1);
		return this.format(cal.getTime(), format);
	}

	/**
	 * 加一�?
	 * 
	 * @return
	 */
	public String getYears() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(1, +1);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH),
				gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 加半�?
	 * 
	 * @return
	 */
	public String getHalfYear() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(2, +6);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH),
				gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 加一个季�?
	 * 
	 * @return
	 */
	public String getQuarters() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(gc.getTime());
		gc.add(2, +3);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH),
				gc.get(Calendar.DATE));
		return sf.format(gc.getTime());
	}

	/**
	 * 返回yyyy-MM-dd格式的字符串
	 * 
	 * @return
	 */
	public String getLocalDate() {
		GregorianCalendar gc = new GregorianCalendar();
		return sf.format(gc.getTime());
	}

	/**
	 * 日期转换("yyyy-MM-dd")
	 */
	public static final Date parseDate(String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			log.error("Utils-parseDate==>", e);
		}
		return null;
	}

	/**
	 * 日期转换("yyyy-MM-dd")
	 */
	public static final Date parseDate(String dateStr, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			log.error("Utils-parseDate==>", e);
		}
		return null;
	}

	/**
	 * 6位精�?
	 * 
	 * @param orderAmount
	 * @return
	 */
	public static BigDecimal getFinanceScaleBigDecimal(BigDecimal amount) {
		// 2位小�?
		Integer orderScale = 6;
		// 小数位精确方式（四舍五入、向上取整��向下取整）
		int orderRoundType = BigDecimal.ROUND_HALF_UP;
		try {
			return amount.setScale(orderScale, orderRoundType);
		} catch (Exception e) {
			return new BigDecimal("0");
		}
	}

	/**
	 * 按照概率生成对应的随机数 <br>
	 * 例如: int[] arr = {70, 20, 10} 生成的随机数:0(概率�?0%) 生成的随机数:1(概率�?0%)
	 * 生成的随机数:2(概率�?0%)
	 * 
	 * @param arr
	 * @return i 返回下标: 0,1,2 ...
	 */
	public static int weightRandom(Integer[] arr) {
		int x = (int) (Math.random() * 100);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > x) {
				return i;
			}
		}
		return -1;
	}

	/****
	 * 验证 Integer类型
	 * 
	 * @param i
	 * @return
	 */
	public static boolean isBlank(Integer i) {
		if (i == null) {
			return true;
		}
		return false;
	}

	public static boolean isBlank(Double i) {
		if (i == null) {
			return true;
		}
		return false;
	}

	public static BigDecimal doubleToBigDecimal(Double d) {
		try {
			return new BigDecimal(d.toString());
		} catch (Exception e) {
			return new BigDecimal("0");
		}
	}

	/****
	 * 返回""字符
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		try {
			if (StringUtils.isBlank(str)) {
				return "";
			}
		} catch (Exception e) {
			return "";
		}
		return str.trim();
	}

	public static String getSplit0(String str) {
		try {
			return str.split("-")[0];
		} catch (Exception e) {
			return str;
		}
	}

	public static String getSplit1(String str) {
		try {
			return str.split("-")[1];
		} catch (Exception e) {
			return str;
		}
	}

	/***
	 * l == null || l.size() <= 0 返回 true
	 * 
	 * @param l
	 * @return
	 */
	public static boolean isEmptyList(List<?> l) {
		if (l == null || l.size() <= 0) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmptyList(List<?> l) {
		if (l != null && l.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 提供精确的加法运算��?
	 * 
	 * @param v1
	 *            被加�?
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.add(b2)).doubleValue();
	}

	/**
	 * 提供精确的减法运算��?
	 * 
	 * @param v1
	 *            被减�?
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.subtract(b2)).doubleValue();
	}

	/**
	 * 提供精确的乘法运算��?
	 * 
	 * @param v1
	 *            被乘�?
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.multiply(b2)).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后多少位，以后的数字四舍五入�?
	 * 
	 * @param v1
	 *            被除�?
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEFAULT_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算��当发生除不尽的情况时，由scale参数�?定精度，以后的数字四舍五入��?
	 * 
	 * @param v1
	 *            被除�?
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示霢�要精确到小数点以后几位��?
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			System.err.println("除法精度必须大于0!");
			return 0;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return (b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}

	/***
	 * 获得当前时间和传入时间相隔的秒数
	 * */
	public static long getSpacing(Date date1) {
		Date date = new Date();
		return (date.getTime() - date1.getTime()) / 1000;
	}

	/**
	 * 整理数据Double的小数位�?
	 * */
	public static double getDoubleByScale(Double v1, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		return b1.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/****
	 * 获取指定日期 minute分钟后的时间
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date getTimeAfterMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minute);
		return c.getTime();
	}

	// GENERAL_PUNCTUATION 判断中文的��号
	// CJK_SYMBOLS_AND_PUNCTUATION 判断中文的��号
	// HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，�?
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/***
	 * 判断是否是英�?
	 * 
	 * @param strName
	 */
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length;) {
			char c = ch[i];
			if (isChinese(c) == true) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String toUTF8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 数字金额大写转换，��想先写个完整的然后将如零拾替换成零
	 * 
	 * 要用到正则表达式
	 */

	// public static String digitUppercase(double n) {
	//
	// String fraction[] = { "�?, "�? };
	//
	// String digit[] = { "�?, "�?, "�?, "�?, "�?, "�?, "�?, "�?, "�?, "�? };
	//
	// String unit[][] = { { "�?, "�?, "�? },
	//
	// { "", "�?, "�?, "�? } };
	//
	// String head = n < 0 ? "�? : "";
	//
	// n = Math.abs(n);
	//
	// String s = "";
	//
	// for (int i = 0; i < fraction.length; i++) {
	//
	// s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] +
	// fraction[i])
	// .replaceAll("(�?)+", "");
	//
	// }
	//
	// if (s.length() < 1) {
	//
	// s = "�?;
	//
	// }
	//
	// int integerPart = (int) Math.floor(n);
	//
	// for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
	//
	// String p = "";
	//
	// for (int j = 0; j < unit[1].length && n > 0; j++) {
	//
	// p = digit[integerPart % 10] + unit[1][j] + p;
	//
	// integerPart = integerPart / 10;
	//
	// }
	//
	// s = p.replaceAll("(�?)*�?", "").replaceAll("^$", "�?) + unit[0][i]
	// + s;
	//
	// }
	//
	// return head
	// + s.replaceAll("(�?)*零元", "�?).replaceFirst("(�?)+", "")
	// .replaceAll("(�?)+", "�?).replaceAll("^�?", "零元�?);
	//
	// }

	/**
	 * 获得配置文件扢�在目�?br>
	 * 
	 * @param file
	 * @return
	 */
	public static File getResource(String file) {
		URL url = Utils.class.getResource("");
		String pkg = "";
		if (Utils.class.getPackage() != null) {
			pkg = Utils.class.getPackage().getName();
		}
		String path = url.getPath();
		path = path.substring(0, path.length() - pkg.length() - 1);
		String fileSeparator = System.getProperty("link.properties");
		File rtn = new File(path + fileSeparator + file.trim());

		return rtn;
	}

	public static String getMacAddr() {
		String MacAddr = "";
		try {
			Enumeration<NetworkInterface> em = NetworkInterface
					.getNetworkInterfaces();
			while (em.hasMoreElements()) {
				NetworkInterface nic = em.nextElement();
				byte[] b = nic.getHardwareAddress();
				if (b == null) {
					continue;
				}
				for (int i = 0; i < b.length; i++) {
				}
			}
		} catch (SocketException e) {
			log.error("Utils-getMacAddr==>", e);
			System.exit(-1);
		}
		return MacAddr;
	}

	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface
					.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				Enumeration<?> e2 = ni.getInetAddresses();
				while (e2.hasMoreElements()) {
					InetAddress ia = (InetAddress) e2.nextElement();
					ip = ia.getHostAddress();
				}
			}
		} catch (SocketException e) {
			log.error("Utils-getLocalIP==>", e);
			System.exit(-1);
		}
		return ip;
	}

	/* 丢�个将字节转化为十六进制ASSIC码的函数 */
	public static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	public static String getArrayStr(String[] str, int i, String df) {
		try {
			if (str == null || str.length < i) {
				return df;
			} else {
				return str[i];
			}
		} catch (Exception e) {
			return df;
		}
	}

	public static int getArrayInt(String[] str, int i, int df) {
		try {
			if (str == null || str.length <= i) {
				return df;
			} else {
				return Integer.parseInt(str[i]);
			}

		} catch (Exception e) {
			return df;
		}
	}

	public static double getArrayDouble(String[] str, int i, double df) {
		try {
			if (str == null || str.length <= i) {
				return df;
			} else {
				return Double.parseDouble(str[i]);
			}
		} catch (Exception e) {
			return df;
		}
	}

	public static Integer long2Int(Long integral) {
		try {
			return integral.intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 
	 * @param UsedIntegral
	 * @return
	 */
	public static BigDecimal getIntegralAmount(Integer usedIntegral) {
		try {
			return new BigDecimal(usedIntegral.toString());
		} catch (Exception e) {
			return new BigDecimal("0");
		}
	}

	/**
	 * 此方法主要是为了排除当前时间是否在八点半活动�?
	 * 
	 * true�?表示不在此活动时间内 false：表示在活动时间�?
	 * */
	public static boolean isNotBetweenDate() {
		Date date = new Date();
		String str = Utils.format(date, "yyyy-MM-dd");
		try {
			Date date2 = Utils.parse(str + " 20:25:00", "yyyy-MM-dd HH:mm:ss");
			Date date3 = Utils.parse(str + " 22:00:15", "yyyy-MM-dd HH:mm:ss");
			if (date2.before(date) && date3.after(date)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/****
	 * 获取数组�?
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static String getArrayValue(String[] array, int index) {
		try {
			return array[index];
		} catch (Exception e) {
			return "";
		}
	}

	public static String md5ByHex(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte b[] = src.getBytes();
			md.reset();
			md.update(b);
			byte hash[] = md.digest();
			String hs = "";
			String stmp = "";
			for (int i = 0; i < hash.length; i++) {
				stmp = Integer.toHexString(hash[i] & 0xff);
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else
					hs = hs + stmp;
			}

			return hs.toUpperCase();
		} catch (Exception e) {
			return "";
		}
	}

	public static long strToLong(String str) {
		try {
			return Long.valueOf(str);
		} catch (Exception e) {
			return 0L;
		}
	}

	public static String UrlDecode(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static String UrlEnCode(String param) {
		try {
			return URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	// 保持长度 替换朢�后一个元�?
	public static String[] repArray(String[] array, String newStr, int len) {

		if (array == null || array.length <= 0) {
			return new String[] { newStr };
		}
		List<String> list = new ArrayList<String>();
		list.add(newStr);
		for (int i = 0; i < array.length; i++) {
			if (list.size() >= len) {
				break;
			}
			if (!array[i].equals(newStr)) {
				list.add(array[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	public static String[] repArrayStr(String[] array) {
		if (array == null || array.length <= 0) {
			return array;
		} else {
			for (int i = 0; i < array.length; i++) {
				array[0] = array[0].split("_")[0];
			}
			return array;
		}
	}

	/****
	 * 数组分页
	 * 
	 * @param strs
	 *            数组集合（ids�?
	 * @param pageSize
	 *            每页显示�?
	 * @param toPage
	 *            当前�?
	 * @param order
	 *            排序 0 asc 1 desc
	 * @return
	 */
	public static String[] getArray(String[] strs, int pageSize, int toPage,
			int order) {
		if (strs == null) {
			return new String[] {};
		}

		if (order == 1) {
			strs = arraySort(strs);
		}

		int start = 0;
		int end = 0;
		end = toPage * pageSize;
		if (end >= strs.length) {
			end = strs.length - start;
		}
		start = (toPage - 1) * pageSize;
		if (start > strs.length) {
			return new String[] {};
		}
		String[] ns = new String[(end - start)];
		System.arraycopy(strs, start, ns, 0, (end - start));
		return ns;
	}

	/***
	 * 数组倒序
	 * 
	 * @param strs
	 * @return
	 */
	public static String[] arraySort(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return new String[] {};
		}
		String[] newstr = new String[strs.length];
		int len = 0;
		for (int i = strs.length - 1; i >= 0; i--) {
			newstr[len] = strs[i];
			len++;
		}
		return newstr;
	}

	/**
	 * 是否是数�?
	 */
	public static boolean isNumber(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
		char[] chars = str.toCharArray();
		int sz = chars.length;
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		int start = (chars[0] == '-') ? 1 : 0;
		if (sz > start + 1) {
			if (chars[start] == '0' && chars[start + 1] == 'x') {
				int i = start + 2;
				if (i == sz) {
					return false; // str == "0x"
				}
				for (; i < chars.length; i++) {
					if ((chars[i] < '0' || chars[i] > '9')
							&& (chars[i] < 'a' || chars[i] > 'f')
							&& (chars[i] < 'A' || chars[i] > 'F')) {
						return false;
					}
				}
				return true;
			}
		}
		sz--;
		int i = start;
		while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				foundDigit = true;
				allowSigns = false;

			} else if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					return false;
				}
				hasDecPoint = true;
			} else if (chars[i] == 'e' || chars[i] == 'E') {
				if (hasExp) {
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if (chars[i] == '+' || chars[i] == '-') {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false;
			} else {
				return false;
			}
			i++;
		}
		if (i < chars.length) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				return true;
			}
			if (chars[i] == 'e' || chars[i] == 'E') {
				return false;
			}
			if (!allowSigns
					&& (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
				return foundDigit;
			}
			if (chars[i] == 'l' || chars[i] == 'L') {
				return foundDigit && !hasExp;
			}
			return false;
		}
		return !allowSigns && foundDigit;
	}

	/** 差集 */
	public static Set<String> difference(Set<String> setA, Set<String> setB) {
		Set<String> setDifference = new HashSet<String>();
		String s = "";
		Iterator<String> iterA = setA.iterator();
		while (iterA.hasNext()) {
			s = iterA.next();
			if (!setB.contains(s)) {
				setDifference.add(s);
			}
		}
		return setDifference;
	}

	public static String[] sort(String[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 1; j < list.length - i; j++) {
				Integer a;
				if ((Integer.valueOf(list[j - 1].trim())).compareTo(Integer
						.valueOf(list[j].trim())) > 0) { // 比较两个整数的大�?
					a = Integer.valueOf(list[j - 1].trim());
					list[j - 1] = list[j].trim();
					list[j] = a.toString();
				}
			}
		}
		return list;
	}

	/****
	 * 截取4个字�?
	 * 
	 * @param str
	 * @return
	 */
	public static String subFour(String str) {
		if (StringUtils.isBlank(str) || str.length() < 4) {
			return "";
		}
		return str.substring(0, 4);
	}

	/**
	 * 
	 * 数字转简体中�?
	 * 
	 * 要用到正则表达式
	 */

	// public static String digitToChineseNum(int n) {
	// String s = "";
	// try {
	// String fraction[] = { "�?, "�? };
	//
	// String digit[] = { "�?, "丢�", "�?, "�?, "�?, "�?, "�?, "�?, "�?, "�? };
	//
	// String unit[][] = { { "", "�?, "�? },
	//
	// { "", "�?, "�?, "�? } };
	//
	// String head = n < 0 ? "�? : "";
	//
	// n = Math.abs(n);
	//
	// for (int i = 0; i < fraction.length; i++) {
	//
	// s += (digit[(int) (Math.floor(n * 10 * Math.pow(10, i)) % 10)] +
	// fraction[i])
	// .replaceAll("(�?)+", "");
	//
	// }
	//
	// int integerPart = (int) Math.floor(n);
	//
	// for (int i = 0; i < unit[0].length && integerPart > 0; i++) {
	//
	// String p = "";
	//
	// for (int j = 0; j < unit[1].length && n > 0; j++) {
	//
	// p = digit[integerPart % 10] + unit[1][j] + p;
	//
	// integerPart = integerPart / 10;
	//
	// }
	//
	// s = p.replaceAll("(�?)*�?", "").replaceAll("^$", "�?)
	// + unit[0][i] + s;
	//
	// }
	// return head
	// + s.replaceAll("(�?)*零元", "�?).replaceFirst("(�?)+", "")
	// .replaceAll("(�?)+", "�?).replaceAll("^�?", "零元�?);
	// } catch (Exception e) {
	// return "�?;
	// }
	// }

	/****
	 * 替换数组特定字符
	 * 
	 * @param array
	 * @param rep
	 */
	public static String[] repArrayStr(String[] array, String rep) {
		if (array == null || array.length <= 0) {
			return new String[0];
		}
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			if (!rep.equals(array[i])) {
				list.add(array[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	/***************************************************************************
	 * 获取给定时间 前后的时�?
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getTimeBeforeDay(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - day);
		return c.getTime();
	}

	/***
	 * 求数组和
	 * 
	 * @param doubles
	 * @return
	 */
	public static double sum(Double[] doubles) {
		double sum = 0;
		for (int i = 0; i < doubles.length; i++) {
			sum += doubles[i];
		}
		return sum;
	}

	/****
	 * 去除重复�?
	 * 
	 * @param doubles
	 * @return
	 */
	public static Double[] doubleArrayUnique(Double[] doubles) {
		Set<Double> set = new HashSet<Double>(Arrays.asList(doubles));
		return set.toArray(new Double[doubles.length]);
	}

	/****
	 * 去除list重复�?
	 * 
	 * @param list
	 * @return
	 */
	public static List<Double> removeDuplicate(List<Double> list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	/***
	 * 相差的天�?
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int countDays(String begin, String end) {
		int days = 0;

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_b = Calendar.getInstance();
		Calendar c_e = Calendar.getInstance();

		try {
			c_b.setTime(df.parse(begin));
			c_e.setTime(df.parse(end));

			while (c_b.before(c_e)) {
				days++;
				c_b.add(Calendar.DAY_OF_YEAR, 1);
			}

		} catch (ParseException pe) {
			System.out.println("日期格式必须为：yyyy-MM-dd；如�?010-4-4.");
		}

		return days;
	}

	/**
	 * 棢�查是否是手机号码
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPhoneNumber(String number) {
		InputStream in = Utils.class.getClassLoader().getResourceAsStream(
				"phone.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			String phone = (String) pro.get("phone");
			Pattern p = Pattern.compile("^(" + phone + ")\\d{8}$");
			Matcher m = p.matcher(number);
			return m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 棢�查是否是email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		Pattern p = Pattern
				.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * Double类型转为字符串，去除小数�?
	 * 
	 * @param num
	 * @return
	 */
	public static String doubleToString(Double num) {
		BigDecimal bd = new BigDecimal(num);
		return bd.toPlainString();
	}

	/**
	 * SHA2加密
	 * 
	 * @param str
	 * @return
	 */
	public static String toSHA2(String str, String preStr) {
		try {
			str = preStr + str;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			byte data[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < data.length; i++) {
				sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {

		}
		return null;
	}

	/**
	 * 根据短信内容获取短信个数
	 * 
	 * @return
	 */
	public static Integer getSmsCountByContent(String sms) {
		return (sms.length() <= SMS_LENGTH) ? 1 : ((sms.length()
				% SINGLE_SMS_LENGTH == 0) ? (sms.length() / SINGLE_SMS_LENGTH)
				: (sms.length() / SINGLE_SMS_LENGTH + 1));
	}

	/**
	 * 替换回车换行
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceEnterChar(String str) {
		return str.replaceAll("(\r\n|\r|\n|\n\r)", " ");
	}

	// public static String converterToSpell(String chines) {
	// String pinyinName = "";
	// char[] nameChar = chines.toCharArray();
	//
	// HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
	//
	// defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	// defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	// defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
	//
	// for (int i = 0; i < nameChar.length; i++) {
	// if (Character.toString(nameChar[i]).matches("[\\u4E00-\\u9FA5]+"))
	// try {
	// pinyinName = pinyinName
	// + net.sourceforge.pinyin4j.PinyinHelper
	// .toHanyuPinyinStringArray(nameChar[i],
	// defaultFormat)[0];
	// } catch (BadHanyuPinyinOutputFormatCombination e) {
	// e.printStackTrace();
	// }
	// else {
	// pinyinName = pinyinName + Character.toString(nameChar[i]);
	// }
	// }
	//
	// return pinyinName;
	// }

	public static String getPhoneNumber() {
		InputStream in = Utils.class.getClassLoader().getResourceAsStream(
				"phone.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
			return pro.get("phone").toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
