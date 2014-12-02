package postal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PostalCodeDB {

	private Map<String, Set<String>> codeToCityMap;
	private Map<String, Set<String>> cityToCodeMap;
	
	public PostalCodeDB() {
		codeToCityMap = new HashMap<String, Set<String>>();
		cityToCodeMap = new HashMap<String, Set<String>>();
	}
	
	public Set<String> getCitiesForCode(String code) {
		return codeToCityMap.get(code);
	}
	
	public void addCityCodePair(String code, String city) {
		if(codeToCityMap.containsKey(code)) {
			codeToCityMap.get(code).add(city);
		}
		else {
			Set<String> citySet = new HashSet<String>();
			citySet.add(city);
			codeToCityMap.put(code, citySet);
		}
	}
	
	public void addCodeCityPair(String city, String code) {
		if(cityToCodeMap.containsKey(city)) {
			cityToCodeMap.get(city).add(code);
		}
		else {
			Set<String> codeSet = new HashSet<String>();
			codeSet.add(code);
			cityToCodeMap.put(city, codeSet);
		}
	}
	
	public Set<String> getCodesForCity(String city) {
		return cityToCodeMap.get(city);
	}
	
	public void printAllCities() {
		ArrayList<String> cities = new ArrayList<String>();
		for(String city : cityToCodeMap.keySet()) {
			cities.add(city);
		}
		String[] citiesArray = (String[]) cities.toArray();
		Arrays.sort(citiesArray);
		for(int i = 0; i < citiesArray.length; i++) {
			System.out.println(citiesArray[i]);
		}
	}
	
}
