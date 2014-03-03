/*
 * Puzzle.java
 *
 * Version:
 * $Id: Puzzle.java,v 1.3 2013/04/30 03:59:04 mjc5454 Exp $
 *
 * Revisions:
 * $Log: Puzzle.java,v $
 * Revision 1.3  2013/04/30 03:59:04  mjc5454
 * added new bfs
 *
 * Revision 1.12  2013/04/30 00:19:25  p243-07t
 * Fixed memoization in the bfs
 *
 * Revision 1.11  2013/04/18 19:07:41  p243-07t
 * printing corrected
 *
 * Revision 1.10  2013/04/18 17:25:39  p243-07t
 * running program
 *
 * Revision 1.9  2013/04/18 16:33:07  p243-07t
 * fixed bfs
 *
 * Revision 1.8  2013/04/17 22:44:39  p243-07t
 * Commented
 *
 * Revision 1.7  2013/04/17 22:25:27  p243-07t
 * BFS map needs work
 *
 * Revision 1.6  2013/04/16 22:48:16  p243-07t
 * Made BFS generic
 *
 *
 *@author Matthew Crawford, Zack Richardson
 */


import java.util.*;



/*
 * An abstract to a Puzzle. It contains the routines necessary for accessing the start and goal configs, 
 * as well as generating new neighboring configs.
 * 
 * @author Zack Richardson
 * @author Matthew Crawford
 */
public abstract class Puzzle<E> {
	/*
	 * Get the starting config for this puzzle.
	 * @return the starting config
	 */
    public abstract E getStart();
	
	/*
	 * Get the goal config for this puzzle.
	 * @return the goal config
	 */
    public abstract boolean getGoal(E node);
	
	/*
	 * For an incoming config, generate and return all direct neighbors to this config.
	 * @param config - the incoming config
	 * @return the collection of neighbor configs
	 */
    public abstract ArrayList<E> getNeighbors(E config);
    
}
    
   


