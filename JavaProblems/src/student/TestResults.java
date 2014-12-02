package student;

import java.util.ArrayList;
import java.util.List;

public class TestResults {

	private List<StudentAnswerSheet> sheets;
	
	public TestResults(ArrayList<StudentAnswerSheet> sheets) {
		this.sheets = sheets;
	}
	
	public String highestScoringStudent(ArrayList<String> key) {
		StudentAnswerSheet best = sheets.get(0);
		for(StudentAnswerSheet s : sheets) {
			if(best.getScore(key) < s.getScore(key)) {
				best = s;
			}
		}
		return best.getName();
	}
	
}
