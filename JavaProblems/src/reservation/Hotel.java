package reservation;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private Reservation[] rooms;	
	private List<String> waitList;
	
	public Hotel(Reservation[] aRooms, ArrayList<String> aList) {
		this.rooms = aRooms;
		this.waitList = aList;
	}
	
	public Reservation requestRoom(String guestName) {
		for(int room = 0; room < rooms.length; room++) {
			if(rooms[room] == null) {
				Reservation newReservation = new Reservation(guestName, room);
				rooms[room] = newReservation;
				return newReservation;
			}
		}
		waitList.add(guestName);
		return null;
	}
	
	public Reservation cancelAndReassign(Reservation res) {
		int roomNumber = res.getRoomNumber();
		if(waitList.isEmpty()) {
			rooms[roomNumber] = null;
			return null;
		}
		String guestName = waitList.remove(0);
		Reservation newReservation = new Reservation(guestName,roomNumber);
		rooms[roomNumber] = newReservation;
		return newReservation;
	}
	
}
