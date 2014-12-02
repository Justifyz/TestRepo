package ticket;

public class Advance extends Ticket {

	private int days;
	
	public Advance(int numDays) {
		this.days = numDays;
	}
	
	@Override
	public double getPrice() {
		if(days >= 10) {
			return 30.0;
		}
		return 40.0;
	}

}
