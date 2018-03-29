package com.abner.leetcode;
//判断一棵树是另一棵树的子树
public class SubTree {
	public static void main(String[] args) {
		
	}
	
	private static boolean isSub(TreeNode s, TreeNode t){
		if(s == null && t == null){
			return true;
		}
		if(s == null || t == null){
			return false;
		}
		if(s.val != t.val){
			return false;
		}
		return isSub(s.left,t.left) && isSub(s.right, t.right);
	}
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
		boolean result = false;
		if(s != null && t != null){
			if(s.val == t.val){
				result = isSub(s, t);
			}
			if(!result){
				result = isSubtree(s.left, t);
			}
			if(!result){
				result = isSubtree(s.right, t);
			}
		}
		return result;
	}
}
