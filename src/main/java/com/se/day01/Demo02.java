package com.se.day01;

public class Demo02 {
	public static void main(String[] args) {
		int n = 2;
		int res = 1;
		while((getOnly(n) + res) != n) {
			res +=getOnly(n);
			n++;
		}
		System.out.println(n);
	}

	private static int getOnly(int n) {
		int number = 0;
		String s = n + "";
	    int len = s.length();
	    for(int i = 0; i < len; i++) {
	    	char a = s.charAt(i);
	    	if(a=='1') {
	    		number++;
	    	}
	    }
		return number;
	}
}
