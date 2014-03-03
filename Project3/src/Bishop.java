/*
 * $Id: Bishop.java,v 1.2 2013/05/02 17:20:08 mjc5454 Exp $

 * 
 * $Log: Bishop.java,v $
 * Revision 1.2  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * Revision 1.1  2013/05/02 06:51:05  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * 
 * Bishop.java
 * 
 * @author Matthew Crawford
 */

import java.util.ArrayList;

public class Bishop extends ChessPiece {
	
	public Bishop(int row,int col){
		super(row,col);
	}
	
	public Bishop(Bishop bishop){
		super(bishop.row,bishop.col);
	}
	

	public ArrayList<ChessBoard> getNeighbors(ChessBoard config) {
		ArrayList<ChessBoard> boards = new ArrayList<ChessBoard>();
		
		int newRow = row;
		int newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow +=1;
			newCol +=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Bishop(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow +=1;
			newCol -=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Bishop(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow -=1;
			newCol +=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Bishop(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow -=1;
			newCol -=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Bishop(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		return boards;
	}

	public String toString() {
		return "B";
	}
}
