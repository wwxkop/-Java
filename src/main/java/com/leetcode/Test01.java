package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
	public static int[] twoSum(int[] nums, int target) {
		int answer[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(Arrays.toString(twoSum(arr, 6)));
	}
}
