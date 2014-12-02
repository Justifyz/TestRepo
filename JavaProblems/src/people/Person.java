package people;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private Set<Person> contacts;
	
	public Person(HashSet<Person> p) {
		this.contacts = p;
	}
	
	public Set<Person> getContacts() {
		return contacts;
	}
	
	public Set<Person> expandContactSet(Set<Person> people) {
		Set<Person> newSet = new HashSet<Person>();
		for(Person p : people) {
			newSet.add(p);
			for(Person contact : p.getContacts()) {
				newSet.add(contact);
			}
		}
		return newSet;
	}
	
	public Set<Person> getNetwork(int dist) {
		if(dist == 1) {
			return getContacts();
		}
		return expandContactSet(getNetwork(dist-1));
	}
	
}
