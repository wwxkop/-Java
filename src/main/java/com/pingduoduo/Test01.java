package com.pingduoduo;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		while (s.length() % 4 != 0 || s.length() / 4 < 1 || s.length() / 4 > 10) {
			s = scanner.nextLine();
		}
		char[] chars = s.toCharArray();
		print(chars);
	}

	private static void print(char[] chars) {
		int num = chars.length / 4;
		char[] c1 = new char[num + 1];
		char[] c2 = new char[num - 1];
		char[] c3 = new char[num + 1];
		char[] c4 = new char[num - 1];
		for (int i = 0; i < num + 1; i++) {
			c1[i] = chars[i];
		}
		for (int i = num + 1; i < 2 * num; i++) {
			c2[i - num - 1] = chars[i];
		}
		for (int i = 2 * num; i < 3 * num + 1; i++) {
			c3[i - 2 * num] = chars[i];
		}
		for (int i = 3 * num + 1; i < chars.length; i++) {
			c4[i - 3 * num - 1] = chars[i];
		}
		reverse(c3);
		reverse(c4);
		for (int i = 0; i < c1.length; i++) {
			System.out.print(c1[i]);
		}
		System.out.println();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < num; i++) {
			sb.append(" ");
		}
		for (int i = 0; i < c2.length; i++) {
			System.out.print(c4[i] + sb.toString() + c2[i] + "\n");
		}
		for (int i = 0; i < c3.length; i++) {
			System.out.print(c3[i]);
		}
	}

	public static void reverse(char[] in) {
		char temp;
		for (int i = in.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				temp = in[j];
				in[j] = in[j + 1];
				in[j + 1] = temp;
			}
		}
	}
}
