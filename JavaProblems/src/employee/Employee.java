package employee;

public class Employee {
	private int age;
	private int yearsWorked;
	private double salary;
	private int ID;
	
	public Employee(int age, int years, double salary, int ID) {
		this.age = age;
		this.yearsWorked = years;
		this.salary = salary;
		this.ID = ID;
	}
	
	public int age() {
		return age;
	}
	
	public int yearsOnJob() {
		return yearsWorked;
	}
	
	public double salary() {
		return salary;
	}
	
	public int ID() {
		return ID;
	}
}
