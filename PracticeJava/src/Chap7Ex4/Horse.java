package Chap7Ex4;

public class Horse extends Piece{
	public Horse(Color color){
		super(color);
	}
	
	public boolean isMoveValid(Board board, Point sour, Point dest){
		int dx = Math.abs(dest.getX() - sour.getX());
		int dy = Math.abs(dest.getY() - sour.getY());
		
		return ((dy == 1 && dx == 2) || (dx == 1 && dy == 2));
	}
}
