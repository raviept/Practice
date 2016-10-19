package Sort;

import Prints.Prints;
import Switch.Switch;

public class QuickSort {
	public static void qSortAux(int []arr, int p, int s){
		if(s <= 0)
			return;
		
		//printArr(arr);
		
		int i = p;
		int j =  p + s-1;
		
		
		while(i < j){
			if(arr[i+1] <= arr[i]){
				Switch.switches(arr, i, i+1);
				i++;
			}
			else{
				Switch.switches(arr, i+1, j);
				j--;
			}
		}
				
		qSortAux(arr, p, i-p);
		qSortAux(arr, i+1, s - i + p - 1);		
	}
	
	public static void qSort(int []arr){
		qSortAux(arr, 0, arr.length);
	}
	
	public static void qSort(char [] arr){
		int [] vals = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			vals[i] = (int)arr[i];
		}
		qSort(vals);
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (char)vals[i]; 
		}
	}
	
/*
	public static <T extends Comparable<? super T>> void quickSort(T [] arr){
		
	}*/
	
	public static void main(String []args){
		int []arr = {2,1,5,5,-1,10,2,100};
		
		qSort(arr);
		
		Prints.printArr(arr);
	}
}
