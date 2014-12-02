package fish;

public class PounceFish implements Fish {

	private int range;
	private FishGrid fishGrid;
	private Direction direction;
	
	public PounceFish(int r, FishGrid fg, Direction d) {
		this.range = r;
		this.fishGrid = fg;
		this.direction = d;
	}
	
	public enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	
	@Override
	public Fish findFish() {
		return fishGrid.getNearestPreyFor(this);
	}

	@Override
	public void act() {
		Fish prey = findFish();
		if(prey != null) {
			Location preyLoc = prey.location();
			prey.die();
		}
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public int getRange() {
		return range;
	}

	@Override
	public Location location() {
		return fishGrid.getLocation(this);
	}

	public void die() {	
		fishGrid.remove(this);
	}

}
