package com.love.life.sdk;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;     
public class DateCheckUtil  {  
     /** 
    * 验证日期时间格式 
     * @param args 
    */  
    public static boolean dateCheck(String args)  
    {  
       DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
       Date d = null;  
       if(args != null && !args.equals("")){  
            if(args.split("/").length > 1){  
                dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
            }  
            if (args.split("-").length > 1){  
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            }  
        }else{  
           return false;  
        }  
       try{  
           d = dateFormat.parse(args);  
           System.out.println(d);  
       }catch(Exception e)  {  
           System.out.println("格式错误");  
           return false;  
       }  
       String eL="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";        
       Pattern p = Pattern.compile(eL);   
        Matcher m = p.matcher(args);   
        boolean b = m.matches();  
        if(b){  
              return true; 
        }else{  
            return false;  
        }  
    }  
    /*public static void main(String [] args){
    	String s="2015-02-28";
    	System.out.println(DateCheckUtil.dateCheck(s));
    }   */
}  

