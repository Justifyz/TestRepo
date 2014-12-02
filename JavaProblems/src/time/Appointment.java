package time;

public class Appointment {

	private TimeInterval interval;
	
	public Appointment(TimeInterval aInterval) {
		this.interval = aInterval;
	}
	
	public TimeInterval getTime() {
		return interval;
	}
	
	public boolean conflictsWith(Appointment other) {
		return getTime().overLapsWith(other.getTime());
	}
	
}
