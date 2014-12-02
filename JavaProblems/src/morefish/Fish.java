package morefish;

import morefish.Environment.Direction;

public abstract class Fish {

	protected Environment env;
	protected Location loc;
	
	public Fish(Environment env, Location loc) {
		this.env = env;
		this.loc = loc;
	}
	
	protected abstract Location nextLocation();
	protected abstract void move();
	
	protected Location location() {
		return loc;
	}
	
	@SuppressWarnings("static-access")
	protected Direction direction() {
		return env.getDirection();
	}
	
	protected void changeLocation(Location nextLoc) {
		this.loc = nextLoc;
	}
	
	protected void changeDirection(Direction dir) {
		env.setDirection(dir);
	}
	
}
