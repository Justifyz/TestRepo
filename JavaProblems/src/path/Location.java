package path;

public class Location {

	private int row, col;
	
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
		return this.col == that.col && this.row == that.row;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")"; 
	}
	
}
