package com.util.dessso;

import com.util.Log;


public class ToPwd {
	/**
	 * ����
	 * 
	 * @param password
	 * @return
	 */
	public static String Encryption(String password) {

		String encrypt  = "";
		try {
			DESSSO des = new DESSSO("mestart");
			if(password != null){
				for (int i = 0; i < password.length(); i++) {
					encrypt = encrypt + des.encrypt(password.substring(i, i + 1));
				}
			}
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
		}// �Զ�����Կ
		return encrypt;
	}

	/**
	 * ����
	 * 
	 * @param password
	 * @return
	 */
	public static String Decryption(String password) {
		String decrypt = "";
		try {
			DESSSO des = new DESSSO("mestart");
			if(password != null){
				for (int j = 0; j < password.length() / 16; j++) {
					decrypt = decrypt+des.decrypt(password.substring(j * 16, (j + 1) * 16));
				}
			}
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
		}
		return decrypt;
	}
	/**
	 * ����
	 * 
	 * @param password
	 * @return
	 */
	public static String EncryptionAll(String password) {

		String encrypt = "";
		try {
			DESSSO des = new DESSSO("mestart");
			encrypt = des.encrypt(password);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
		}// �Զ�����Կ
		return encrypt;
	}
	/**
	 * ����
	 * 
	 * @param password
	 * @return
	 */
	public static String DecryptionAll(String password) {
		String decrypt = "";
		try {
			DESSSO des = new DESSSO("mestart");
			decrypt =des.decrypt(password);
		} catch (Exception e) {
			Log.getLogger().error(e.getMessage(),e);
			System.out.println("������������쳣");
		}
		return decrypt;
	}
	public static void main(String[] args) {
		System.out.println(EncryptionAll("123456"));
		System.out.println(DecryptionAll("5544ef9082ab80cb"));
	}
	
}
