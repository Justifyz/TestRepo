package game;

public class Player {

	private String name;
	
	public Player(String aName) {
		this.name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNextMove(GameState state) {
		return "";
	}
	
	
}
