package morefish;

import morefish.Environment.Direction;

@SuppressWarnings("unused")
public class Environment {
	
	private Fish[][] grid;
	private static Direction direction;
	
	@SuppressWarnings("static-access")
	public Environment(Fish[][] g, Direction d) {
		this.grid = g;
		this.direction = d;
	}
	
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT;

		public Direction reverse() {
			// TODO Auto-generated method stub
			if(getDirection() == Direction.RIGHT) {
				return Direction.LEFT;
			}
			return Direction.RIGHT;
		}

		public Direction toRight() {
			// TODO Auto-generated method stub
			return Direction.UP;
		}

		public Direction toLeft() {
			// TODO Auto-generated method stub
			return Direction.DOWN;
		}
	}
	
	public Location getNeighbor(Location loc, Direction dir) {
		int row = loc.getRow();
		int col = loc.getCol();
		if(dir == Direction.RIGHT) {
			if(row >= grid.length || col >= grid[0].length || grid[row][col] != null) {
				return loc;
			}
			return new Location(row, col+1);
		}
		if(dir == Direction.LEFT) {
			if(row < 0 || col < 0 || grid[row][col] != null) {
				return loc;
			}
			return new Location(row, col-1);
		}
		if(dir == Direction.UP) {
			return new Location(row-1, col);
		}
		if(dir == Direction.DOWN) {
			return new Location(row+1, col);
		}
		return loc;
	}
	
	public static Direction getDirection() {
		return direction;
	}

	public boolean isEmpty(Location nextLoc) {
		int row = nextLoc.getRow();
		int col = nextLoc.getCol();
		return grid[row][col] == null;
	}
	
	@SuppressWarnings("static-access")
	public void setDirection(Direction dir) {
		this.direction = dir;
	}
	
}
