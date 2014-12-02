package ticket;

public class StudentAdvance extends Advance {

	public StudentAdvance(int numDays) {
		super(numDays);
	}

	@Override
	public double getPrice() {
		return super.getPrice()/2;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nStudent ID required";
	}
	
}
