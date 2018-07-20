package com.se.day01;

import java.util.Scanner;

public class Fibonacci{
	public static int k = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long a = scanner.nextLong();
		System.out.println(fibonacci(a));
		System.out.println("共递归调用了" + k + "次");
	}

	private static long fibonacci(long m) {
		if(m==0||m==1) {
			k++;
			return 1;
		}
		return fibonacci(m - 1) + fibonacci(m - 2);
	}
}
