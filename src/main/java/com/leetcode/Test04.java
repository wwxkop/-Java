package com.leetcode;

import java.util.Arrays;

public class Test04 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] num = guibing(nums1, nums2);
		int nu = num.length;
		int zhongjian = nu/2;
		if(nu%2==0) {
			return (num[zhongjian] + num[zhongjian-1])/2.0;
		}else {
			return num[zhongjian];
		}
	}

	private static int[] guibing(int[] num1, int[] num2) {
		int[] num = new int[num1.length + num2.length];
		int i = 0, j = 0, t = 0;
		while(i < num1.length && j < num2.length) {
			if(num1[i] <= num2[j]) {
				num[t++] = num1[i++];
			}else {
				num[t++] = num2[j++];
			}
		}
		while(i < num1.length) {
			num[t++] = num1[i++];
		}
		while(j < num2.length) {
			num[t++] = num2[j++];
		}
		return num;
	}
	public static void main(String[] args) {
		int[] num1 = {};
		int[] num2 = {1,2};
		double num = findMedianSortedArrays(num1, num2);
		System.out.println(num);
	}
}
