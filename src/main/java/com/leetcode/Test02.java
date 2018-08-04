package com.leetcode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Test02 {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		ListNode dummyHead  = new ListNode(0);
		int carry = 0;
		ListNode p = node1, q = node2, cur = dummyHead;
		while(p!=null||q!=null) {
			int x = (p!=null)?p.val:0;
			int y = (q!=null)?q.val:0;
			int sum = x + y + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum%10);
			cur = cur.next;
			if(p!=null) {
				p = p.next;
			}
			if(q!=null) {
				q = q.next;
			}
		}
		if(carry>0) {
			cur.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
