package employee;

import java.util.ArrayList;
import java.util.List;



public class Company {
	private int retireAge;
	private int retireYears;
	private double retireSalary;
	private double salaryBudget;
	private List<Employee> empList;
	
	public Company(int retireAge, int retireYears,
					double retireSalary, double salaryBudget,
						ArrayList<Employee> list) {
		this.retireAge = retireAge;
		this.retireYears = retireYears;
		this.retireSalary = retireSalary;
		this.salaryBudget = salaryBudget;
		this.empList = list;
	}
	
	public void processRetirements(List<Employee> claimants) {
		for(Employee claimant : claimants) {
			if(employeeIsEligible(claimant)) {
				empList.remove(claimant);
				salaryBudget -= claimant.salary();
			}
		}
	}
	
	private boolean employeeIsEligible(Employee emp) {
		return (emp.age() >= retireAge && emp.yearsOnJob() >= retireYears)
				|| (emp.age() >= retireAge && emp.salary() >= retireSalary)
				|| (emp.yearsOnJob() >= retireYears && emp.salary() >= retireSalary);
	}
}
