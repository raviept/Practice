package Chap7Ex7;

import DataStructures.Graph;

public class Server {
	private Graph<User> users = new Graph<>();
	
	public void addUser(User user){
		users.addEdge(user, user);
	}
	
	public void addFriendship(User a, User b){
		users.addEdge(a, b);
		users.addEdge(b, a);
	}
}