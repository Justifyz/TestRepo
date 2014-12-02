package products;


import java.util.ArrayList;
import java.util.List;



public class Bundle implements Product {

	private List<Product> bundle;
	
	public Bundle() {
		bundle = new ArrayList<Product>();
	}
	
	@Override
	public double getPrice() {
		double total = 0.0;
		for(Product p : bundle) {
			total += p.getPrice();
		}
		return total;
	}
	
	public void add(Product p) {
		bundle.add(p);
	}

}
