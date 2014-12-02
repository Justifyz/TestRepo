package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AnagramGrouper {

	private HashMap<String, HashSet<String>> groups;
	
	public AnagramGrouper(List<String> words) {
		groups = new HashMap<String, HashSet<String>>();
	
		for(String word : words) {
			String key = createKeyString(word);
			if(groups.containsKey(key)) {
				groups.get(key).add(word);
			}
			else {
				HashSet<String> list = new HashSet<String>();
				list.add(word);
				groups.put(key, list);
			}
		}
	}
	
	public HashSet<HashSet<String>> findLargestSets() {
		int max = 0;
		for(HashSet<String> hs : groups.values()) {
			if(hs.size() > max) {
				max = hs.size();
			}
		}
		HashSet<HashSet<String>> solution = new HashSet<HashSet<String>>();
		for(HashSet<String> hs : groups.values()) {
			if(hs.size() == max) {
				solution.add(hs);
			}
		}
		return solution;
	}
	
	public String createKeyString(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
}
