package DataStructures;

import java.util.Iterator;

public class Queue<T> implements DataStructure<T>{
	LinkNode<T> first = null;
	LinkNode<T> last = null;
	int size = 0;

	@Override
	public int size(){
		return this.size;
	}
	
	public void enqueue(T el){
		LinkNode<T> next = new LinkNode<>(el);
		if(last == null){
			last = next;
			first = last;
		}
		else{
			last.setNext(next);
		}
		size++;
	}
	
	public T dequeue(){
		T el = null;
		if(first != null){
			el = first.getEl();
			first = first.getNext();
			if(first == null)
				last = null;
			size--;
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
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			LinkNode<T> pointer = first;
			
			public boolean hasNext(){
				return this.pointer != null;
			}

			@Override
			public T next() {
				T el = pointer.getEl();
				pointer = pointer.getNext();
				return el;
			}			
		};
	}	
}
