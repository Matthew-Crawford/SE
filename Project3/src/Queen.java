import java.util.ArrayList;

/*
 * $Id: Queen.java,v 1.1 2013/05/02 17:20:08 mjc5454 Exp $
 * 
 * $Log: Queen.java,v $
 * Revision 1.1  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * 
 * Queen.java
 * 
 * @author Matthew Crawford
 */
public class Queen extends ChessPiece {


	public Queen(int row,int col){
		super(row,col);
	}
	
	public Queen(Queen queen){
		super(queen.row,queen.col);
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
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		
	    newRow = row;
		newCol = col;
		for(int i = 0; i<=config.getRow();i++){
			newRow +=1;
			newCol +=1;
			if(config.validateSpace(newRow,newCol) && !config.isOccupied(newRow,newCol)){
				continue;
			}
			else if(canMove(config,newRow,newCol)){
				ChessBoard newConfig = move(row,col,newRow,newCol,config, 
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
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
						new Queen(newRow, newCol) );
				boards.add(newConfig);
				break;
			}
			
		}
		return boards;
	}
	

	public String toString() {
		return "Q";
	}
	
	
	
}