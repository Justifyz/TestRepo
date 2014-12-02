package filter;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {

	private List<Filter> list;
	
	public AndFilter(Filter f1, Filter f2) {
		list = new ArrayList<Filter>();
		list.add(f1);
		list.add(f2);
	}

	@Override
	public boolean accept(String text) {
		for(Filter f : list) {
			if(!f.accept(text)) {
				return false;
			}
		}
		return true;
	}
	
	public void add(Filter f) {
		list.add(f);
	}

}
