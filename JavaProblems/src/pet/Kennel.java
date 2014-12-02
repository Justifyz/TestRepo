package pet;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

	private List<Pet> petList;
	
	public Kennel(ArrayList<Pet> list) {
		this.petList = list;
	}
	
	public void allSpeak() {
		for(Pet pet : petList) {
			System.out.println(pet.getName() + " " + pet.speak());
		}
	}
	
}
