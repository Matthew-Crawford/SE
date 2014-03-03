import java.util.ArrayList;

/*
 * $Id: Rook.java,v 1.2 2013/05/02 17:20:08 mjc5454 Exp $

 * 
 * $Log: Rook.java,v $
 * Revision 1.2  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * Revision 1.1  2013/05/02 06:51:14  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * 
 * rook.java
 * 
 * @author Matthew Crawford
 */
public class Rook extends ChessPiece {
	
	public Rook(int row,int col){
		super(row,col);
	}
	
	public Rook(Rook rook){
		super(rook.row,rook.col);
	}

	public ArrayList<ChessBoard> getNeighbors(ChessBoard config) {
		ArrayList<ChessBoard> boards = new ArrayList<ChessBoard>();
		int newRow = row;
		int newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow +=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Rook(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow -=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Rook(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getCol();i++){
			newCol +=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newCol,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Rook(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
		newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getCol();i++){
			newCol -=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Rook(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		return boards;
	}

	
	public String toString() {
		return "R";
	}
	
	

}
