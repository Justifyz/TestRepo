package products;

public class ProductImpl {

	public static void main(String[] args) {
		
		Item oven = new Item("ZapIt Microwave Oven", 90.0);
		Item toaster = new Item("NeverBurn Toaster", 20.0);
		Pack toasterPack = new Pack(4, toaster);
		
		Bundle homeCookingKit = new Bundle();
		homeCookingKit.add(oven);
		homeCookingKit.add(toaster);
		
		Bundle restaurantStarterKit = new Bundle();
		restaurantStarterKit.add(homeCookingKit);
		restaurantStarterKit.add(toasterPack);
		
		System.out.println(restaurantStarterKit.getPrice());
		
		oven.setPrice(100.0);
		toaster.setPrice(30.0);
		
		System.out.println(restaurantStarterKit.getPrice());
		
		
	}
	
}
