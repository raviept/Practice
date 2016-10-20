package Chap2;

import java.util.Random;

import DataStructures.LinkNode;
import Gen.RandGen;
import Prints.Prints;

public class Ex5 {
	public static <T> LinkNode<T> startCycle(LinkNode<T> head){
		LinkNode<T> fast = head, slow = head;
		
		do{
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}while(fast != slow);
		
		fast = head;
		while(fast != slow){
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		return fast;
	}
	
	public static <T> void createCycle(LinkNode<T> head, int pos, int n){
		LinkNode<T> last = head, node = null;
		while(last.getNext() != null){
			if(pos == 0){
				node = last;
			}
			last = last.getNext();
			pos--;
		}
		if(node == null)
			node = last;
		
		last.setNext(node);		
	}
	
	public static void main(String []args){
		LinkNode<Integer> head = RandGen.genLink(7, 20);
		Prints.printList(head);
		
		Random rand = new Random();
		int pos = rand.nextInt(7);
		
		System.out.println(pos + "\n");
		createCycle(head, pos, 7);
		System.out.println(startCycle(head).getEl());
	}
}