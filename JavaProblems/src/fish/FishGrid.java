package fish;

import fish.PounceFish.Direction;

public class FishGrid {

	private Fish[][] fishGridDiagram;
	
	public FishGrid(Fish[][] fg) {
		this.fishGridDiagram = fg;
	}
	
	public Location getLocation(Fish fish) {
		for(int r = 0; r < fishGridDiagram.length; r++) {
			for(int c = 0; c < fishGridDiagram[0].length; c++) {
				if(fishGridDiagram[r][c].equals(fish)) {
					return new Location(r, c);
				}
			}
		}
		return null;
	}
	
	public Fish getNearestPreyFor(PounceFish fish) {
		Location loc = getLocation(fish);
		int startingRange = 1;
		if(fish.getDirection() == Direction.NORTH) {
			int startingRow = loc.getRow() - 1;
			int col = loc.getCol();
			while(startingRow >= 0 && startingRange <= fish.getRange()) {
				Fish prey = fishGridDiagram[startingRow][col];
				if(prey != null) {
					return prey;
				}
				startingRow--;
				startingRange++;
			}
			return null;
		}
		else if(fish.getDirection() == Direction.EAST) {
			int startingCol = loc.getCol() + 1;
			int row = loc.getRow();
			while(startingCol < fishGridDiagram[0].length && startingRange <= fish.getRange()) {
				Fish prey = fishGridDiagram[row][startingCol];
				if(prey != null) {
					return prey;
				}
				startingCol++;
				startingRange++;
			}
			return null;
		}
		else if(fish.getDirection() == Direction.SOUTH) {
			int startingRow = loc.getRow() + 1;
			int col = loc.getCol();
			while(startingRow < fishGridDiagram.length && startingRange <= fish.getRange()) {
				Fish prey = fishGridDiagram[startingRow][col];
				if(prey != null) {
					return prey;
				}
				startingRow++;
				startingRange++;
			}
			return null;
		}
		else if(fish.getDirection() == Direction.WEST) {
			int startingCol = loc.getCol() - 1;
			int row = loc.getRow();
			while(startingCol >= 0 && startingRange <= fish.getRange()) {
				Fish prey = fishGridDiagram[row][startingCol];
				if(prey != null) {
					return prey;
				}
				startingCol--;
				startingRange++;
			}
			return null;
		}
		return null;
	}
	
	public void remove(Fish fish) {
		Location loc = fish.location();
		fishGridDiagram[loc.getRow()][loc.getCol()] = null;
	}
	
}
