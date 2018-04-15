package com.abner.leetcode;

import java.util.Stack;

public class QueueSimlulateByStack {
	
	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2 = new Stack<Integer>();
	
	public void push(int x) {
		stack1.push(x);
	}
	
	public void pop() {
		if(stack2.size() == 0) {
			int m = stack1.size();
			for(int i=0 ;i <m ; i++){
				stack2.push(stack1.pop());
			}
		}
		stack2.pop();
	}
	
	public int peek() {
		if(stack2.size() == 0) {
			int m = stack1.size();
			for(int i=0 ;i <m ; i++){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
	
	public boolean empty(){
		return stack1.size() == 0 && stack2.size() == 0;
	}
}
