package com.se.day01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 把一个数组中的数全部列出，比如1和2列出来为1，2，12，21
 */
public class Demo01 {
	public static void main(String[] args) {
		String[] array = {"1","2","3","4"};
		listAll(Arrays.asList(array), "");
	}
	static public void listAll(List candate, String str) {
		if(candate.isEmpty()) {
			System.out.println(str);
		}
		for(int i = 0; i < candate.size(); i++) {
			List temp = new LinkedList(candate);
			listAll(temp, str + temp.remove(i));
		}
	}
}
