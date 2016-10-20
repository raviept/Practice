package Chap2;

import DataStructures.LinkNode;
import Gen.RandGen;

public class Ex4 {
	public static LinkNode<Integer> sum(LinkNode<Integer> a, LinkNode<Integer> b){
		LinkNode<Integer> prev = null, res = null;
		int carry = 0;
		
		while((carry > 0) || (a != null) || (b != null)){
			int x =  carry;
			if(a != null){
				x += a.getEl();
				a = a.getNext();
			}
			if(b != null){
				x += b.getEl();
				b = b.getNext();
			}
			
			LinkNode<Integer> aux = new LinkNode<Integer>(x%10);
			carry = x/10;
			if(prev == null){
				res = aux;
			}
			else{
				prev.setNext(aux);
			}
			prev = aux;
		}
		
		return res;
	}
	
	public static LinkNode<Integer> sumRec(LinkNode<Integer> a, LinkNode<Integer> b, int carry){
		if(carry == 0 && a == null && b==null)
			return null;
		int x = carry;
		if(a != null){
			x += a.getEl();
			a = a.getNext();
		}
		if(b != null){
			x += b.getEl();
			b = b.getNext();
		}
		carry = x/10;
		
		LinkNode<Integer> head = new LinkNode<Integer>(x%10);
		head.setNext(sumRec(a,b,carry));
		
		return head;
	}
	
	public static LinkNode<Integer> sum2(LinkNode<Integer> a, LinkNode<Integer> b){
		return sumRec(a,b,0);
	}
	
	public static void main(String []args){
		LinkNode<Integer> a = RandGen.genLink(3, 10);
		LinkNode<Integer> b = RandGen.genLink(5, 10);
		
		Prints.Prints.printList(a);
		Prints.Prints.printList(b);
		System.out.println("");
		Prints.Prints.printList(sum2(a,b));
	}
}
