package filingsystem;

import java.util.LinkedList;
import java.util.List;

public class Drawer {
	private int drawerMaxID;
	private List<Student> studentList;
	private Drawer next;
	
	public Drawer(int id, LinkedList<Student> list) {
		this.drawerMaxID = id;
		this.studentList = list;
	}
	
	public void setNext(Drawer d) {
		this.next = d;
	}
	
	public Drawer getNext() {
		return next;
	}
	
	public int getMaxID() {
		return drawerMaxID;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	
}
