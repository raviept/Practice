package Chap7Ex4;

public class King extends Piece {
	public King(Color color){
		super(color);
	}
	
	@Override
	public boolean isMoveValid(Board board, Point source, Point dest) {
		int dx = Math.abs(source.getX() - dest.getX());
		int dy = Math.abs(source.getY() - dest.getY());
		
		if(board.underThreat(super.color,dest))
			return false;
		
		return ((dx == 0 && dy == 1) || (dx == 1 && dy == 0));
	}
}