package com.abner.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//自底向上遍历二叉树
//notes: list的add(0, element)，往链首插入元素
public class BTreeOrderBottomUp {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(queue.size() > 0){
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			for(int i=0; i<size; i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) 
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			result.add(0,list);
		}
		return result;
	}
}
