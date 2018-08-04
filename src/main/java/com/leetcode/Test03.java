package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test03 {
	public static int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<>();
		int length = 0;
		for(int i = 0; i < chars.length; i++) {
			list.add(chars[i]);
			for(int j = i + 1; j < chars.length; j++) {
				if(!list.contains(chars[j])) {
					list.add(chars[j]);
				}else {
					if(length<list.size()) {
						length = list.size();
					}
					list.clear();
					break;
				}
			}
			if(length<list.size()) {
				length = list.size();
			}
			list.clear();
		}
		return length;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
