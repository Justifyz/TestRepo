package tokens;

public class StringTokenizerImpl {

	public static void main(String[] args) {
		StringTokenizerImpl sti = new StringTokenizerImpl();
		String acronym = sti.createAcronym("red orange yellow green blue indigo violet");
		System.out.println(acronym);
	}
	
	public String createAcronym(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < st.numberOfTokens(); i++) {
			char firstChar = st.getKthToken(i).charAt(0);
			sb.append(firstChar);
		}
		return sb.toString();
	}
	
}
