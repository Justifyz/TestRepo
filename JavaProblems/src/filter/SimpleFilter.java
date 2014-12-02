package filter;

public class SimpleFilter implements Filter {

	private String substr;
	
	public SimpleFilter(String s) {
		this.substr = s;
	}
	
	@Override
	public boolean accept(String text) {
		return text.contains(substr);
	}

}
