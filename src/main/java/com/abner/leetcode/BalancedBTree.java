package com.abner.leetcode;

//判断一棵树是平衡二叉树
//Notes 递归，左右子树深度之差绝对值不大于1
public class BalancedBTree {
	public static void main(String[] args) {
		
	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		return depth(root) != -1;
	}
	
	private int depth(TreeNode node){
		if(node == null){
			return 0;
		}
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		if(leftDepth == -1 || rightDepth == -1){
			return -1;
		}
		if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1){
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
}
