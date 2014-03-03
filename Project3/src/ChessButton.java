/*
 * $Id: ChessButton.java,v 1.2 2013/05/03 03:45:43 mjc5454 Exp $
 * 
 * $Log: ChessButton.java,v $
 * Revision 1.2  2013/05/03 03:45:43  mjc5454
 * implemented gui
 *
 * Revision 1.1  2013/05/03 01:30:47  mjc5454
 * Working on GUI
 *
 * 
 * ChessButton.java
 * 
 * @author Matthew Crawford
 */

import javax.swing.JButton;


public class ChessButton extends JButton {

/**Class definition for a button that represents a card in the concentration game.*/
	
	private int position;
	private int id;
	private String name;
	/*
	 * Construct a CardButton object.
	 * @param pos - The position or index of the represented card in the model.
	 */
	public ChessButton(String name,int pos,int id){
		super(name);
		this.position = pos;
		this.id = id;
	}
	
	public ChessButton(int pos,int id){
		this.position = pos;
		this.id = id;
	}
	
	/*
	 * Get the position of the card.
	 * @return An integer that is the position or index of the represented card in the model.
	 */
	public int getPos(){
		return position;
	}
	
	
	/*
	 * Get ID of the card
	 * @return the ID of the CardButton
	 */
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
		this.setText(name);
	}
	

}


