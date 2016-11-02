package Othello;

public class Point {
	public final int x;
	public final int y;

	private Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static Point valueOf(int x, int y){
		return new Point(x, y);
	}
}