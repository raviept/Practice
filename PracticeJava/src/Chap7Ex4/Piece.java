package Chap7Ex4;

public abstract class Piece {
	public static enum Color{
		BLACK,
		WHITE,
	}
	
	protected Color color;
	
	public Piece(Color color){
		this.color = color;
	}
	
	public abstract boolean isMoveValid(Board board, Point source, Point dest);
	
	public Color getColor(){
		return this.color;
	}
}
