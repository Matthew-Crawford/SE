import java.util.ArrayList;

/*
 * $Id: Pawn.java,v 1.5 2013/05/02 17:20:08 mjc5454 Exp $
 * 
 * $Log: Pawn.java,v $
 * Revision 1.5  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * Revision 1.4  2013/05/02 06:51:15  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * Revision 1.3  2013/05/01 20:48:54  mjc5454
 * Pawn Implemented and working
 *
 * Revision 1.2  2013/05/01 07:23:28  mjc5454
 * almost done with pawn
 *
 * Revision 1.1  2013/05/01 02:13:32  mjc5454
 * Implemented Pawn.java
 *
 */
public class Pawn extends ChessPiece{

	public Pawn(int row,int col){
		super(row,col);
	}
	
	public Pawn(Pawn pawn){
		super(pawn.row,pawn.col);
	}
	

	
	
	public ArrayList<ChessBoard> getNeighbors(ChessBoard config){
		ArrayList<ChessBoard> boards = new ArrayList<ChessBoard>();
		
		int newRow = row -1;
		int newCol = col +1; 
		if(canMove(config, newRow, newCol)){
			ChessBoard newConfig = move(row,col,newRow,newCol,config, 
					new Pawn(newRow, newCol) );
			boards.add(newConfig);
		}
			
		newRow = row -1;
		newCol = col -1;
		
		if(canMove(config, newRow, newCol)){
			ChessBoard newConfig = move(row,col,newRow,newCol,config, 
					new Pawn(newRow, newCol) );
			boards.add(newConfig);
		}
			
			
			return boards;
		}
	
	
	
	public String toString(){
		return "P";
	}
}
