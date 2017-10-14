package com.abner.leetcode;

//1-10 Ⅰ Ⅱ Ⅲ Ⅳ Ⅴ Ⅵ Ⅶ Ⅷ Ⅸ Ⅹ
// I=1，V=5，X=10，L=50，C=100，D=500，M=1000
// 3999 = MMMCMXCIX

public class IntToRoman {
	public static void main(String[] args) {
		IntToRoman o = new IntToRoman();
		System.out.println(o.intToRoman(3999));
	}
	
	String M[] = {"","M","MM","MMM"};
	String C[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	String X[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	String I[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	
	public String intToRoman(int num) {
 		
		StringBuffer sb = new StringBuffer();
		sb.append(M[num / 1000]).append(C[num % 1000 / 100]).append(X[num % 100 / 10]).append(I[num % 10]);
		return sb.toString();
	}
	
}