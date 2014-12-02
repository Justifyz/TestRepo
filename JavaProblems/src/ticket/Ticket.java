package ticket;

public abstract class Ticket {
	
	private static int serialNumber = 1;
	
	public Ticket() {
		Ticket.serialNumber = getNextSerialNumber();
	}
	
	public abstract double getPrice();
	
	public String toString() {
		return "Number: " + serialNumber + "\nPrice: " + getPrice();
	}
	
	private static int getNextSerialNumber() {
		return serialNumber++;
	}
	
}
