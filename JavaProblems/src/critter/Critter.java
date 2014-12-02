package critter;

public abstract class Critter {
	private Location loc;
	private Environment env;
	
	public Critter() {
		this.env = new Environment();
		this.loc = new Location();
	}
	
	public abstract void makeMove(Location loc);
	
	public Environment getEnv() {
		return env;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
}
