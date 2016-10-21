package Chap3;

import DataStructures.StackWMin;
import Exceptions.EmptyStackException;
import Gen.RandGen;
import Prints.Prints;

public class Ex2 {

	public static void main(String []args){
		StackWMin<Integer> stack = RandGen.genStackWMin(10, 20);
		Prints.printData(stack);

		try{
			System.out.println(stack.min());
			stack.pop();
			stack.pop();
			Prints.printData(stack);
			System.out.println(stack.min());
			stack.pop();
			stack.pop();
			Prints.printData(stack);
			System.out.println(stack.min());
		}
		catch(EmptyStackException e){
			e.printStackTrace();
		}
	}
}
