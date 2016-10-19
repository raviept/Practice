package Prints;

import java.util.Iterator;

import DataStructures.LinkNode;

public class Prints {
	public static void printArr(int []arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void printMat(int [][]mat, int m, int n){
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static <T> void printList(LinkNode<T> head){
		if(head == null)
			return;
		Iterator<T> iter = head.iterator();
		
		while(iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		
		System.out.println("");
	}
}
