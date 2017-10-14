package com.abner.leetcode;


public class ImplementStrStr {
	public static void main(String[] args) {
		ImplementStrStr o = new ImplementStrStr();
		System.out.println(o.strStr("mississippi", "issipi"));
	}
	
	
	//mississippi
	//issipi
	
	//adcdefgopqehccc
	
	//eh
	
	//if needle is a substring of haystack, return the index of the first occurrence of needle in haystack.
	
	public int strStr(String haystack, String needle) {
		
		if(haystack.length() < needle.length()){
			return -1;
		}
		
		if(needle == null || needle.length() == 0){
			return 0;
		}
		
		char[] array =  haystack.toCharArray();
		char[] targetArray = needle.toCharArray();
		int i=0,j=0;
		while(i < array.length){
			while(i < array.length && array[i] == targetArray[j]){
				if(j == targetArray.length - 1){
					return i - targetArray.length + 1;
				}
				i++;
				j++;
			}
			if(j > 0){
				i = i-j + 1;
				j = 0;
			}else{
				i ++;
			}
		}
		return -1;
	}
}
