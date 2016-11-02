package Mix;

public class StringUtils {
	public static String center(String s, int size){
		int l = s.length();
		if(size <= l){
			return s;
		}
		
		StringBuilder sb = new StringBuilder(size);
		int sp = (size - l)/2;
		for(int i = 0; i < sp; i++)
			sb.append(' ');
		sb.append(s);
		for(int i = sp + l; i < size; i++)
			sb.append(' ');
		
		return sb.toString();
	}
}
