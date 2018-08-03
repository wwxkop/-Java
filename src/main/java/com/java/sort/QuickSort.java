package com.java.sort;
public class QuickSort {
	public static void sort(int[] arr, int low, int high) {
		if(low>high) {
			return;
		}
		int trans = 0;
		int i = low;
		int j = high;
		int temp = arr[low];
		while(i < j) {
			while(i < j && (arr[j] >= temp)) {
				j--;
			}
			while(i < j && (arr[i] <= temp)) {
				i++;
			}
			trans = arr[j];
			arr[j] = arr[i];
			arr[i] = trans;
		}
		arr[low] = arr[i];
		arr[i] = temp;
		sort(arr, low, i-1);
		sort(arr, i + 1, high);
	}
	public static void main(String[] args) {
		int[] arr = {6,1,2,7,9,3,4,5,10,8};
		sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
