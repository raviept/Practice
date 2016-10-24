package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AVLNode<K extends Comparable<K>,T> {
	private AVLNode<K,T> left, right;
	private int bal = 0;
	private T data;
	private K key;
	
	public AVLNode(K key,T data){
		this.data = data;
		this.key = key;
	}
	
	public T getData(){
		return this.data;
	}
	
	public K getKey(){
		return this.key;
	}
	
	private static int boolToInt(boolean f){
		return (f)? 1 : 0;
	}
	
	private static <K extends Comparable<K>,T> AVLNode<K,T> rotateRight(AVLNode<K,T> root){
		AVLNode<K,T> l = root.left;
	    root.left = l.right;
	    l.right = root;
	    
	    int dr = 0;
	    int dlr = dr - root.bal - 1 - boolToInt(l.bal < 0);
	    int dll = dr - root.bal - 1 - boolToInt(l.bal > 0);
	    		
	    root.bal = dr - dlr;
	    l.bal = (1 + Math.max(dr, dlr)) - dll;
		
		return l;
	}
	
	private static <K extends Comparable<K>,T> AVLNode<K,T> rotateLeft(AVLNode<K,T> root){
		AVLNode<K,T> r = root.right;
	    root.right = r.left;
	    r.left = root;
	    
	    int dl = 0;
	    int drl = dl + root.bal - 1 - boolToInt(r.bal > 0);
	    int drr = dl + root.bal - 1 - boolToInt(r.bal < 0);

	    root.bal = drl - dl;
	    r.bal = drr - (1 + Math.max(dl, drl));
	    
		return r;
	}
	
	public static <K extends Comparable<K>,T> AVLNode<K,T> add(AVLNode<K,T> root, K key, T data){
		if(root == null)
			return new AVLNode<K,T>(key,data);
		
		if(root.key.compareTo(key) >= 0){
			int b = (root.left != null)? root.left.bal : -2;
			root.left = add(root.left,key,data);
			if((b == -2) || ((b == 0) && (root.left.bal != 0)))
				root.bal--;
			if(root.bal < -1){
				if(root.left.bal > 0){
					root.left = rotateLeft(root.left);
				}
				root = rotateRight(root);			
			}
		}
		else{
			int b = (root.right != null)? root.right.bal : 2;
			root.right = add(root.right,key,data);
			if((b == 2) || ((b == 0) && (root.right.bal != 0)))
				root.bal++;
			if(root.bal > 1){
				if(root.right.bal < 0){
					root.right = rotateRight(root.right);
				}
				root = rotateLeft(root);
			}
		}
		
		return root;
	}
	
	public int depth(){
		int dl = (this.left == null)? 0 : this.left.depth();
		int dr = (this.right == null)? 0 : this.right.depth();
		
		return 1 + ((dr > dl)? dr : dl);
	}
	
	private void preOrderFill(ArrayList<AVLNode<K,T>> arr, int l, int n){
		arr.set(l + (n/2),this);
		if(this.left != null){
			this.left.preOrderFill(arr, l, (n/2));
		}
		if(this.right != null){
			this.right.preOrderFill(arr, l + (n/2) + 1, n - (n/2) - 1);
		}
	}
	
	public int getBal(){
		return this.bal;
	}
	
	private static <K extends Comparable<K>,T> String avlNodeToString(AVLNode<K,T> node){
		return String.format(" <%2s,%2d> ", node.getKey().toString(), node.getBal());
	}
	
	private String stringRep(ArrayList<AVLNode<K,T>> arr, int dpt){
		StringBuilder sb = new StringBuilder();
		int sp = arr.size()/2;
		for(int i = 0; i < dpt; i++){
			int k = sp;
			for(int j = 0; j < arr.size(); j++){
				if(j == k){
					sb.append("    |    ");					
					k += 2*sp + 2;
				}
				else{
					sb.append("         ");
				}
			}
			sb.append(System.lineSeparator());
			k = sp;
			for(int j = 0; j < arr.size(); j++){
				if(j == k){
					AVLNode<K,T> node = arr.get(j);
					String val = (node != null)? avlNodeToString(node) : "    .    ";			
					sb.append(val);
					k += 2*sp + 2;
				}
				else{
					sb.append("         ");
				}
			}
			sb.append(System.lineSeparator());
			sp = sp/2;
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString(){
		int dpt = this.depth();
		System.out.println("Depth "+ dpt);
		int size = (1<<dpt) - 1;
		System.out.println("Size " + size);
		ArrayList<AVLNode<K,T>> arr = new ArrayList<>(size);
		for(int i = 0; i < size; i++){
			arr.add(null);
		}
		
		preOrderFill(arr, 0, size);
		return stringRep(arr,dpt);
	}
	
	public static void main(String []args){
		AVLNode<Integer,String> root = null;
		Scanner scan = new Scanner(System.in);
		String data;
		do{
			int key = Integer.parseInt(scan.nextLine());
			data = scan.nextLine();
			root = add(root,key,data);
			System.out.println(root);
		}while(!data.equals("q"));
		scan.close();
	}
}
