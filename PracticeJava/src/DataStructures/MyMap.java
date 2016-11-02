package DataStructures;

import java.util.List;
import java.util.Set;

public interface MyMap<K extends Comparable<K>,T>{
	public int size();
	
	public boolean isEmpty();
	
	public boolean containsKey(K key);
	
	public void put(K key, T data);
	
	public void remove(K key);
	
	public T get(K key);
	
	public Set<K> keySet();
	
	public List<T> values();
}