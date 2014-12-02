package robot;

public class Robot {

	private int[] hall;
	private int pos;
	private boolean facingRight;
	
	public Robot(int[] hall, int pos, boolean facingRight) {
		this.hall = hall;
		this.pos = pos;
		this.facingRight = facingRight;
	}
	
	private boolean forwardMoveBlocked() {
		return (facingRight && pos == hall.length-1) ||
				(!facingRight && pos == 0);
	}
	
	private void move() {
		if(hall[pos] > 0) {
			hall[pos]--;
		}
		if(hall[pos] > 0) {
			// do nothing
		}
		else {
			if(!forwardMoveBlocked()) {
				if(facingRight) {
					pos++;
				}
				else {
					pos--;
				}
			}
			else {
				facingRight = !facingRight;
			}
		}
	}
	
	public boolean hallIsClear() {
		for(int i = 0; i < hall.length; i++) {
			if(hall[i] > 0) {
				return false;
			}
		}
		return true;
	}
	
	public int clearHall() {
		int moves = 0;
		while(!hallIsClear()) {
			move();
			moves++;
		}
		return moves;
	}
	
}
