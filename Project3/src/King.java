import java.util.ArrayList;
/*
 * $Id: King.java,v 1.2 2013/05/02 06:51:04 mjc5454 Exp $
 * 
 * $Log: King.java,v $
 * Revision 1.2  2013/05/02 06:51:04  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * Revision 1.1  2013/05/01 20:48:53  mjc5454
 * Pawn Implemented and working
 *
 */

public class King extends ChessPiece {
	
	public King(int row,int col){
		super(row,col);
	}
	
	public King(King king){
		super(king.row,king.col);
	}

	public ArrayList<ChessBoard> getNeighbors(ChessBoard config) {
		ArrayList<ChessBoard> boards = new ArrayList<ChessBoard>();
		
		int upperRow = row - 1;
		int upperCol = col - 1;
		
		
		
		for(int i = 0; i<=2;i++){
			if(canMove(config, upperRow, upperCol)){
				ChessBoard newConfig = move(row,col,upperRow,upperCol,config, 
						new King(upperRow, upperCol));
				boards.add(newConfig);
			}
			upperCol++;
		}
		
		int midRow = row;
		int midCol = col - 1;
		
		for(int i = 0; i<=1;i++){
			if(canMove(config, midRow, midCol)){
				ChessBoard newConfig = move(row,col,midRow,midCol,config, 
						new King(midRow, midCol) );
				boards.add(newConfig);
			}
			midCol++;
		}
	
		
		int lowerRow = row + 1;
		int lowerCol = col - 1;
		
		
		for(int i = 0; i<=2;i++){
			if(canMove(config, lowerRow, lowerCol)){
				ChessBoard newConfig = move(row,col,lowerRow,lowerCol,config, 
						new King(lowerRow, lowerCol) );
				boards.add(newConfig);
			}
				lowerCol++;
		}
		
		return boards;
	}

	public String toString() {
		return "K";
	}
	

}
