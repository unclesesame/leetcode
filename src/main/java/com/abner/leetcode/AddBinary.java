package com.abner.leetcode;
//实现二进制加法
//StringBuilder reverse方法
//String的charAt方法
public class AddBinary {
	public static void main(String[] args) {
		String a = "10100";
		String b = "101";
		
		System.out.println(addBinary(a, b));
	}
	
	public static String addBinary(String a, String b){
		int carry = 0;
		int left = 0;
		//Notes:StringBuffer线程安全，StringBuilder线程不安全，
		//字符串拼接频繁如果使用String+的话会建立很多String对象，性能差 速度快慢为：StringBuilder > StringBuffer > String
		StringBuilder sBuilder = new StringBuilder();
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		int va = 0;
		int vb = 0;
		
		while(i >= 0 || j >= 0){
			va = i>=0 ? a.charAt(i--) - '0' : 0;
			vb = j>=0 ? b.charAt(j--) - '0' : 0;
			left = (va + vb + carry) % 2;
			carry = (va + vb + carry) / 2;
			sBuilder.append(left);
		}
		if(carry == 1){
			sBuilder.append(carry);
		}
		
		return sBuilder.reverse().toString();
	}
}
