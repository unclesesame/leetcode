package com.abner.leetcode;

public class RemoveNthFromEnd {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		removeNthFromEnd(head, 2);
		
		System.out.println(head.next.next.next.val);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode p = head;
		ListNode q = head;
		while(q.next != null){
			if(n > 0){
				n--;
			}else{
				p = p.next;
			}
			q = q.next;
		}
		p.next = q;
		return head;
	}
}
