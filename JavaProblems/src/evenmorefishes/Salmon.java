package evenmorefishes;

public class  Salmon extends Fish {

	private Location homeLocation;
	private int age;
	private int matureAge;
	
	public Salmon(Environment env, Location loc, int maturityAge) {
		super(env, loc);
		this.age = 0;
		this.matureAge = maturityAge;
		this.homeLocation = loc;
	}
	
	
	public int distanceHome(Location loc) {
		return 0;
	}
	
	@Override
	protected Location nextLocation() {
		return null;
	}
	
	@Override
	public void act() {
		
	}
	
}
