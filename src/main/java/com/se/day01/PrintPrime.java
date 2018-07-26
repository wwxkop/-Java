package com.se.day01;

import java.util.Scanner;

/** 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）最后一个数后面也要有空格
	详细描述：
	函数接口说明：
	public String getResult(long ulDataInput)
	输入参数：
	long ulDataInput：输入的正整数
	返回值：
	String 
 */
public class PrintPrime {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long num = scanner.nextLong();
		int k = 2;
		while(num>1) {
			if(num%k==0) {
				System.out.println(k+" ");
				num = num / k;
			}else {
				k++;
			}
		}
	}
}
