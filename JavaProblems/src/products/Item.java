package products;

public class Item implements Product {

	private String itemDescription;
	private double unitPrice;
	
	public Item(String description, double price) {
		this.itemDescription = description;
		this.unitPrice = price;
	}
	
	@Override
	public double getPrice() {
		return unitPrice;
	}
	
	
	public void setPrice(double price) {
		this.unitPrice = price;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
}
