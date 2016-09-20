package com.love.life.sdk;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DES {
	
	public final static String DEFALIT_DES_KEY="12345678";
	
	private static byte[] iv = { 1,2, 3, 4, 5, 6, 7, 8 };

	public static String encryptDES(String encryptString, String encryptKey)

	throws Exception {

		IvParameterSpec zeroIv = new IvParameterSpec(iv);

		SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

		return new String(Base64.encodeBase64(encryptedData));

	}
	/**
	 * 解密
	 * @param decryptString
	 * @param decryptKey
	 * @return
	 * @throws Exception
	 */
	public static String decryptDES(String decryptString, String decryptKey)throws Exception {
			//System.out.print(prama.replace("-", "+").replace("_", "\\").replace("*", " "));
		System.out.print("====DES解密前密文===="+decryptString);
			if(decryptString.contains("-")){
				decryptString = decryptString.replace("-", "+");
			}
			if(decryptString.contains("_")){
				decryptString = decryptString.replace("_", "\\");
			}
			if(decryptString.contains("*")){
			   decryptString = decryptString.replace("*", " ");
			}
			System.out.print("====特殊字符替换后密文===="+decryptString);
			byte[] byteMi = Base64.decodeBase64(decryptString);

			IvParameterSpec zeroIv = new IvParameterSpec(iv);

			SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");

			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);

			byte decryptedData[] = cipher.doFinal(byteMi);
			System.out.print("====DES解密后明文===="+new String(decryptedData));
			return new String(decryptedData);

}

	
	public static void main(String[] args) {
		try {
			System.out.println(encryptDES("1","12345678"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(decryptDES(encryptDES("1","12345678"),"12345678"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
