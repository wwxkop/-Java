package com.nowcodeer.day01;

public class Demo02 extends Thread {
	public static String replaceSpace(StringBuffer str) {
		String s = str.toString();
		String newStr = s.replaceAll("\\s", "%20");
		return new String(newStr);
	}
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(sb));
	}
}
