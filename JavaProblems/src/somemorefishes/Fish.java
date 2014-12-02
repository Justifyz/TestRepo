package somemorefishes;

public class Fish {
	private Environment theEnv;
	private Location loc;
	private Direction dir;
	
	public enum Direction {
		NORTH,
		SOUTH,
		EAST,
		WEST	
	}
	
	public Fish(Environment env, Location location, Direction dir) {
		this.theEnv = env;
		this.loc = location;
		this.dir = dir;
	}
	
	public void act() {
		if(dir == Direction.NORTH && loc.getRow() == 0) {
			while(dir != Direction.NORTH) {
				changeDirection();
			}
		}
		else if(dir == Direction.EAST && loc.getCol() == theEnv.getColLength()-1) {
			while(dir != Direction.EAST) {
				changeDirection();
			}
		}
		else if(dir == Direction.SOUTH && loc.getRow() == theEnv.getRowLength()-1) {
			while(dir != Direction.SOUTH) {
				changeDirection();
			}
		}
		else if(dir == Direction.WEST && loc.getCol() == 0) {
			while(dir != Direction.WEST) {
				changeDirection();
			}
		}
		else {
			move();
		}
	}
	
	private void move() {
		if(dir == Direction.NORTH) {
			loc = new Location(loc.getRow()-1, loc.getCol());
		}
		else if(dir == Direction.EAST) {
			loc = new Location(loc.getRow(), loc.getCol()+1);
		}
		else if(dir == Direction.SOUTH) {
			loc = new Location(loc.getRow()+1, loc.getCol());
		}
		else {
			// must be west by this point
			loc = new Location(loc.getRow(), loc.getCol()-1);
		}
	}

	private void changeDirection() {
		int num = (int)(Math.random() * 4);
		if(num == 0) {
			dir = Direction.NORTH;
		}
		else if(num == 1) {
			dir = Direction.EAST;
		}
		else if(num == 2) {
			dir = Direction.SOUTH;
		}
		else {
			// must be 3 by this point
			dir = Direction.WEST;
		}
	}

	protected void die() {
		theEnv.remove(this);
	}
	
	protected Direction direction() {
		return dir;
	}
	
	protected Location location() {
		return loc;
	}
	
	protected Environment environment() {
		return theEnv;
	}
	
	protected boolean isInEnv() {
		int row = loc.getRow();
		int col = loc.getCol();
		return row < theEnv.getRowLength() && col < theEnv.getColLength();
	}
		
}
