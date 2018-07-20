package com.se.day01;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo03 {
	public static void main(String[] args) {
		String input = "sadfujajdwasfaerqpomxabqwuibxmnnucneuidhbasbiqwuifdfgwerwqwjregbcmdsakjsbdvbakjhqwhb";
		char[] chs = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < chs.length; i++) {
			if(map.containsKey(chs[i])) {
				map.put(chs[i], map.get(chs[i]) + 1);
			}else {
				map.put(chs[i], 1);
			}
		}
		int max = 0;
		char c = ' ';
		for (Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				c = entry.getKey();
			}
		}
		System.out.println(c + ": " + max);
	}
}
