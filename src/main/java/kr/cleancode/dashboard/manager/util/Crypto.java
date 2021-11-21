/**
 * Create Time: 2021-11-21
 * Made by: js
 */
package kr.cleancode.dashboard.manager.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {

	private Crypto() {}
	
	public static final String getSha256(final String srcString){
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(srcString.getBytes());
			
			final byte[] byteDatas = messageDigest.digest();
			
			final StringBuffer stringBuffer = new StringBuffer();
			for(byte byteData : byteDatas){
				stringBuffer.append(Integer.toString((byteData & 0xff) + 0x100, 16).substring(1));
			}
			
			return stringBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
}
