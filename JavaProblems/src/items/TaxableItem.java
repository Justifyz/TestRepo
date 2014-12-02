package items;

public abstract class TaxableItem implements Item {

	private double taxRate;
	
	public abstract double getListPrice();
	
	public TaxableItem(double rate) {
		this.taxRate = rate;
	}
	
	public double purchasePrice() {
		return getListPrice() + getListPrice() * taxRate;
	}
	
}
