import java.util.ArrayList;

/*
 * Version:
 * $Id: ChessPiece.java,v 1.5 2013/05/02 06:51:14 mjc5454 Exp $
 *
 * Revisions:
 * $Log: ChessPiece.java,v $
 * Revision 1.5  2013/05/02 06:51:14  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * Revision 1.4  2013/05/01 20:48:54  mjc5454
 * Pawn Implemented and working
 *
 * Revision 1.3  2013/05/01 07:23:28  mjc5454
 * almost done with pawn
 *
 * Revision 1.2  2013/05/01 02:13:32  mjc5454
 * Implemented Pawn.java
 *
 * Revision 1.1  2013/04/30 05:53:52  mjc5454
 * created chessboard class
 *
 * 
 */
public abstract class ChessPiece {
	/*
	 * abstract class that is extended by all chess pieces
	 */
	
	protected int row;
	protected int col;
	
	
	public ChessPiece(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	
	/*
	 * copy method
	 * @return a deep copy of a given ArrayList of boards
	 */
	public ArrayList<ChessBoard> copy(ArrayList<ChessBoard> chess){
		ArrayList<ChessBoard> chessPiece = new ArrayList<ChessBoard>();
		for(int i = 0; i<chess.size();i++){
			chessPiece.add(new ChessBoard(chess.get(i)));
		}
		return chessPiece;
	}
	
	/*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
	public abstract ArrayList<ChessBoard> getNeighbors(ChessBoard config);	

	public abstract String toString();
	
	public boolean canMove(ChessBoard config, int row, int col){
		return (config.validateSpace(row,col) && config.isOccupied(row,col));
	}
	
	public ChessBoard move(int oldRow, int oldCol, int row, int col,
			ChessBoard config, ChessPiece piece){
		ChessBoard newConfig = new ChessBoard(config);
		newConfig.updateBoard(oldRow,oldCol, row, col, piece,newConfig);
		return newConfig;
	}
	

}
	
	
