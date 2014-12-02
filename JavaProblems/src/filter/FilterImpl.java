package filter;

public class FilterImpl {

	public static void main(String[] args) {
		String[] primary = {"red", "blue", "yellow"};
		Filter primaryColors = buildFilter(primary, "green");
		System.out.println(primaryColors.accept("Roses are red, violets are blue"));
		System.out.println(primaryColors.accept("blue grass is really green"));
		System.out.println(primaryColors.accept("The rainbow has many colors"));
	}
	
	public static Filter buildFilter(String[] desirable, String notAllowed) {
		OrFilter orFilter = new OrFilter(new SimpleFilter(desirable[0]), new SimpleFilter(desirable[1]));
		for(int i = 2; i < desirable.length; i++) {
			orFilter.add(new SimpleFilter(desirable[i]));
		}
		NotFilter notFilter = new NotFilter(new SimpleFilter(notAllowed));
		return new AndFilter(orFilter, notFilter);
	}

}
