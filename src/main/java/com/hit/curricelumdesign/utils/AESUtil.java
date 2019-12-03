package com.hit.curricelumdesign.utils;


import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidParameterException;

/**
 * Description: AES工具
 * ClassName: AESUtil
 * date: 2018年11月30日
 *
 * @author YGC
 * @version
 * @since JDK 1.8
 */
public class AESUtil {

	private static final String ENCODING = "UTF-8";

	public static String encrypt(String originalString, String key) throws Exception {
		if (null == originalString || originalString.length() == 0) {
			throw new InvalidParameterException("original string is required");
		}

		if (null == key || key.length() == 0) {
			throw new InvalidParameterException("key to encrypt the text is required");
		}

		if (key.length() != 16) {
			throw new InvalidParameterException("the key should be 16 characters, current is: " + key.length());
		}

		byte[] raw = key.getBytes(ENCODING);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(originalString.getBytes(ENCODING));

		return Base64.encodeBase64String(encrypted);
	}

	public static String decrypt(String encryptedString, String key) throws Exception {
		if (null == encryptedString || encryptedString.length() == 0) {
			throw new InvalidParameterException("original string is required");
		}

		if (null == key || key.length() == 0) {
			throw new InvalidParameterException("key to encrypt the text is required");
		}

		if (key.length() != 16) {
			throw new InvalidParameterException("the key should be 16 characters");
		}

		byte[] raw = key.getBytes(ENCODING);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);

		byte[] unBase64String = Base64.decodeBase64(encryptedString);
		byte[] original = cipher.doFinal(unBase64String);
		String originalString = new String(original, ENCODING);

		return originalString;
	}
}
