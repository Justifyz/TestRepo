package pet;

public abstract class Pet {

	private String myName;
	
	public Pet(String name) {
		this.myName = name;
	}
	
	public String getName() {
		return myName;
	}
	
	public abstract String speak();
	
}
