package items;

public class Vehicle extends TaxableItem {

	private double dealerCost, dealerMarkup;
	
	public Vehicle(double rate, double cost, double markup) {
		super(rate);
		this.dealerCost = cost;
		this.dealerMarkup = markup;
	}

	@Override
	public double getListPrice() {
		return dealerCost + dealerMarkup;
	}
	
	public void changeMarkup(double value) {
		this.dealerMarkup = value;
	}

}
