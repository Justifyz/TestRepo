package critter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Historian extends Critter {

	private Map<Location, Integer> places;
	
	public Historian() {
		super();
		places = new HashMap<Location, Integer>();
	}
	
	@Override
	public void makeMove(Location loc) {
		if(getLocation() == loc) {
			setLocation(loc);
			places.put(loc, places.get(loc)+1);
		}
		else {
			setLocation(null);
		}
	}
	
	public List<Location> mostPopularPlaces() {
		List<Location> list = new ArrayList<Location>();
		int max = 0;
		for(Location loc : places.keySet()) {
			int visits = places.get(loc);
			if(visits > max) {
				max = visits;
			}
		}
		for(Location loc : places.keySet()) {
			int visits = places.get(loc);
			if(visits == max) {
				list.add(loc);
			}
		}
		return list;
	}

}
