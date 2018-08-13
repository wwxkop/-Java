package com.pingduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		while (s.length() > 10 || s.length() < 1) {
			s = scanner.nextLine();
		}
		int count = 0;
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i < s.length(); i++) {
			String str1 = s.substring(0, i);
			String str2 = s.substring(i, s.length());
			if(!list.contains(str1 + "," + str2) && !list.contains(str2 + "," + str1)) {
				list.add(str1 + "," + str2);
			}
		}
		for (String string : list) {
			String str1 = string.split("\\,")[0];
			String str2 = string.split("\\,")[1];
			System.out.println(str1 + ", " + str2);
			if(isInteger(str1)&&isInteger(str2)) {
				count++;
			}
			System.out.println(count);
			if(isDecimal(str1, str2)) {
				count++;
			}
			System.out.println(count);
		}
		System.out.println(count);
	}

	private static boolean isDecimal(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		if (chars1.length == 1 && chars2.length == 1) {
			return false;
		}
		if(chars1.length >1 && chars1[chars1.length - 1] == '0') {
			return false;
		}
		if (chars2.length >1 && chars2[chars2.length - 1] == '0') {
			return false;
		}
		return true;
	}

	private static boolean isInteger(String str) {
		char[] chars = str.toCharArray();
		if (chars.length == 1) {
			return true;
		}
		if (chars.length > 1 && chars[0] != '0') {
			return true;
		}
		return false;
	}
}