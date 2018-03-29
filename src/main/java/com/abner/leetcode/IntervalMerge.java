package com.abner.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// Input [1,3][2,6][15,18]
//Output [1,6][15,18]
public class IntervalMerge {
	public static void main(String[] args) {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
	}
	
	public static List<Interval> merge(List<Interval> intervals){
		
		if(intervals == null || intervals.size() == 0){
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		List<Interval> result = new ArrayList<Interval>();
		
		Interval pre = intervals.get(0);
		for(int i=1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if(pre.end >= curr.start){
				int max = Math.max(pre.end, curr.end);
				Interval merged = new Interval(pre.start, max);
				pre = merged;
			}else{
				result.add(pre);
				pre = curr;
			}
		}
		result.add(pre);
		return result;
	}
}

class Interval {
	int start;
	int end;
	Interval() {start = 0; end = 0;}
	Interval(int start, int end){this.start = start; this.end = end;}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval o1, Interval o2) {
		return o1.start - o2.start;
	}
}

class IntervalComparator2 implements Comparable<Interval> {

	public int compareTo(Interval o) {
		return 0;
	}
	
}
