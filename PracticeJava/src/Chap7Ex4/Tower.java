package Chap7Ex4;

public class Tower extends Piece{
	public Tower(Color color){
		super(color);
	}
	
	public boolean isMoveValid(Board board, Point sour, Point dest){
		if((sour.getX() != dest.getX()) && (sour.getY() != dest.getY()))
			return false;
		
		return board.freePath(sour, dest);
	}
}