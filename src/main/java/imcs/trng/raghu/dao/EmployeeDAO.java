package imcs.trng.raghu.dao;

import java.sql.SQLException;
import java.util.List;

import imcs.trng.raghu.dao.model.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getEmployees(int deptNo) throws SQLException;
	
	public Employee getEmployee(int empId) throws SQLException;

	public boolean deleteEmployee(int empId) throws SQLException;
	
	public boolean updateEmployee(Employee emp) throws SQLException;
	
	public int addEmployee(Employee emp) throws SQLException;
	
}
