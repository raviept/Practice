package DataStructures;

import java.util.List;

public interface Tree<T> {
	public int depth();
	
	public List<T> inOrder();
}
