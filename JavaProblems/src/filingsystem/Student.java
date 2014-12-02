package filingsystem;

public class Student {
	private int idNum;
	private Student next;
	
	public Student(int idNum) {
		this.idNum = idNum;
	}
	
	public void setNext(Student s) {
		this.next = s;
	}
	
	public Student getNext() {
		return next;
	}

	public int getID() {
		return idNum;
	}
}
