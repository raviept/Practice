package Chap1;

public class Ex4 {
	public static boolean areAnagrams(String st1, String st2){
		if(st1 == null || st2 == null)
			return false;
		
		if(st1.length() != st2.length())
			return false;
		
		int len = st1.length();
		boolean []flag = new boolean[len];
		for(int i = 0; i < len; i++){
			int j = 0;
			char c = st1.charAt(i);
			for(j = 0; (j < len) && (flag[j] || st2.charAt(j)!=c); j++);
			if(j==len)
				return false;
			flag[j] = true;
		}
		
		return true;
	}
	
	public static void main(String []args){
		System.out.println("1 - " + areAnagrams("","eqwe"));
		System.out.println("2 - " + areAnagrams("abc","abc"));
		System.out.println("3 - " + areAnagrams("abc","cab"));
		System.out.println("4 - " + areAnagrams("abc","123"));
		System.out.println("5 - " + areAnagrams("xavier","reivax"));
		System.out.println("6 - " + areAnagrams("xavier","reivaz"));
		System.out.println("7 - " + areAnagrams("tomar","amort"));
		System.out.println("8 - " + areAnagrams("crack","corck"));
	}
}
