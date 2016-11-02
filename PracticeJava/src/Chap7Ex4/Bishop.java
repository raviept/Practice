package Chap7Ex4;

public class Bishop extends Piece{
	public Bishop(Color color){
		super(color);
	}
	
	public boolean isMoveValid(Board board, Point sour, Point dest){
		int dx = dest.getX() - sour.getX();
		int dy = dest.getY() - sour.getY();
		
		if(dx == 0 && dy == 0)
			return false;
		
		if(Math.abs(dx) != Math.abs(dy) || dx == 0)
			return false;
			
		return board.freePath(sour,dest);
	}
}