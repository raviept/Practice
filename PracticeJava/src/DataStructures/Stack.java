package DataStructures;

import java.util.Iterator;

import Exceptions.EmptyStackException;

public class Stack<T> implements DataStructure<T>{
	private LinkNode<T> head = null;
	private int size;
	
	public void push(T el){
		LinkNode<T> next = head;
		head = new LinkNode<T>(el);
		head.setNext(next);
		this.size++;
	}
	
	public T pop() throws EmptyStackException{
		if(this.isEmpty())
			throw new EmptyStackException("The stack is empty!");
		T el = this.head.getEl();
		this.head = this.head.getNext();
		this.size--;
		
		return el;
	}
	
	public T peek() throws EmptyStackException{
		if(this.isEmpty())
			throw new EmptyStackException("The stack is empty!");
		
		return this.head.getEl();
	}
		
	public boolean isEmpty(){
		return this.head == null;
	}
	
	@Override
	public int size(){
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			LinkNode<T> pointer = head;
			
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

	T removeBottom() throws EmptyStackException{
		if(this.isEmpty()){
			throw new EmptyStackException("Stack is empty!");
		}
		this.size--;
		
		if(head.getNext() == null){
			T val = head.getEl();
			this.head = null;
					
			return val;
		}
		
		LinkNode<T> prev = head, ahead = prev.getNext();
		while(ahead.getNext() != null){
			prev = ahead;
			ahead = ahead.getNext();
		}
		
		prev.setNext(null);
		return ahead.getEl();
	}	
}
