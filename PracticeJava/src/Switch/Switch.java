package Switch;

public class Switch {
	public static void switches(int []arr, int i, int j){
		arr[i] = arr[j] - arr[i];
		arr[j] -= arr[i];
		arr[i] += arr[j];
	}
	
	public static void switches(Object []arr, int i, int j){
		Object tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
