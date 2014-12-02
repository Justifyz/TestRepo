package voting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VoterBallots {

	private Map<String, Integer> voteCount;
	
	public VoterBallots(List<String> ballotList) {
		voteCount = new HashMap<String, Integer>();
		for(String candidate : ballotList) {
			if(voteCount.containsKey(candidate)) {
				int votes = voteCount.get(candidate);
				voteCount.put(candidate, votes+1);
			}
			else {
				voteCount.put(candidate, 1);
			}
		}
	}
	
	private Integer maxVotes() {
		int max = 0;
		for(String candidate : voteCount.keySet()) {
			int votes = voteCount.get(candidate);
			if(votes > max) {
				max = votes;
			}
		}
		return max;
	}
	
	public Set<String> candidatesWithMost() {
		Set<String> bestCandidates = new HashSet<String>();
		int mostVotes = maxVotes();
		for(String candidate : voteCount.keySet()) {
			int votes = voteCount.get(candidate);
			if(votes == mostVotes) {
				bestCandidates.add(candidate);
			}
		}
		return bestCandidates;
	}
	
}
