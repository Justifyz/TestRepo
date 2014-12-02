package somemorefishes;

import somemorefishes.Fish.Direction;

public class Environment {

	private Object[][] grid;
	
	public Environment(Object[][] g) {
		this.grid = g;
	}

	public boolean remove(Object obj) {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[0].length; c++) {
				if(grid[r][c].equals(obj)) {
					grid[r][c] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	public int getRowLength() {
		return grid.length;
	}
	
	public int getColLength() {
		return grid[0].length;
	}
	

	public Location getNeighbor(Location loc, Direction dir) {
		int row = loc.getRow();
		int col = loc.getCol();
		if(dir == Direction.NORTH) {
			return new Location(row-1, col);
		}
		if(dir == Direction.EAST) {
			return new Location(row, col+1);
		}
		if(dir == Direction.SOUTH) {
			return new Location(row+1, col);
		}
		// location must be west at this point
		return new Location(row, col-1);
	}

	public Fish objectAt(Location inFront) {
		int row = inFront.getRow();
		int col = inFront.getCol();
		if(row < grid.length && row >= 0 && col < grid[0].length && col >= 0) {
			if(grid[row][col] instanceof Fish) {
				return (Fish)grid[row][col];
			}
		}
		return null;
	}
	
}
