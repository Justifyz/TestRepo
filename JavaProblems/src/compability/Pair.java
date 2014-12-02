package compability;

public class Pair implements Comparable<Object> {

	private Person personOne, personTwo;
	
	public Pair(Person p1, Person p2) {
		this.personOne = p1;
		this.personTwo = p2;
	}
	
	public Person getPerson1() {
		return personOne;
	}
	
	public Person getPerson2() {
		return personTwo;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
