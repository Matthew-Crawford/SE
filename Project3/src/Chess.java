/*
 * $Id: Chess.java,v 1.9 2013/05/03 03:45:43 mjc5454 Exp $
 * 
 * $Log: Chess.java,v $
 * Revision 1.9  2013/05/03 03:45:43  mjc5454
 * implemented gui
 *
 * Revision 1.8  2013/05/03 01:30:47  mjc5454
 * Working on GUI
 *
 * Revision 1.7  2013/05/02 06:51:16  mjc5454
 * ArrayList out of bounds error on rook and bishop
 *
 * Revision 1.6  2013/05/01 20:48:54  mjc5454
 * Pawn Implemented and working
 *
 * 
 * Chess.java
 * 
 * @author Matthew Crawford
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Chess extends Puzzle<ChessBoard> {
	/*
	 * Solves a chess solitate puzzle
	 */
	
	
	private static BufferedReader input;
	
	private String fileName;
	
	private ChessBoard board;
	
	public Chess(){
	}
	
	public Chess(ChessBoard board){
		this.board = board;
	}
	

	public int getRow(){
		return board.getRow();
	}
	
	public int getCol(){
		return board.getCol();
	}
	
	/*
	 * Get the starting config for this puzzle.
	 * @return the starting config
	 */
	public ChessBoard getStart(){
		return board;
	}
	
	/*
	 * Get the goal config for this puzzle.
	 * @return the goal config
	 */
	public boolean getGoal(ChessBoard chessBoard){
		int count = 0;
		for(int i = 0; i < chessBoard.getBoard().length;i++){
			for(int j = 0; j<chessBoard.getBoard()[i].length;j++){
				if(chessBoard.getBoard()[i][j] != null){
					count +=1;
				}
			}
		}
		if(count > 1){
			return false;
		}
		return true;
	}
	
	public ChessBoard getBoard(){
		return board;
	}
	
	
	/*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<ChessBoard> getNeighbors(ChessBoard config){
		return config.getNeighbors(config);
	}
	
	public boolean solveOneStep(){
		Chess chess = new Chess(board);
		
		Solver<ChessBoard> solve = new Solver<ChessBoard>(chess);
		
		ArrayList<ChessBoard> path = solve.solve();
		
		
		if(path.get(1) == null){
			return false;
		}
		else{
			board =  path.get(1);
			return true;
		}
	}
	
	
	/*
	 * main method
	 * executes the program
	 */
	public static void main(String[] args) throws IOException {
		
		
		String fileName = args[0];
		
		ChessBoard board = new ChessBoard();
		
		ChessPiece[][] chessBoard = board.buildBoard(fileName);
		
		ChessBoard newBoard = new ChessBoard(chessBoard);
		
		Chess chess = new Chess(newBoard);
		
		ChessViewControl gui = new ChessViewControl(newBoard);
		
		
		Solver<ChessBoard> solve = new Solver<ChessBoard>(chess);
		
		ArrayList<ChessBoard> path = solve.solve();
		
		if(path == null){
			System.out.println("There is no path");
		}
		else{
			int count = 0;
			for(ChessBoard chessconfig : path){ 
				System.out.print("Step: " + count);
				board.print(chessconfig);
				System.out.println();
				count++;
				System.out.println();
			}
		}
		
	}
	
	

}
