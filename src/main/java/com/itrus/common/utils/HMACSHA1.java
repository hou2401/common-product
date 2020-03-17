package com.itrus.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author yuyi
 * @version 1.0
 * @since 1.0
 */
public class HMACSHA1 {
	
	public static byte[] getHmacSHA1(String data, String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] ipadArray = new byte[64];
		byte[] opadArray = new byte[64];
		byte[] keyArray = new byte[64];
		int ex = key.length();
		MessageDigest m=MessageDigest.getInstance("SHA1");
		if (key.length() > 64) {
			byte[] temp =m.digest(key.getBytes());
			ex = temp.length;
			for (int i = 0; i < ex; i++) {
				keyArray[i] = temp[i];
			}
		} else {
			byte[] temp = key.getBytes();
			for (int i = 0; i < temp.length; i++) {
				keyArray[i] = temp[i];
			}
		}
		for (int i = ex; i < 64; i++) {
			keyArray[i] = 0;
		}
		for (int j = 0; j < 64; j++) {
			ipadArray[j] = (byte) (keyArray[j] ^ 0x36);
			opadArray[j] = (byte) (keyArray[j] ^ 0x5C);
		}
		byte[] tempResult = m.digest(join(ipadArray, data.getBytes("utf-8")));
		return  m.digest(join(opadArray, tempResult));
	}
	
	
	public static byte[] getHmacSHA1(byte[] data, String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		byte[] ipadArray = new byte[64];
		byte[] opadArray = new byte[64];
		byte[] keyArray = new byte[64];
		int ex = 0;
		MessageDigest m=MessageDigest.getInstance("SHA1");
		if (key.length() > 64) {
			byte[] temp =m.digest(key.getBytes());
			ex = temp.length;
			System.arraycopy(temp, 0, keyArray, 0, temp.length);
		} else {
			byte[] temp = key.getBytes();
			ex = temp.length;
			System.arraycopy(temp, 0, keyArray, 0, temp.length);
		}
		for (int i = ex; i < 64; i++) {
			keyArray[i] = 0;
		}
		
		for (int j = 0; j < 64; j++) {
			ipadArray[j] = (byte) (keyArray[j] ^ 0x36);
			opadArray[j] = (byte) (keyArray[j] ^ 0x5C);
		}
		byte[] tempResult = m.digest(join(ipadArray, data));
		return  m.digest(join(opadArray, tempResult));
	}


	private static byte[] join(byte[] b1, byte[] b2) {
		int length = b1.length + b2.length;
		byte[] newer = new byte[length];
		for (int i = 0; i < b1.length; i++) {
			newer[i] = b1[i];
		}
		for (int i = 0; i < b2.length; i++) {
			newer[i + b1.length] = b2[i];
		}
		return newer;
	}
}