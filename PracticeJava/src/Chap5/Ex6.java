package Chap5;

import java.util.Random;

import Prints.Prints;

public class Ex6 {

	public static int swapOdEv(int n){
		return (((n << 1) & 0xAAAAAAAA) | ((n >> 1) & 0x55555555));
	}
	
	public static void main(String []args){
		Random rand = new Random();
		int n = rand.nextInt(200);
		Prints.printLittleEndian(n);
		Prints.printLittleEndian(swapOdEv(n));
	}
}
