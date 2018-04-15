package com.abner.leetcode;

import java.util.HashMap;
import java.util.Map;

//Brute force O(n^2)
//借助map 实现O(n)
public class TwoSum {
	public static void main(String[] args) {
		Integer i1 = new Integer(0);
		Integer i2 = new Integer(0);
		
		System.out.print(i1 == i2 ? "true" : "false");
	}
	
	public static int[] twoSum(int[] array, int target){
		
		Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i =0; i < array.length; i++){
			if(map.containsKey(target - array[i])){
				result[0] = i;
				result[1] = map.get(target - array[i]);
				return result;
			}
			map.put(array[i], i);
		}
		return result;
	}
}
