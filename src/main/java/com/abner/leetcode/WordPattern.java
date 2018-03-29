package com.abner.leetcode;

import java.util.HashMap;
import java.util.Map;

// "abba" -> "cat dog dog cat"
//Note: containsValue 方法
public class WordPattern {
	public static void main(String[] args) {
		
	}
	
	public static boolean isMatched(String str, String pattern){
		
		String[] strings = str.split(" ");
		if(strings.length != pattern.length()){
			return false;
		}
		
		Map<Character, String> map = new HashMap<Character, String>();
		
		for(int i=0; i<pattern.length(); i++){
			Character character = pattern.charAt(i);
			if(map.containsKey(character)){
				if(! map.get(character).equals(strings[i])){
					return false;
				}
			}else{
				if(map.containsValue(strings[i])){
					return false;
				}
				map.put(character, strings[i]);
			}
		}
		
		return true;
	}
}
