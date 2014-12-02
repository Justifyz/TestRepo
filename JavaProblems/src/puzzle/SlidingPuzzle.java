package puzzle;

import java.util.ArrayList;
import java.util.HashMap;

public class SlidingPuzzle {

	private int side;
	private int[][] values;
	
	public SlidingPuzzle(int sideLength) {
		this.side = sideLength;
		this.values = new int[sideLength][sideLength];
		initialize();
	}
	
	public boolean isDone() {
		int num1 = values[0][0];
		for(int r = 0; r < values.length; r++) {
			for(int c = 0; c < values[0].length; c++) {
				int num2 = values[r][c];
				if(num2 != 0) {
					if(num2 < num1) {
						return false;
					}
					num1 = num2;
				}
			}
		}
		return true;
	}
	
	public void initialize() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int j = 0; j < side * side; j++) {
			temp.add(new Integer(j));
			map.put(new Integer(j), false);
		}
		int num;
		for(int r = 0; r < values.length; r++) {
			for(int c = 0; c < values[0].length; c++) {
				do {
					num = (int)(Math.random()*side*side);
					if(map.get(num) == false) {
						map.put(num, true);
						values[r][c] = num;
					}
				} while(!map.get(num)); 
			}
		}
	}
	
	
}
