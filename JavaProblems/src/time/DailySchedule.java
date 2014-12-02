package time;

import java.util.ArrayList;
import java.util.List;

public class DailySchedule {

	private List<Appointment> apptList;
	
	public DailySchedule() {
		this.apptList = new ArrayList<Appointment>();
	}
	
	public void clearConflicts(Appointment appt) {
		for(Appointment a : apptList) {
			if(a.getTime().overLapsWith(appt.getTime())) {
				apptList.remove(a);
			}
		}
	}
	
	public boolean addAppt(Appointment appt, boolean emergency) {
		if(emergency) {
			clearConflicts(appt);
			apptList.add(appt);
			return true;
		}
		else {
			for(Appointment a : apptList) {
				if(a.conflictsWith(appt)) {
					return false;
				}
			}
			apptList.add(appt);
			return true;
		}
	}
	
}
