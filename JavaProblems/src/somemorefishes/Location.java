package somemorefishes;

public class Location {

	private int row;
	private int col;
	
	public Location(int r, int c) {
		this.row = r;
		this.col = c;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
}
