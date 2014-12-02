package critter;


public class Location {
	private int row, col;
	
	
	// random location if created with no parameters
	public Location() {
		this.row = (int)(Math.random() * 10);
		this.col = (int)(Math.random() * 10);
	}
	
	public Location(int r, int c) {
		this.row = r;
		this.col = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Location)) {
			return false;
		}
		if(this == o) {
			return true;
		}
		
		Location that = (Location)o;
		return that.row == this.row && that.col == this.col;
	}
}
