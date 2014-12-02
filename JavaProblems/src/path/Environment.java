package path;

public class Environment {

	private Obstacle[][] grid;
	
	public Environment(Obstacle[][] o) {
		this.grid = o;
	}
	
	public enum Direction {
		NORTH,	
		EAST
	}
	
	public boolean isEmpty(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		return grid[row][col] == null;
	}

	public Location getNeighbor(Location loc, Direction dir) {
		Location newLoc;
		if(dir == Direction.NORTH) {
			newLoc = new Location(loc.getRow()-1, loc.getCol());
		}
		else {
			// must be east at this point
			newLoc = new Location(loc.getRow(), loc.getCol()+1);
		}
		return newLoc;
	}
}
