package ilovefish;

public class Environment {
	
	private Fish[][] grid;
	
	public Environment(Fish[][] g) {
		this.grid = g;
	}
	
	public int numRows() {
		return grid.length;
	}
	
	public int numCols() {
		return grid[0].length;
	}
	
	public int numObjects() {
		int count = 0;
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[0].length; c++) {
				if(grid[r][c] != null) {
					// cell is occupied 
					count++;
				}
			}
		}
		return count;
	}

	public boolean isEmpty(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		return grid[row][col] == null;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int r = 0; r < numRows(); r++) {
			for(int c = 0; c < numCols(); c++) {
				if(grid[r][c] == null) {
					sb.append("[NULL] ");
				}
				else {
					sb.append(grid[r][c].toString() + " ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void addFishToLoc(Location loc, Fish fish) {
		int row = loc.getRow();
		int col = loc.getCol();
		grid[row][col] = fish;
	}
	
	
}
