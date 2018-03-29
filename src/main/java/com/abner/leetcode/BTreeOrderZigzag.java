package com.abner.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTreeOrderZigzag {
	public static void main(String[] args) {
		int[] array = new int[]{0,1,2,3,4,5,6,0,8,9};
		TreeNode root = createBTreeByArray(array,1);
		List<List<Integer>> lists = zigzag(root);
		for(List<Integer> list : lists){
			for(Integer integer : list){
				System.out.println(integer.intValue());
			}
		}
	}
	
	public static TreeNode createBTreeByArray(int[] array, int index){
		if(index < array.length){
			int value = array[index];
			if(value != 0){
				TreeNode node = new TreeNode(value);
				//array[index] = 0;
				node.left = createBTreeByArray(array, index*2);
				node.right = createBTreeByArray(array, index*2+1);
				return node;
			}
		}
		return null;
	}
	
	public static List<List<Integer>> zigzag(TreeNode root) {
		
		boolean asc = true;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> ascStack = new Stack<TreeNode>();
		Stack<TreeNode> descStack= new Stack<TreeNode>();
		
		ascStack.add(root);
		while(ascStack.size() > 0 || descStack.size() > 0){
			List<Integer> list = new ArrayList<Integer>();
			if(asc){
				int size = ascStack.size();
				for(int i=0; i<size;i++){
					TreeNode node = ascStack.pop();
					list.add(node.val);
					if(node.left != null){
						descStack.push(node.left);
					}
					if(node.right != null){
						descStack.push(node.right);
					}
				}
			}
			else{
				int size = descStack.size();
				for(int i=0; i<size;i++){
					TreeNode node = descStack.pop();
					list.add(node.val);
					if(node.right != null){
						ascStack.push(node.right);
					}
					if(node.left != null){
						ascStack.push(node.left);
					}
				}
			}
			asc = !asc;
			result.add(list);
		}
		return result;
	}
}
