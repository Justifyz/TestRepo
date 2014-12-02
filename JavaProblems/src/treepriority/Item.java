package treepriority;

public class Item {

	private Comparable<Object> data;
	private int count;
	
	public Item(Comparable<Object> d) {
		this.data = d;
		count = 1;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public void decrementCount() {
		count--;
	}
	
	public int getCount() {
		return count;
	}
	
	public Comparable<Object> getData() {
		return data;
	}
	
}
