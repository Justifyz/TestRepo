package filter;

import java.util.ArrayList;
import java.util.List;

public class OrFilter implements Filter {

	private List<Filter> list;
	
	public OrFilter(Filter f1, Filter f2) {
		list = new ArrayList<Filter>();
		list.add(f1);
		list.add(f2);
	}

	@Override
	public boolean accept(String text) {
		for(Filter f : list) {
			if(f.accept(text)) {
				return true;
			}
		}
		return false;
	}
	
	public void add(Filter f) {
		list.add(f);
	}

}
