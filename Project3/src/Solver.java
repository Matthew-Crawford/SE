import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Solver<E> {

	private Puzzle<E> p;
	
	private HashMap<E,E> map;
	 
	public Solver(Puzzle<E> puzzle){
		this.p = puzzle;
	}
	
	/*
	 * builds an arraylist representing the path from an arraylist
	 * @param  map the hash map being traversed 
	 * @oaram goal the goal config
	 * @return an ArrayList<E> representing the path
	 */
    
    private ArrayList<E> buildPath(HashMap<E,E> map, E goal){
    	ArrayList<E> path = new ArrayList<E>();
    	E current = goal;
    	while(map.get(current) != (current)){
    		path.add(0, current);
    		current = map.get(current);
    	}
    	path.add(0,current);
    	return path;
    }
    
    
    
    /*
   	 * A Breadth First Search implementation using a 2D ArrayList as a queue
   	 * @return an ArrayList of steps it takes to get from start to goal
   	 */
    
    public ArrayList<E> solve(){
    		E start = p.getStart();
    		ArrayList<E> path = null;
    		boolean found = p.getGoal(start);
        	map = new HashMap<E,E>();
        	LinkedList<E> queue = new LinkedList<E>();
        	map.put(start, start);
        	queue.add (start);
        	E current = queue.get(0);
        	while(!queue.isEmpty() && !found){
        		current = queue.remove(0);;
        		for(E neighbor : p.getNeighbors(current)){
        			if (p.getGoal(neighbor)){
        				map.put(neighbor,current);;
        				found = true;
        				path =  buildPath(map, neighbor);
        				break;
        			}
        			else if(!map.containsKey(neighbor)){
        			    map.put(neighbor,current);
        			    queue.add(neighbor);
        			}
        		}	
        	}
        	if(found){
        		return path;
        	}
 
        return null;
		}	
}


