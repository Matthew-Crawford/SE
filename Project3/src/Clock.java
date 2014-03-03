/*
 * Puzzle.java
 *
 * Version:
 * $Id: Clock.java,v 1.1 2013/04/30 03:59:04 mjc5454 Exp $
 *
 * Revisions:
 * $Log: Clock.java,v $
 * Revision 1.1  2013/04/30 03:59:04  mjc5454
 * added new bfs
 *
 * Revision 1.8  2013/04/30 00:19:25  p243-07t
 * Fixed memoization in the bfs
 *
 * Revision 1.7  2013/04/18 19:07:39  p243-07t
 * printing corrected
 *
 * Revision 1.6  2013/04/18 16:33:07  p243-07t
 * fixed bfs
 *
 * Revision 1.5  2013/04/17 22:25:26  p243-07t
 * BFS map needs work
 *
 * Revision 1.4  2013/04/16 22:48:15  p243-07t
 * Made BFS generic
 *
 *
 *@author Matthew Crawford
 *@author Zack Richardson
 */

import java.util.*;

/*
 * A clock puzzle that finds the quickest way to go from a start number to an end number 
 * @author Matthew Crawford
 */
public class Clock extends Puzzle<Integer> {

    private static Integer start;
    private static Integer end;
    /**hours- Total number of hours*/
    private static int hours;
	
    /*
	 * Get the starting config for this puzzle.
	 * @return the starting config
	 */
    
    public Integer getStart(){
        return start;
    }
    
    /*
	 * Get the goal config for this puzzle.
	 * @return the goal config
	 */

    public boolean getGoal(Integer node){
	    return end.equals(node);
    }
    
    public Integer getGoal(){
    	return end;
    }
	
    /*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
    
    
    public ArrayList<Integer> getNeighbors(Integer config){
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        if (hours < start || hours < end){
            return neighbors;
            }
        else{
            if (config == hours){
            neighbors.add(config-1);
            neighbors.add(1);
            }
            
            else if (config == 1){
                neighbors.add(hours);
                neighbors.add(config+1);
            }
		
            else{
                neighbors.add(config-1);
                neighbors.add(config+1);
            }
        }
        return neighbors;
    }
    
    
    /*
     *Prints the answer to the clock puzzle.  
     */
    
    public static void print(ArrayList<Integer> config){
        if (config == null){
            System.out.println("No solution.");
        }
		
        else{
        for (int i = 0; i<config.size();i++){
            System.out.println("Step " + i + ": " + config.get(i));
            }
        }
    }
    
    /*
     * Gets hours, start and end from arguments in the command line and executes the program
     */
    
    public static void main(String[] args) {
        Puzzle<Integer> clock = new Clock();
        if(args.length < 3){
            System.out.print("Usage: java Clock hours start goal");
            System.exit(0);
        }
        else{
            hours = Integer.parseInt(args[0]);
            start = Integer.parseInt(args[1]);
            end = Integer.parseInt(args[2]);
            Solver<Integer> solver = new Solver<Integer>(clock);
            ArrayList<Integer> config = solver.solve();
            print(config);
		
        }

    }

}
