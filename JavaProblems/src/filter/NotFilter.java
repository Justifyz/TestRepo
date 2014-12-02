package filter;

public class NotFilter implements Filter {

	private Filter filter;
	
	public NotFilter(Filter f) {
		this.filter = f;
	}

	@Override
	public boolean accept(String text) {
		return !filter.accept(text);
	}
	
}
