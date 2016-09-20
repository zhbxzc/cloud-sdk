package com.love.life.sdk;
import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author
 * 
 */
public class PatternUtil {
    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
  
    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
  
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
  
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
  
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
  
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Za-z])$";
    public static final String REGEX_ID_CARD15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
  
    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
  
    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    
    /**
     * 正则表达式,校验固定电话
     */
     public static final String REGEX_TELPHONE="\\d{2,5}-\\d{7,8}";
     
     /**
      * 正则表达式,校验以一个英文字母开始不区分大小写,并且首字母之后为任意多个数字,数字之后且可以跟任意字符
      */
      private static final String REGEX_ENGLISH_NUMBER ="^[A-Za-z][0-9]+.*$";
      
      /**
       * 正则表达式,校验英文字母不区分大小写,任意多个英文字符.
       */
      private static final String REGEX_ENGLISH_CAHR ="^[A-Za-z]+$";
      
      /**
       * 正则表达式,校验 字符串中是否包含汉字
       */
      private static final String REGEX_STRING_CONTAINS_CHINESE ="^.*[\u4e00-\u9fa5].*$";
      
     /**
      * 正则表达式,校验 字符串中是否包含汉字
      * @return  校验通过返回true，否则返回false
      */
     public static boolean isStringContinsChiness(String param) {
         return Pattern.matches(REGEX_STRING_CONTAINS_CHINESE, param);
     }
     
     
     /**
      * 正则表达式,校验以一个英文字母开始不区分大小写,并且首字母之后为任意多个数字,数字之后且可以跟任意字符
      * @return  校验通过返回true，否则返回false
      */
     public static boolean isEnglishNumber(String param) {
         return Pattern.matches(REGEX_ENGLISH_NUMBER, param);
     }
     
     /**
      * 正则表达式,校验英文字母不区分大小写,任意多个英文字符.
      * @param param
      * @return  校验通过返回true，否则返回false
      */
     public static boolean isEnglishChar(String param) {
         return Pattern.matches(REGEX_ENGLISH_CAHR, param);
     }
     /**
      * 校验固定电话
      * @param telphone
      * @return  校验通过返回true，否则返回false
      */
     public static boolean isTelphone(String telphone) {
         return Pattern.matches(REGEX_TELPHONE, telphone);
     }
    /**
     * 校验用户名
     * 
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }
  
    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
  
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
  
    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
  
    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }
  
    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
    	boolean flag=false;
    	if(idCard.length()==15){
    		flag=Pattern.matches(REGEX_ID_CARD15, idCard);
    		return flag;
    	}else if(idCard.length()==18){
    		flag=Pattern.matches(REGEX_ID_CARD18, idCard);
    		return flag;
    	}else{
    		return flag;
    	}
    }
  
    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }
  
    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
  
    public static void main(String[] args) {
        String username = "fdsdfsdj";
        System.out.println(PatternUtil.isUsername(username));
        System.out.println(PatternUtil.isChinese(username));
    }
}
