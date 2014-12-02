package somemorefishes;

public class PredatorFish extends Fish {

	private int daysSinceLastMeal;
	
	public PredatorFish(Environment env, Location location, Direction dir) {
		super(env, location, dir);
		this.daysSinceLastMeal = 0;
	}

	
	public boolean eat() {
		Environment env = environment();
		Location inFront = env.getNeighbor(location(), direction());
		
		Fish fish = (Fish)env.objectAt(inFront);
		if(fish != null) {
			fish.die();
			return true;
		}
		return false;
	}
	
	
	@Override
	public void act() {
		if(!isInEnv()) {
			return;
		}
		if(eat()) {
			daysSinceLastMeal = 0;
		}
		else {
			daysSinceLastMeal++;
		}
		if(daysSinceLastMeal >= 5) {
			die();
		}
		else {
			super.act();
		}
	}

}
