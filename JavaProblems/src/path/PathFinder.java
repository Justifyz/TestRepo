package path;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import path.Environment.Direction;


public class PathFinder {

	private Environment theEnv;
	
	public PathFinder(Environment env) {
		this.theEnv = env;
	}
	
	public boolean possibleEnds(Location start, Location end) {
		return theEnv.isEmpty(start) && theEnv.isEmpty(end)
				&& start.getCol() <= end.getCol() && start.getRow() >= end.getRow();
	}
	
	public List<Location> findNEPath(Location start, Location end) {
		if(!possibleEnds(start, end)) {
			return null;
		}
		List<Location> path;
		if(start.equals(end)) {
			path = new LinkedList<Location>();
			path.add(end);
			return path;
		}
		path = findNEPath(theEnv.getNeighbor(start, Direction.NORTH), end);
		if(path == null) {
			path = findNEPath(theEnv.getNeighbor(start, Direction.EAST), end);
		}
		if(path != null) {
			path.add(0, start);
		}
		return path;	
	}
	
	public static void main(String[] args) {
		Obstacle[][] obs = new Obstacle[6][6];
		obs[4][1] = new Obstacle();
		obs[5][3] = new Obstacle();
		obs[2][3] = new Obstacle();
		obs[1][4] = new Obstacle();
		Environment env = new Environment(obs);
		PathFinder pf = new PathFinder(env);
		Location start = new Location(5,1);
		Location end = new Location(2,4);
		List<Location> path = pf.findNEPath(start, end);
		pf.printPath(path);
	}
	
	public void printPath(List<Location> path) {
		if(path == null) {
			System.out.println("No path exists.");
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i = 0; i < path.size(); i++) {
				Location loc = path.get(i);
				if(loc != null) {
					sb.append(loc);
				}
				if(i < path.size()-1) {
					sb.append(", ");
				}
			}
			sb.append("]");
			System.out.print(sb.toString());	
		}
	}
	
	
}
