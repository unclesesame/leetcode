package com.abner.leetcode;
//给两个数字链表，高位在链尾，计算和,返回一个数字链表
//Input:(2->4->3) + (5->6->4)
//Output:7->0->8

//Notes: head是一个值为0的节点，返回的结果head.next
public class AddTwoNumbers {
	public static void main(String[] args) {
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = head;
		
		int carry = 0;
		int sum = 0;
		int left = 0;
		
		while(p != null || q != null){
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			sum = x + y + carry;
			left = sum % 10;
			carry = sum / 10;
			curr.next = new ListNode(left);
			if(p != null) p = p.next;
			if(q != null) q = q.next;
			curr = curr.next;
		}
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		return head.next;
	}
}
