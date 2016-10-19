package Chap1;

import Sort.QuickSort;

public class Ex1 {
	public static boolean hasUniqueCharsIneff(String str){
		for(int i = 0; i < str.length(); i++){
			for(int j = i+1; j < str.length(); j++){
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean hasUniqueCharsMed(char [] str){		
		QuickSort.qSort(str);
		
		for(int i = 0; i < str.length-1;i++){
			if(str[i] == str[i+1])
				return false;
		}
		
		return true;
	}
	
	public static boolean hasUniqueCharsData(String str){
		int []count = new int[Character.BYTES << 3];
		
		for(int i = 0; i < str.length(); i++){
			count[str.charAt(i)]++;
			if(count[str.charAt(i)] > 1)
				return false;
		}
		
		return true;
	}
	
	public static void main(String [] args){
		System.out.println(hasUniqueCharsMed("bcaa aqweqwe".toCharArray()));
	}
}
