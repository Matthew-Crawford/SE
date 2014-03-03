/*
 * $Id: ChessViewControl.java,v 1.3 2013/05/03 03:45:43 mjc5454 Exp $
 * 
 * $Log: ChessViewControl.java,v $
 * Revision 1.3  2013/05/03 03:45:43  mjc5454
 * implemented gui
 *
 * Revision 1.2  2013/05/03 01:53:37  mjc5454
 * Added some commented
 *
 * Revision 1.1  2013/05/03 01:30:47  mjc5454
 * Working on GUI
 *
 * 
 * ChessViewContol.java
 * 
 * @author Matthew Crawford
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessViewControl {

	private JPanel panel;
	private JPanel southPanel;
	private JFrame frame; 
	private JButton reset;
	private JButton hint;
	private JButton cheat;
	private JLabel label;
	private ArrayList<ChessButton> ChessButtons;
	private ChessButton[][] grid;
	private Chess chess;
	private ChessBoard chessBoard;
	ChessPiece[][] board;
	
	public ChessViewControl( final ChessBoard chessBoard){
		chess = new Chess(chessBoard);
		int row = chessBoard.getRow();
		int col = chessBoard.getCol();
		
		board = chessBoard.getBoard();
		frame = new JFrame("Chess Solitare Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        southPanel = new JPanel();
        label = new JLabel("Moves: ",JLabel.LEFT);
        
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southPanel.setPreferredSize(new Dimension(50,50));
        
        panel.setLayout(new GridLayout(row,col));
        panel.setPreferredSize(new Dimension(300, 400));
        
        frame.getContentPane().add(panel);
        frame.getContentPane().add(southPanel,BorderLayout.SOUTH);
        frame.getContentPane().add(label,BorderLayout.NORTH);
        
        frame.pack();
        grid = new ChessButton[row][col];
        
        reset = new JButton("reset");
        reset.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                System.out.println("you clicked reset");
		}
	});
        hint = new JButton("hint");
        hint.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
            	if(chess.solveOneStep()){
            		update();
            	}
		}
	});

        southPanel.add(reset);
        southPanel.add(hint);
        
        
        
        /** Initializes ChessButtons, adds them to an ActionListner, and adds them to the grid*/
        int pos = 0;
        int id = 0;
        for(int i = 0; i< row;i++){
        	for(int j = 0; j< col;j++){
        	ChessButton button;
			if(board[i][j]!=null){
				 button = new ChessButton(board[i][j].toString(),pos,id);
			}
			else{
				 button = new ChessButton(pos,id);
			}
			id++;
			pos++;
			button.addActionListener( new ActionListener() {
	            public void actionPerformed( ActionEvent e ) {
	            	ChessButton but = (ChessButton)e.getSource();
	                System.out.println("you clicked" + but.getName());
			}
		});
        
			grid[i][j] = button;
			panel.add(grid[i][j]);
			frame.setVisible(true);
			
		
        }
        }
        
	}
	public void update(){
		for(int i = 0; i< chess.getRow();i++){
        	for(int j = 0; j< chess.getCol();j++){
        		if(chess.getBoard().getBoard()[i][j] != null)
        			grid[i][j].setText(chess.getBoard().getBoard()[i][j].toString());
        		else
        			grid[i][j].setText("");
        			
        	}
		}
	}
}
        

