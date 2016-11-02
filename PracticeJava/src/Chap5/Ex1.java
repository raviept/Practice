package Chap5;

import Prints.Prints;

public class Ex1 {
	public static int copy(int n, int m, int i, int j){
		if(j<i) return n;
		int flag = (~((1<<(i+1)) - 1)) | ((1<<j)-1);
		return (n&flag)|(m << i);
	}
	
	public static void main(String [] args){
		int n = 1<<11, m = 21;
		Prints.printLittleEndian(n);
		Prints.printLittleEndian(m);
		Prints.printLittleEndian(copy(n,m,2,6));
	}
}