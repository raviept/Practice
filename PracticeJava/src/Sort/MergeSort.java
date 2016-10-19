package Sort;

import Prints.Prints;

public class MergeSort {
	
	public static void merge(int []arr, int p, int s){
		int [] aux = new int[s];
		int l2 = p + s;
		int l1 = p + s/2;
		int p1=p, p2 = p+s/2;
		for(int i = 0; i < s; i++){
			if((p2 >= l2) || (p1 < l1 && arr[p1] <= arr[p2])){
				aux[i] = arr[p1];
				p1++;
			}
			else{
				aux[i] = arr[p2];
				p2++;
			}
		}
		
		System.arraycopy(aux, 0, arr, p, s);
	}
	
	public static void mSortAux(int []arr, int p, int s){
		if(s <= 1)
			return;
		
		mSortAux(arr, p, s/2);
		mSortAux(arr, p + s/2, s- s/2);
		merge(arr,p,s);
	}
	
	public static void mSort(int []arr){
		mSortAux(arr,0,arr.length);
	}

	public static void main(String []args){
		int [] arr = {132,2,10,6};
		mSort(arr);
		Prints.printArr(arr);
	}
}