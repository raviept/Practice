package Chap7Ex4;

public class Pawn extends Piece{
	public Pawn(Color color){
		super(color);
	}
	
	public boolean isMoveValid(Board board, Point sour, Point dest){
		return (dest.getY() == sour.getY() +1) && (dest.getX() == sour.getY());
	}
}
