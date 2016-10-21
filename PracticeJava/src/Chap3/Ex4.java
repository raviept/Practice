package Chap3;

import DataStructures.Stack;
import Exceptions.EmptyStackException;
import Prints.Prints;

public class Ex4 {
	public static <T> void hanoi(Stack<T> a, Stack<T> b, 
			Stack<T> c, int n) throws EmptyStackException{
		if(n<=0)
			return;
		hanoi(a,c,b,n-1);
		c.push(a.pop());
		hanoi(b,a,c,n-1);
		Prints.printData(a);
		Prints.printData(b);
		Prints.printData(c);
	}
	
	public static void main(String []args){
		Stack<Integer> a = new Stack<>(), b = new Stack<>(), c = new Stack<>();
		
		for(int i = 3; i>= 1; i--)
			a.push(i);
		
		try{
			hanoi(a,b,c,3);
		}
		catch(EmptyStackException e){
			e.printStackTrace();
		}		
	}
}
