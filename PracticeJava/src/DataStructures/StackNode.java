package DataStructures;

public class StackNode<T> {
	LinkNode<T> head = null;
	
	public void push(T el){
		LinkNode<T> next = head;
		head = new LinkNode<T>(el);
		head.setNext(next);
	}
	
	public T pop(){
		T el = null;
		if(head != null){
			el = head.getEl();
			head = head.getNext();
		}
		return el;
	}
	
	public T peek(){
		T el = null;
		if(head != null){
			el = head.getEl();
		}
		return el;
	}
}
