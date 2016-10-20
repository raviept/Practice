package Chap2;

import DataStructures.LinkNode;
import Gen.RandGen;
import Prints.Prints;

public class Ex2 {

	public static <T> LinkNode<T> nToLast(LinkNode<T> head, int n){
		if(head == null || n<=0)
			return null;
		
		LinkNode<T> p1 = head, p2 = head;
		
		do{
			n--;
			p2 = p2.getNext();
		}while(p2 != null && n>0);
		
		if(n> 0 && p2 == null)
			return null;
		
		while(p2 != null){
			p2 = p2.getNext();
			p1 = p1.getNext();
		}
		
		return p1;
	}
	
	public static void main(String []args){
		LinkNode<Integer> head = RandGen.genLink(10, 20);
		Prints.printList(head);
		System.out.println(nToLast(head,11).getEl());
	}
}
