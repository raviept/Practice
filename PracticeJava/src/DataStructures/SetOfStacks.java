package DataStructures;

import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.EmptyStackException;
import Exceptions.InvalidIndexException;

public class SetOfStacks<T extends Comparable<T>> implements DataStructure<T>{
	private int maxSize;
	private ArrayList<Stack<T>> arrStack = new ArrayList<>();
	private int size = 0;
	
	public SetOfStacks(int maxSize){
		this.maxSize = maxSize;
	}
	
	public void push(T val){
		Stack<T> st;
		if(size == 0 || arrStack.get(arrStack.size()-1).size() == maxSize){
			st = new Stack<>();
			arrStack.add(st);
		}
		else
			st = arrStack.get(arrStack.size() - 1);
		st.push(val);		
		this.size ++;
	}
	
	public T pop() throws EmptyStackException{
		if(arrStack.size() == 0)
			throw new EmptyStackException("The stack is empty!");
		Stack<T> st = arrStack.get(arrStack.size()-1);
		T val = st.pop();
		if(st.isEmpty())
			arrStack.remove(arrStack.size() - 1);
		this.size--;
		
		return val;
	}
	
	private T popFirst(int index) throws EmptyStackException{
		Stack<T> st = arrStack.get(index);
		T val = st.removeBottom();
		
		if(index < arrStack.size()-1)
			st.push(popFirst(index+1));
		else if(st.isEmpty())
			arrStack.remove(index);
		
		return val;
	}
	
	public T popAt(int index) throws EmptyStackException, InvalidIndexException{
		if(this.isEmpty())
			throw new EmptyStackException("Stack is empty!");
		if(index < 0 || index >= arrStack.size())
			throw new InvalidIndexException("Index out of bounds!");
		
		this.size--;
		
		if(index == arrStack.size() - 1)
			return this.pop();
		else{
			Stack<T> st = arrStack.get(index);
			T val = st.pop();
			st.push(popFirst(index+1));
			
			return val;
		}
	}
	
	@Override
	public int size(){
		return this.size;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			private int stackPoint = arrStack.size() - 1;
			private Iterator<T> iter = setIter(stackPoint);
			
			private Iterator<T> setIter(int n){
				if(stackPoint >= 0)
					return arrStack.get(stackPoint).iterator();
				else
					return null;
			}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (stackPoint >= 0 && iter.hasNext());
			}

			@Override
			public T next() {
				T val = iter.next();
				if(!iter.hasNext()){
					stackPoint--;
					iter = setIter(stackPoint);
				}			
					
				return val;
			}
			
		};
	}
	
	@Override
	public boolean isEmpty() {
		return arrStack.size() == 0;
	}
	
}
