package com.love.life.sdk;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 〈功能简述〉
 * @author wugy08
 * @version [版本号，默认V1.0.0]
 * @Credited 2016年3月16日 下午3:55:13
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class StringUtil {

    private static Logger logger = Logger.getLogger(StringUtil.class);

    /**
     * 验证字符串是否为double类型
     *
     * @param str
     *            需要验证的字符串
     * @return 是double返回true
     */
    public static Boolean isDouble(String str) {
        try {
            if (str == null || "".equals(str.trim())) {
                return false;
            }

            Pattern pattern = Pattern.compile("[-+]?[0-9]+(\\.[0-9]+)?"); // 判断是否为double类型
            boolean isDou = pattern.matcher(str).matches();
            if (isDou) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 验证字符串是否为integer类型
     *
     * @param str
     * @return
     */
    public static Boolean isInteger(String str) {
        try {
            if (str == null || "".equals(str.trim())) {
                return false;
            }
            boolean isInt = str.matches("^[-+]?(0|([1-9]+[0-9]*))$");
            if (isInt) {
                logger.debug("字符串" + str + "是整型");
                return true;
            }
            logger.debug("字符串" + str + "不是整型");
            return false;
        } catch (Exception e) {
            logger.error("isInteger 异常", e);
        }
        return false;
    }

    /**
     * 判断字符串是否是指定时间格式的日期字符串
     *
     * @param str
     *            字符串
     * @param format
     *            时间格式
     * @return 是返回true，否则返回false
     */
    public static Boolean isDate(String str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.parse(str);
            logger.debug("isDate " + str + "是[" + format + "]的Date类型");

            if (str.equals(sdf.format(sdf.parse(str)))) {
                logger.debug("isDate " + str + "是[" + format + "]的Date类型");
                return true;
            } else {
                logger.debug("isDate " + str + "不是[" + format + "]的Date类型");
                return false;
            }
        } catch (Exception e) {
            logger.error("isDate " + str + "不是[" + format + "]的Date类型", e);
        }
        return false;
    }

    /**
     * 左侧补充0
     * @param num
     * @param length
     * @return
     */
    public static String addLeftZero(String num, int length) {
        int strLen = num.length();
        if (strLen < length) {
            while (strLen < length) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(num);// 左补0
                num = sb.toString();
                strLen = num.length();
            }
        }
        return num;

    }

    /**
     * 判断是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        boolean result = false;
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return result;
    }
    /**
     * 一个字符串获取数字部分
     * @param str
     * @return
     */
    public static String getIntegerByStr(String str) {
    	try {
    		String regex = "\\d*";
    		Pattern p = Pattern.compile(regex);

    		Matcher m = p.matcher(str);

    		while (m.find()) {
	    		if (!"".equals(m.group())) {
	    			return m.group();
	    		}
    		}
    		return null;
		} catch (Exception e) {
			logger.error("getIntegerByStr 异常"  + e.getMessage());
		}
    	return null;
    }

    public static void main(String[] args) {
        // String timeStr = "2014-12-22 12:12:12";
        // String format = "yyyy-MM-dd HH:mm:ss";
        // boolean result = isDate(timeStr, format);
        // logger.info("result:" + result);

        // String intStr = "-11.";
        // boolean result = isInteger(intStr);
        // logger.info("result:" + result);

        String doubleStr = "1.1";
        boolean result = isDouble(doubleStr);

    }
	
}
