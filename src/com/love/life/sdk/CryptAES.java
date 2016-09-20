package com.love.life.sdk;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * aes加密
 * @author wugy08
 * @version [版本号，默认V1.0.0]
 * @Credited 2016年5月17日 下午1:15:08
 * @see       [相关类/方法]
 * @since     [产品/模块版本]
 */
public class CryptAES {

	private static final String AESTYPE = "AES/ECB/PKCS5Padding";
	private static final String KEYSTR = "tkhhealthcare777";

	/**
	 * 
	 * 描述：加密
	 * @param keyStr
	 * @param plainText
	 * @return 
	 * @author wugy08
	 * @Credited 2016年5月17日 下午1:19:57
	 * @version [版本号，默认V1.0.0]
	 */
	public static String AES_Encrypt(String keyStr, String plainText) {
		byte[] encrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(plainText.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(encrypt));
	}
	
	
	public static String AES_Encrypt(String plainText) {
		byte[] encrypt = null;
		try {
			Key key = generateKey(KEYSTR);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(plainText.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(encrypt));
	}

	/**
	 * 
	 * 描述：解密
	 * @param keyStr
	 * @param encryptData
	 * @return 
	 * @author wugy08
	 * @Credited 2016年5月17日 下午1:19:45
	 * @version [版本号，默认V1.0.0]
	 */
	public static String AES_Decrypt(String keyStr, String encryptData) {
		byte[] decrypt = null;
		try {
			Key key = generateKey(keyStr);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher
					.doFinal(Base64.decodeBase64(encryptData.getBytes()));
		} catch (Exception e) {
			;
		}
		return new String(decrypt).trim();
	}
	
	public static String AES_Decrypt(String encryptData) {
		byte[] decrypt = null;
		try {
			Key key = generateKey(KEYSTR);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher
					.doFinal(Base64.decodeBase64(encryptData.getBytes()));
		} catch (Exception e) {
			;
		}
		return new String(decrypt).trim();
	}

	/**
	 * 
	 * 描述：封装key值
	 * @param key
	 * @return
	 * @throws Exception 
	 * @author wugy08
	 * @Credited 2016年5月17日 下午1:19:23
	 * @version [版本号，默认V1.0.0]
	 */
	private static Key generateKey(String key) throws Exception {
		
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			return keySpec;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	

	public static void main(String[] args) throws Exception {
		String keyStr = "tkhhealthcare777";
		System.out.println(keyStr);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uid", "c1543e4d-41df-adf4-0a73-03ad9b50c338");
		String encText = AES_Encrypt(keyStr, jsonObj.toString());
		System.out.println(encText);
		String decText = AES_Decrypt(keyStr, encText);
		System.out.println(decText);

	}
}