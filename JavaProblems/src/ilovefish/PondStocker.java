package ilovefish;


import ilovefish.Fish.Colors;
import ilovefish.Fish.Direction;

import java.awt.Color;
import java.util.Random;

import javax.swing.JTextArea;

public class PondStocker {

	private Environment theEnv;
	private double minDensity;
	
	public PondStocker(Environment e, double density) {
		this.theEnv = e;
		this.minDensity = density;
	}
	
	public int numUnder() {
		int current = theEnv.numObjects();
		int cells = theEnv.numRows() * theEnv.numCols();
		
		int needed = 0;
		while( (double)(current+needed) / cells <= minDensity) {
			needed++;
		}
		return needed;
	}
	
	public Location randomLocation() {
		Random gen = new Random();
		int rows = theEnv.numRows();
		int cols = theEnv.numCols();
		return new Location(gen.nextInt(rows), gen.nextInt(cols));
	}
	
	public void addFish(int numToAdd) {
		while(numToAdd > 0) {
			Location loc = randomLocation();
			if(theEnv.isEmpty(loc)) {
				theEnv.addFishToLoc(loc, new Fish(randomDirection(), randomColor()));
				numToAdd--;
			}
		}
	}

	private static Colors randomColor() {
		int num = (int) (Math.random() * 10);
		if(num == 0) return Colors.RED;
		if(num == 1) return Colors.ORANGE;
		if(num == 2) return Colors.YELLOW;
		if(num == 3) return Colors.GREEN;
		if(num == 4) return Colors.BLUE;
		if(num == 5) return Colors.PURPLE;
		if(num == 6) return Colors.BROWN;
		if(num == 7) return Colors.BLACK;
		return Colors.WHITE;
	}

	private static Direction randomDirection() {
		int num = (int) (Math.random()*4);
		if(num == 0) return Direction.UP;
		if(num == 1) return Direction.DOWN;
		if(num == 2) return Direction.LEFT;
		return Direction.RIGHT;
	}
	
	public static void main(String[] args) {
		Fish[][] grid = new Fish[10][10];
		grid[0][5] = new Fish(randomDirection(), randomColor());
		grid[4][7] = new Fish(randomDirection(), randomColor());
		grid[8][3] = new Fish(randomDirection(), randomColor());
		grid[5][5] = new Fish(randomDirection(), randomColor());
		
		Environment env = new Environment(grid); 
		PondStocker ps = new PondStocker(env, 0.5);
		System.out.println("::::::::::BEFORE ADDING FISH::::::::::");
		System.out.println();
		ps.printPond();
		System.out.println();
		ps.addFish(ps.numUnder());
		System.out.println("::::::::::AFTER ADDING FISH::::::::::");
		System.out.println();
		ps.printPond();
		System.out.println();
		
		
	}
	
	public void printPond() {
		System.out.println(theEnv.toString());		
	}
	
}