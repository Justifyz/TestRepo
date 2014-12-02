package filingsystem;

import java.util.LinkedList;
import java.util.List;

public class FilingCabinet {
	private List<Drawer> drawerList;
	
	public FilingCabinet(LinkedList<Drawer> list) {
		this.drawerList = list;
	}
	
	public Drawer findDrawer(int studentID) {
		for(Drawer drawer : drawerList) {
			if(drawer.getMaxID() >= studentID) {
				return drawer;
			}
		}
		return drawerList.get(drawerList.size()-1);
	}
	
	public void removeStudent(int studentID) {
		Drawer drawer = findDrawer(studentID);
		List<Student> studentList = drawer.getStudentList();
		for(Student student : studentList) {
			if(student.getID() == studentID) {
				studentList.remove(student);
			}
		}
	}
}
