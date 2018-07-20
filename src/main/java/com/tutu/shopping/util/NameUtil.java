package com.tutu.shopping.util;

public class NameUtil {
	
	public static String getNickName(String name) {
		String nickname = "";
		if (name.length() < 2 && name.length() > 0) {
			nickname = name.substring(0, 1) + "*";
		} else if (name.length() >= 2) {
			nickname = name.substring(0, 1) + "*" + name.substring(name.length() - 1, name.length());
		}
		return nickname;
	}
//	public static void main(String[] args) {
//		System.out.println(getNickName("a1561s"));
//	}

}
