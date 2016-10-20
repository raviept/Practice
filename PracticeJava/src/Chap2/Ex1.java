package Chap2;

import DataStructures.LinkNode;
import Gen.RandGen;
import Prints.Prints;

public class Ex1 {

	public static void main(String []args){
		LinkNode<Integer> head = RandGen.genLink(10, 7);
		
		Prints.printList(head);
		System.out.print("");
		LinkNode.removeDup(head);
		Prints.printList(head);
	}
}