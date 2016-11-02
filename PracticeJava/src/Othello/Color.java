package Othello;

public enum Color {
	BLACK,
	WHITE;
	
	public Color flip(){
		return (this==BLACK)? WHITE : BLACK;
	}
}
