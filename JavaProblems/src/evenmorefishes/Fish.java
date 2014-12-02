package evenmorefishes;

public abstract class Fish {

	private Environment theEnv;
	private Location loc;
	
	public Fish(Environment env, Location loc) {
		this.theEnv = env;
		this.loc = loc;
	}
	
	public abstract void act();
	protected abstract Location nextLocation();
	
}
