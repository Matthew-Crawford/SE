import java.util.ArrayList;

/*
 * Jug.java
 *
 * Version:
 * $Id: Jug.java,v 1.1 2013/04/30 03:59:04 mjc5454 Exp $
 *
 * Revisions:
 * $Log: Jug.java,v $
 * Revision 1.1  2013/04/30 03:59:04  mjc5454
 * added new bfs
 *
 * Revision 1.7  2013/04/30 00:19:24  p243-07t
 * Fixed memoization in the bfs
 *
 * Revision 1.6  2013/04/18 19:07:36  p243-07t
 * printing corrected
 *
 * Revision 1.5  2013/04/18 16:33:07  p243-07t
 * fixed bfs
 *
 * Revision 1.4  2013/04/17 22:44:39  p243-07t
 * Commented
 *
 * Revision 1.3  2013/04/17 22:25:20  p243-07t
 * BFS map needs work
 *
 * Revision 1.2  2013/04/17 00:23:01  p243-07t
 * Finished getNeighbors
 *
 * Revision 1.1  2013/04/16 22:48:15  p243-07t
 * Made BFS generic
 *
 *
 *@author Matthew Crawford 
 *@author Zack Richardson
 */
public class Jug {
	
	private ArrayList<Jug> jugs = new ArrayList<Jug>();
	private int capacity;
	private int amount;
	
	/*
	 * Constructor
	 */
	public Jug(Jug jug){
		this.amount = jug.amount;
		this.capacity = jug.capacity;
	}
	/*
	 * Constructor
	 */
	public Jug(int capacity, int amount){
		this.capacity = capacity;
		this.amount = amount;
		
	}
	
	/*
	 * @return the capacity
	 */
	public int getCapacity(){
		return capacity;
	}
	
	/*
	 * @return the amount
	 */
	public int getAmount(){
		return amount;
	}
	/*
	 * takes an ArrayList of Integers that represent capacity and returns an ArrayList of jugs
	 * @param jug the ArrayList of Integers being passed in
	 * @return the ArrayList of jugs
	 */
	public ArrayList<Jug> getJugs(ArrayList<Integer> jug){
		int i = 0;
		while(jug.size()>0){
			jugs.add(new Jug(jug.get(i),0));
			i++;
		}
		return jugs;
	}
	
	/*
	 * fills a jug to capacity
	 */
	public void fillJug(){
		amount = capacity;
	}
	
	/*
	 * emptys a jug
	 */
	public void pourAllOut(){
		amount = 0;
	}
	
	/*
	 * pours one jug into another
	 */
	public void pourIntoOther(Jug other){
		int otheravailableSpace = other.capacity-other.amount;
		int transfer = Math.min(otheravailableSpace, amount);
		amount -= transfer;
		other.amount += transfer;
	}
	
	public String toString(){
		return  "" + amount;
	}
	
	public int hashCode(){
		return amount * capacity;
	}
	
	public boolean equals(Object o){
	   if(o instanceof Jug){
			Jug other = (Jug) o;
			if((other.capacity == capacity) && (other.amount == amount)){
				return true;
			}
		}
		return false;
	}
	
}
