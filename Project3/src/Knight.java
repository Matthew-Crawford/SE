import java.util.ArrayList;

/*
 * $Id: Knight.java,v 1.2 2013/05/02 17:20:08 mjc5454 Exp $
 * 
 * $Log: Knight.java,v $
 * Revision 1.2  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * Revision 1.1  2013/05/02 06:51:10  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * 
 * Knight.java
 * 
 * @author Matthew Crawford
 */
public class Knight extends ChessPiece {

	public Knight(int row,int col){
		super(row,col);
	}
	
	public Knight(Knight Knight){
		super(Knight.row,Knight.col);
	}


	public ArrayList<ChessBoard> getNeighbors(ChessBoard config) {
		ArrayList<ChessBoard> boards = new ArrayList<ChessBoard>();
		
		int newRow = row - 1;
		int newCol = col - 2;
		
		for(int i = 0; i<=1;i++){
			if(canMove(config, newRow, newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Knight(newRow, newCol) );
				boards.add(newConfig);
			}
			newRow--;
			newCol++;
		}
			
		
		newRow = row - 2;
		newCol = col + 1;
		
		for(int i = 0; i<=1;i++){
			if(canMove(config, newRow, newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Knight(newRow, newCol) );
				boards.add(newConfig);
			}
			newRow++;
			newCol++;
		}
		
		newRow = row + 1;
		newCol = col - 2;
		
		for(int i = 0; i<=1;i++){
			if(canMove(config, newRow, newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Knight(newRow, newCol) );
				boards.add(newConfig);
			}
			newRow++;
			newCol++;
		}
		
		newRow = row + 2;
		newCol = col + 1;
		
		for(int i = 0; i<=1;i++){
			if(canMove(config, newRow, newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Knight(newRow, newCol) );
				boards.add(newConfig);
			}
			newRow--;
			newCol++;
		}
		
		
		
		
		
		return boards;
	}


	public String toString() {
		return "N";
	}
	
	
}
