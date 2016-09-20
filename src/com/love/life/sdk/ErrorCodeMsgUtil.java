package com.love.life.sdk;

import java.text.MessageFormat;

/**
 * 
 * 〈功能简述〉
 * @author wugy08
 * @version [版本号，默认V1.0.0]
 * @Credited 2016年3月16日 下午2:43:32
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class ErrorCodeMsgUtil {

    private final static String ERROR_CODE_MSG_CONFIG_PATH = "/errorcode_msg_zh.properties";

    /**
     * 获取code 对应
     * @param code
     * @return
     */
    public static String getMessage(int code) {
        String template = (String)PropertiesUtil.getPropValAsString("api.errcode." + String.valueOf(code),
                ERROR_CODE_MSG_CONFIG_PATH);
        return template;
    }
    
    /**
     * 获取code 对应
     * @param code
     * @return
     */
    public static String getMessage(int code, Object[] args) {
        String template = (String)PropertiesUtil.getPropValAsString("api.errcode." + String.valueOf(code),
                ERROR_CODE_MSG_CONFIG_PATH);
        template = MessageFormat.format(template, args);
        return template;
    }
}
