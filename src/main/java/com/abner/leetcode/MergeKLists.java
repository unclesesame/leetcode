package com.abner.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
	public static void main(String[] args) {
		
	}
	
	public ListNode mergeKLists(ListNode[] lists){
		if(lists == null || lists.length == 0) {
			return null;
		}
		
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				if(o1.val == o2.val)
					return 0;
				else if(o1.val > o2.val)
					return 1;
				else 
					return -1;
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for(ListNode node : lists)
			if(node != null)
				queue.add(node);
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			if(tail.next != null){
				queue.add(tail.next);
			}
		}
		return dummy.next;
	}
}
