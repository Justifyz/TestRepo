package time;

import java.util.Date;

public class TimeInterval {
	
	Date startDate;
	Date endDate;
	
	public TimeInterval(Date sDate, Date eDate) {
		this.startDate = sDate;
		this.endDate = eDate;
	}

	public boolean overLapsWith(TimeInterval interval) {
		if(endDate.after(interval.startDate)) {
			return true;
		}
		return false;
	}
}
