package com.se.day01;
/*
 * 查找100以内的素数。
 * */
public class Demo05 {
	public static void main(String[] args) {
		int a[], i, j;
		a = new int[101];
		for(i = 1; i < 101; i++) {
			a[i] = 1;
		}
		for(i = 2; i < 101; i++){
			if(a[i] != 0) {
				for(j = i + i;j < 101;) {
					if(j%i==0) {
						a[j] = 0;
						j = j + i;
					}
				}
			}
		}
		for(i = 2; i < 101; i++) {
			if(a[i]!=0) {
				System.out.println(i);
			}
		}
	}
}
