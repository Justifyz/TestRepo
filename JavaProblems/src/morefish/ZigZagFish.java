package morefish;

public class ZigZagFish extends Fish {

	private boolean willZigRight;
	
	public ZigZagFish(Environment env, Location loc) {
		super(env, loc);
		willZigRight = true;	
	}

	@Override
	protected Location nextLocation() {
		Location nextLoc = env.getNeighbor(location(), direction());
		if(willZigRight) {
			nextLoc = env.getNeighbor(nextLoc, direction().toRight());
		}
		else {
			nextLoc = env.getNeighbor(nextLoc, direction().toLeft());
		}
		if(env.isEmpty(nextLoc)) {
			return nextLoc;
		}
		return location();
	}

	@Override
	protected void move() {
		Location nextLoc = nextLocation();
		
		if(!nextLoc.equals(location())) {
			changeLocation(nextLoc);
			willZigRight = !willZigRight;
		}
		else {
			changeDirection(direction().reverse());
		}	
	}
	
}
