package Chap3;

import DataStructures.SetOfStacks;
import Exceptions.EmptyStackException;
import Exceptions.InvalidIndexException;
import Gen.RandGen;
import Prints.Prints;

public class Ex3 {
	public static void main(String []args){
		SetOfStacks<Integer> sOs = RandGen.genSetOfStacks(10, 20, 5);
		Prints.printData(sOs);
		
		try{
			/*
			System.out.println(sOs.pop());
			System.out.println(sOs.pop());
			Prints.printData(sOs);
			System.out.println(sOs.pop());
			System.out.println(sOs.pop());
			Prints.printData(sOs);
			System.out.println(sOs.pop());
			System.out.println(sOs.pop());
			System.out.println(sOs.pop());
			Prints.printData(sOs);
			System.out.println(sOs.pop());
			System.out.println(sOs.pop());*/
			
			System.out.println(sOs.popAt(0));
			Prints.printData(sOs);
		}
		catch(EmptyStackException | InvalidIndexException e){
			e.printStackTrace();
		}
	}
}
