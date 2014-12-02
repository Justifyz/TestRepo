package tokens;

public class StringTokenizer {
	private String[] tokens;
	
	public StringTokenizer(String s) {
		tokens = s.trim().split("\\s+");
	}
	
	public int numberOfTokens() {
		return tokens.length;
	}
	
	public String getKthToken(int k) {
		return tokens[k];
	}

	public String[] getTokens() {
		return tokens;
	}
	
}
