package customer;

public class Customer {

	private String customerName;
	private int ID;
	
	
	public Customer(String name, int idNum) {
		this.customerName = name;
		this.ID = idNum;
	}
	

	public String getName() {
		return customerName;
	}
	
	public int getID() {
		return ID;
	}
	
	public int compareCustomer(Customer other) {
		int diff = getName().compareTo(other.getName());
		if(diff == 0) {
			return getID() - other.getID();
		}
		return diff;
	}
	
	
	
	public void prefixMerge(Customer[] list1, Customer[] list2, Customer[] result) {
		int i = 0, j = 0;
		for(int k = 0; k < result.length; k++) {
			Customer c1 = list1[i];
			Customer c2 = list2[j];
			int diff = c1.compareCustomer(c2);
			if(diff < 0) {
				result[k] = c1;
				i++;
			}
			else if(diff > 0) {
				result[k] = c2;
				j++;
			}
			else {
				result[k] = c1;
				i++;
				j++;
			}
		}
		
	}
	
}
