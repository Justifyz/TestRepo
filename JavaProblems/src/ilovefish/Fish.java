package ilovefish;

public class Fish {
	private Direction direction;
	private Colors color;
	
	public Fish(Direction dir, Colors col) {
		this.direction = dir;
		this.color = col;
	}
	
	public enum Direction {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	public enum Colors {
		RED,
		ORANGE,
		YELLOW,
		GREEN,
		BLUE,
		PURPLE,
		BROWN,
		BLACK,
		WHITE
	}
	
	public Colors getColor() {
		return color;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	@Override
	public String toString() {
		return "[" + this.color.toString() + " " + this.direction.toString() + " FISH]"; 
	}
	
}
