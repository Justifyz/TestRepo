package student;

import java.util.ArrayList;
import java.util.List;

public class StudentAnswerSheet {

	private List<String> answers;
	private String studentName;
	
	public StudentAnswerSheet(ArrayList<String> ans, String name) {
		this.answers = ans;
		this.studentName = name;
	}
	
	public double getScore(ArrayList<String> key) {
		double score = 0.0;
		for(int i = 0; i < key.size(); i++) {
			if(answers.get(i).equals("?")) {
				//Do nothing
			}
			else if(answers.get(i).equals(key.get(i))) {
				score += 1.0;
			}
			else {
				score -= 0.25;
			}
		}
		return score;
	}
	
	public String getName() {
		return studentName;
	}
	
}
