package Gen;

import java.util.Random;

import DataStructures.KStack;
import DataStructures.LinkNode;
import DataStructures.Queue;
import DataStructures.SetOfStacks;
import DataStructures.Stack;
import DataStructures.StackWMin;
import Exceptions.FullStackException;

public class RandGen {
	public static int [][] genMat(int m, int n, int max){
		int [][] mat = new int[m][n];
		Random rand = new Random();
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				mat[i][j] = rand.nextInt(max);
			}
		}		
		
		return mat;
	}
	
	public static LinkNode<Integer> genLink(int n, int max){
		if(n <= 0)
			return null;
		Random rand = new Random();
		LinkNode<Integer> head = new LinkNode<>(rand.nextInt(max));
		while((--n) > 0){
			head.add(rand.nextInt(max));
		}
		
		return head;		
	}
	
	public static Queue<Integer> genQueue(int n, int max){
		if(n <= 0)
			return null;
		Random rand = new Random();
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < n; i++){
			queue.enqueue(rand.nextInt(max));
		}
		
		return queue;
	}
	
	public static StackWMin<Integer> genStackWMin(int n, int max){
		if(n <= 0)
			return null;
		Random rand = new Random();
		StackWMin<Integer> stack = new StackWMin<>();
		for(int i = 0; i < n; i++){
			stack.push(rand.nextInt(max));
		}
		
		return stack;
	}
	
	public static Stack<Integer> gentStack(int n, int max){
		return genStackWMin(n,max);
	}
	
	public static KStack<Integer,Integer> genKStack(int n, int max, int sSize){
		KStack<Integer,Integer> stack = new KStack<>(sSize);
		if(n <= 0)
			return stack;
		Random rand = new Random();
		
		for(int i = 0; i < sSize; i++){
			int s = rand.nextInt(n);
			try{
				stack.push(s, rand.nextInt(max));
			}
			catch(FullStackException e){
				e.printStackTrace();
			}
		}
		
		return stack;
	}
	
	public static SetOfStacks<Integer> genSetOfStacks(int n, int max, int maxSize){
		SetOfStacks<Integer> stack = new SetOfStacks<>(maxSize);
		Random rand = new Random();
		for(int i = 0; i < n; i++){
			stack.push(rand.nextInt(max));
		}
		
		return stack;
	}
}
