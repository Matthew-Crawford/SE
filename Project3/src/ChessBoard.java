/*
 * Version:
 * $Id: ChessBoard.java,v 1.8 2013/05/03 01:53:37 mjc5454 Exp $
 *
 * Revisions:
 * $Log: ChessBoard.java,v $
 * Revision 1.8  2013/05/03 01:53:37  mjc5454
 * Added some commented
 *
 * Revision 1.7  2013/05/02 17:20:08  mjc5454
 * All ChessPieces work with the bfs
 *
 * Revision 1.6  2013/05/02 06:51:16  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * Revision 1.5  2013/05/01 20:48:54  mjc5454
 * Pawn Implemented and working
 *
 * Revision 1.4  2013/05/01 07:23:28  mjc5454
 * almost done with pawn
 *
 * Revision 1.3  2013/05/01 02:13:32  mjc5454
 * Implemented Pawn.java
 *
 * Revision 1.2  2013/04/30 05:53:52  mjc5454
 * created chessboard class
 *
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ChessBoard {

	private static BufferedReader input;
	
	
	private static int row;
	private static int col;
	
	private ChessPiece[][] board;
	
	public ChessBoard(){
		
	}
	
	/*
	 * Constructor
	 * Constructs a ChessBoard with a 2d array of ChessPieces
	 */
	public ChessBoard(ChessPiece[][] board){
		this.board = board;
		
	}
	
	/*
	 * Constructor
	 * Copy Constructor, deep copys a give ChessBoard
	 */
	public ChessBoard (ChessBoard chessBoard){
		this.board = new ChessPiece[row][col];
		for(int i = 0; i < row;i++){
			for(int j = 0; j<col;j++){
				if(chessBoard.getBoard()[i][j] != null){
					this.board[i][j] = chessBoard.getBoard()[i][j];
				}
				else if(chessBoard.getBoard()[i][j] == null){
					this.board[i][j] = null;
				}
			}	
		}
		
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public ChessPiece[][] getBoard(){
		return this.board;
	}
	
	/*
	 * builds the board by reading lines in a given file
	 * NOTE-this only works with text files that have no spaces in between characters
	 * @parm fileName the name of the file
	 * @return an array of ChessPieces
	 */
	public ChessPiece[][] buildBoard(String fileName) throws IOException{
		String line;
		input = new BufferedReader(new FileReader(fileName)); 
		
		
	    line = input.readLine();

	    row = Integer.parseInt(line.substring(0,1));
	    col = Integer.parseInt(line.substring(2));
		
		board = new ChessPiece[row][col];
		
		for(int i = 0; i<row; i++){
			line = input.readLine();
			for(int j = 0; j<col;j+=1){
				char piece = line.charAt(j);
				ChessPiece chessPiece = null;
				
				switch(piece){
				
					case '.': 
						chessPiece = null;
						break;
					
					case 'P': 
						chessPiece  = new Pawn(i,j);
						break;
						
					case 'K': 
						chessPiece = new King(i,j);
						break;
						
					case 'N': 
						chessPiece = new Knight(i,j);
						break;	
					
						
					case 'B': 
						chessPiece = new Bishop(i,j);
						break;
					
					case 'R': 
						chessPiece = new Rook(i,j);
						break;
					
					case 'Q': 
						chessPiece = new Queen(i,j);
						break;
					
				}
				
					board[i][j] = chessPiece;
			}
		}
	return board;

	}

	
	/*
	 * updates the board, removes a ChessPiece from the old position and gives it a new position
	 * @param oldRow the original row
	 * @param oldCol the original colum
	 * @param piece the piece that is being moved
	 * @param oldBoard the board being modified
	 * @return an updated board containing the moved piece
	 */
	public ChessBoard updateBoard(int oldRow, int oldCol, int row, int col, ChessPiece piece, ChessBoard oldBoard){
		ChessPiece[][]chessBoard = oldBoard.getBoard();
		chessBoard[oldRow][oldCol] = null;
		chessBoard[row][col] = piece;
		ChessBoard newBoard = new ChessBoard(chessBoard);
		return newBoard;
	}
	
	/*
	 * checks if the space at (row,col) is occupied
	 */
	public boolean isOccupied(int row, int col){
		if(board[row][col] == null){
			return false;
		}
		return true;
		
	}
	
	/*
	 * checks to see if the space at (row,col) exists on the board
	 */
	public boolean validateSpace(int otherRow, int otherCol){
		if( (otherRow < 0 || otherCol < 0) || (otherRow>= row || otherCol>=col)){
			return false;
		}
		return true;
	}
	
	
	/*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<ChessBoard> getNeighbors(ChessBoard config){
		ArrayList<ChessBoard> neighbors = new ArrayList<ChessBoard>();
		for(int i = 0; i < board.length;i++){
			for(int j = 0; j<board[i].length;j++){
				if(board[i][j] != null){
					neighbors.addAll(board[i][j].getNeighbors(config));
				}
			}
		}
		return neighbors;
	
	}
	
	/*
	 * prints a ChessBoard
	 */
	public void print(ChessBoard chessBoard){
		for(int i = 0; i<row;i++){
			System.out.println();
			for(int j = 0; j<col;j+=1){
				ChessPiece piece = chessBoard.getBoard()[i][j];
				if(piece == null){
					System.out.print(".");
				}
				else{
					System.out.print(piece);
				}
			}
		}
			
	}
	
	public String toString(){
		String line = "";
		for(int i = 0; i<row;i++){
			for(int j = 0; j<col;j+=1){
				ChessPiece piece = this.board[i][j];
				if(piece == null){
					line += ".";
				}
				else{
					line += piece;
				}
			}
			line += "\n";
		}
		return line;
	}
	
		

	public int hashCode(){
		return this.toString().hashCode();
	}
	
	public boolean equals(Object o){
		if(o instanceof ChessBoard){
			ChessBoard other = (ChessBoard) o;
			if((other.row == row) && (other.col == col)){
				return true;
			}
		}
		return false;
	
	}
	
	
}

