package imcs.trng.raghu.dao;

import java.sql.SQLException;
import java.util.List;

import imcs.trng.raghu.dao.model.Department;

public interface DepartmentDAO {
	
	public List<Department> getDepartments() throws SQLException;
	
	public Department getDepartment(int deptNo) throws SQLException;
	
}
