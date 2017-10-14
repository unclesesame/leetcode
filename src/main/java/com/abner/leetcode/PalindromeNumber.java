package com.abner.leetcode;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber pNumber =  new PalindromeNumber();
		System.out.println(pNumber.isPalindrome(9) ? "true" : "false");
	}
	
	public boolean isPalindrome(int x) {
		
		if(x < 0){
			return false;
		}
		
		int rev = 0;
		int p = x;
		while(x !=0 ){
			rev = 10 * rev + x % 10;
			x = x / 10;
		}
		
		if(rev == p){
			return true;
		}
		
		return false;
	}
}
