package products;

public class Pack implements Product {

	private int numOccurences;
	private Product product;

	public Pack(int occurences, Product prod) {
		this.numOccurences = occurences;
		this.product = prod;
	}

	@Override
	public double getPrice() {
		return numOccurences * product.getPrice();
	}
	
}
