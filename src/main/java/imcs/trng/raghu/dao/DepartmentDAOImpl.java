package imcs.trng.raghu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import imcs.trng.raghu.dao.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	public DataSource dataSource;
	
	public List<Department> getDepartments() throws SQLException {
		List<Department> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"select deptNo,deptName from tbl_department")) {
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Department(rs.getInt(1), rs.getString(2)));
			}

		} catch (SQLException ex) {
			throw ex;
		}
		return list;
	}

	@Override
	public Department getDepartment(int deptNo) throws SQLException {
		ResultSet rs = null;
		Department dept = null;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"select deptNo,deptName from tbl_department where deptNo=?")) {
			ps.setInt(1, deptNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				dept = new Department(rs.getInt(1), rs.getString(2));
			}

		} catch (SQLException ex) {
			throw ex;
		}
		return dept;
	}


}
