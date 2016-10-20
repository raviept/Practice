package DataStructures;

public class Queue<T> {
	LinkNode<T> first = null;
	LinkNode<T> last = null;
	
	public void enqueue(T el){
		LinkNode<T> next = new LinkNode<>(el);
		if(last == null){
			last = next;
			first = last;
		}
		else{
			last.setNext(next);
		}
	}
	
	public T dequeue(){
		T el = null;
		if(first != null){
			el = first.getEl();
			first = first.getNext();
			if(first == null)
				last = null;
		}
		return el;
	}
	
	public T peek(){
		T el = null;
		if(first != null){
			el = first.getEl();
		}
		
		return el;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
}
