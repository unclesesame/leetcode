package com.abner.leetcode;

//单向链表反转
//Notes: pre curr temp分别表示前一个节点，当前节点，和下一个节点
public class ListReversion {
	public static void main(String[] args) {
		
	}
	
	public static ListNode reverse(ListNode head){
		if(head == null){
			return head;
		}
		ListNode pre = head;
		ListNode curr = head.next;
		ListNode temp = null;
		
		while(curr != null){
			temp = curr.next;
			pre = curr.next;
			pre = curr;
			curr = temp;
		}
		head.next = null;
		return pre;
	}
}
