package Chap7Ex7;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class User {

	private String nick;
	private InetAddress address;
	private List<User> friends;
	
	public User(String nick, InetAddress address){
		this.nick = nick;
		this.address = address;
		
		this.friends = new ArrayList<>();
	}
	
	public String getNick(){
		return this.nick;
	}
	
	public InetAddress getAddress(){
		return this.address;
	}
	
	public void addFriend(User user){
		this.friends.add(user);
	}
	
	public void send(Message message){
		
	}
}
