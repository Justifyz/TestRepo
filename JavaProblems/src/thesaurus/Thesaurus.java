package thesaurus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Thesaurus {

	private Map<String, Set<String>> wordMap;
	
	public Thesaurus() {
		wordMap = new HashMap<String, Set<String>>();
	}
	
	public void addSynonym(String word, String syn) {
		if(wordMap.containsKey(word)) {
			wordMap.get(word).add(syn);
		}
		else {
			Set<String> set = new HashSet<String>();
			set.add(syn);
			wordMap.put(word, set);
		}
	}
	
	public Set<String> removeSynonym(String syn) {
		Set<String> solution = new HashSet<String>();
		for(String s : wordMap.keySet()) {
			if(wordMap.get(s).contains(syn)) {
				wordMap.get(s).remove(syn);
				solution.add(s);
			}
		}
		return solution;
	}
	
}
