package imcs.trng.raghu.dao.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
	private int empNo;
	private String empName;
	private int deptNo;
	private Date doj;
	private Date dob;
	private float salary;
	private int salGrade;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Employee() {
	}
	public Employee(int empNo, String empName, int deptNo, Date doj, Date dob, float salary, int salGrade) {
		this.empNo = empNo;
		this.empName = empName;
		this.deptNo = deptNo;
		this.doj = doj;
		this.dob = dob;
		this.salary = salary;
		this.salGrade = salGrade;
	}
	public int getSalGrade() {
		return salGrade;
	}
	public void setSalGrade(int salGrade) {
		this.salGrade = salGrade;
	}
}
