package Switch;

public class Switch {
	public static void switches(int []arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void switches(Object []arr, int i, int j){
		Object tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
