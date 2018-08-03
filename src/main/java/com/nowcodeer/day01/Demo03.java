package com.nowcodeer.day01;

import java.util.ArrayList;
import java.util.Collections;

public class Demo03 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		while (listNode != null) {
			list.add(listNode.val);
			listNode = listNode.next;
		}
		Collections.reverse(list);
		return list;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}