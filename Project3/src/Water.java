import java.util.ArrayList;
import java.util.Collections;

/**
 * Water.java
 * $Id: Water.java,v 1.1 2013/04/30 03:59:04 mjc5454 Exp $
 * 
 * $Log: Water.java,v $
 * Revision 1.1  2013/04/30 03:59:04  mjc5454
 * added new bfs
 *
 * Revision 1.12  2013/04/30 00:19:24  p243-07t
 * Fixed memoization in the bfs
 *
 * Revision 1.11  2013/04/18 19:18:06  p243-07t
 * finished project
 *
 * Revision 1.10  2013/04/18 19:07:37  p243-07t
 * printing corrected
 *
 * Revision 1.9  2013/04/18 17:50:02  p243-07t
 * Finished and testing
 *
 * Revision 1.8  2013/04/18 17:25:39  p243-07t
 * running program
 *
 * Revision 1.7  2013/04/18 16:33:07  p243-07t
 * fixed bfs
 *
 * Revision 1.6  2013/04/17 22:44:39  p243-07t
 * Commented
 *
 * Revision 1.5  2013/04/17 22:25:23  p243-07t
 * BFS map needs work
 *
 * Revision 1.4  2013/04/17 00:23:01  p243-07t
 * Finished getNeighbors
 *
 * Revision 1.3  2013/04/16 22:42:51  p243-07t
 * Made BFS generic
 *
 * Revision 1.2  2013/04/16 17:09:03  p243-07t
 * Added cvs tags
 *
 * 
 * @author Zack Richardson
 * @author Matthew Crawford
 *
 */
public class Water extends Puzzle<ArrayList<Jug>>{
	
	/*
	 * A water puzzle that finds the quickest way to fill one jug with the desired amount
	 */
	
	private static int goal;
	private ArrayList<Integer> jugs;
	private static String printed;
	/*
	 * Constructor
	 */
	public Water(int goal, ArrayList<Integer> jugs){
		this.jugs = jugs;
		this.goal = goal;
	}
	
	/*
	 * gets the start config by filling a waterjug array with jug objects
	 * @return an ArrayList of Jugs with capacities and amounts
	 */
	public ArrayList<Jug> getStart(){
		ArrayList<Jug> waterJugs = new ArrayList<Jug>();
		for(int i =0; i<jugs.size();i++){
			waterJugs.add(new Jug(jugs.get(i),0));
		}
		return waterJugs;
	}
	
	/*
	 * checks if any node inside of the given ArrayList is the goal
	 * @param nodes the nodes to check
	 * @return boolean if nodes contains the goal config
	 */
	public boolean getGoal(ArrayList<Jug> nodes){
		for(int i =0; i<nodes.size();i++){
			if(nodes.get(i).getAmount() == goal){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * deep copies the ArrayList
	 * @param  the ArrayList to copy
	 * @return a copied ArrayList of jugs
	 */
	public ArrayList<Jug> copy(ArrayList<Jug> jugs){
		ArrayList<Jug> newJugs = new ArrayList<Jug>();
		for(int i = 0; i<jugs.size();i++){
			newJugs.add(new Jug(jugs.get(i)));
		}
		return newJugs;
	}
	
	/*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
	public ArrayList<ArrayList<Jug>> getNeighbors(ArrayList<Jug> config) {
		ArrayList<ArrayList<Jug>> waterJugs = new ArrayList<ArrayList<Jug>>();
		for(int i = 0; i<config.size();i++){
			if(config.get(i).getAmount() == config.get(i).getCapacity()){
				continue;
			}
			ArrayList<Jug>newConfig = copy(config);
			newConfig.get(i).fillJug();
			waterJugs.add(newConfig);
		}	
		for(int j = 0; j<config.size();j++){
			if(config.get(j).getAmount() == 0){
				continue;
			}
			ArrayList<Jug>newConfig1 = copy(config);
			newConfig1.get(j).pourAllOut();
			waterJugs.add(newConfig1);
		}
		for(int k = 0; k<config.size();k++){
			for(int l = 0; l<config.size();l++){
				if(k == l){
					continue;
				}
				if(config.get(k).getAmount() == 0){
					continue;
				}
				if(config.get(l).getAmount() == config.get(l).getCapacity()){
					continue;
				}
				ArrayList<Jug>newConfig2 = copy(config);
				newConfig2.get(k).pourIntoOther(newConfig2.get(l));
				waterJugs.add(newConfig2);
			}	
		}
		return waterJugs;
	}
	
	
	
	/*
	 * print function, prints out an ArrayList
	 * @ param config an ArrayList of ArrayList of configs
	 */
	public static void print(ArrayList<ArrayList<Jug>> config){
        if (config == null){
            System.out.println("No solution.");
        }
		
        else{
	        for (int i = 1; i<config.size();i++){
	        	System.out.println();
	        	System.out.print("Step " + (i-1) + ":");
	        	for(int j = 0; j < config.get(i).size(); j++){
	        		System.out.print(" " + config.get(i).get(j));
	        	}
	        }
        }
    }
	
	
	/*
	 * gets the the jugs and their capacities and executes the program
	 */
	
	public static void main(String[] args) {
		try {
			goal = Integer.parseInt(args[0]);
	        ArrayList<Integer> jugs = new ArrayList<Integer>();

			for(int i = 1; i < args.length; i++){		
				jugs.add(Integer.parseInt(args[i]));
			}
			if(goal > Collections.max(jugs)){
	            System.out.println("No solution.");
			}
			else{
				Water water = new Water(goal,jugs);
				Solver<ArrayList<Jug>> solve = new Solver<ArrayList<Jug>>(water);
				water.getStart();
				ArrayList<ArrayList<Jug>> configs = solve.solve();
				print(configs);
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Usage: java Amount Jug1 Jug2...");
		}
		catch (NumberFormatException e) {
			System.err.println("Usage: java Amount Jug1 Jug2...");
		}
	}
}

