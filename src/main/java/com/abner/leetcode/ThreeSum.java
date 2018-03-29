package com.abner.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static void main(String[] args) {
		
	}
	
	public Set<List<Integer>> threeSum(int[] array, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.sort(array);
		for(int i =0; i < array.length -2; i++){
			int low = i + 1;
			int high = array.length - 1;
			while(low < high){
				if(array[i] + array[low] + array[high] == 0){
					set.add(Arrays.asList(array[i],array[low],array[high]));
					low ++;
					high --;
				}else if(array[i] + array[low] + array[high] > 0){
					high --;
				}else{
					low ++;
				}
			}
		}
		return set;
	}
}
