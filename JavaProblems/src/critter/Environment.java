package critter;

public class Environment {

	private  Critter[][] grid;
	
	public Environment() {
		this.grid = new Critter[10][10];
	}
	
	public  int getRows() {
		return grid.length;
	}
	
	public  int getCols() {
		return grid[0].length;
	}
	
	public void remove(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		grid[row][col] = null;
	}
	
}
