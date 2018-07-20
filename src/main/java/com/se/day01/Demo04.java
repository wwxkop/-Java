package com.se.day01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo04 {
	public static Set set = new TreeSet();
	public static void main(String[] args) {
		int[] arr = {1,2,2,3,4};
		String[] strs = new String[5];
		for(int i = 0; i < arr.length; i++) {
			strs[i] = arr[i] + "";
		}
		listAll(Arrays.asList(strs), "");
		System.out.println(set);
	}

	private static void listAll(List temp, String str) {
		if(temp.isEmpty()) {
			System.out.println(str);
			set.add(str);
		}
		for(int i = 0; i < temp.size(); i++) {
			List list = new LinkedList(temp);
			listAll(list, str + list.remove(i));
		}
	}
}
