package imcs.trng.raghu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import imcs.trng.raghu.dao.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	public DataSource dataSource;
	
	public List<Employee> getEmployees(int deptNo) throws SQLException {
		List<Employee> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"select empNo,empName,deptNo,doj,dob,salary,salaryGrade from tbl_employee where deptNo=?")) {
			ps.setInt(1, deptNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getFloat(6), rs.getInt(7)));
			}

		} catch(SQLException e){
			throw e;
		}
		return list;
	}

	@Override
	public Employee getEmployee(int empId) throws SQLException {
		ResultSet rs = null;
		Employee e = null;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"select empNo,empName,deptNo,doj,dob,salary,salaryGrade from tbl_employee where empNo=?")) {
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getFloat(6), rs.getInt(7));
			}

		} catch (SQLException ex) {
			throw ex;
		}
		return e;
	}

	@Override
	public boolean deleteEmployee(int empId) throws SQLException {
		int updCount = 0;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("delete from tbl_employee where empNo=?")) {
			ps.setInt(1, empId);
			updCount = ps.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		}
		return updCount > 0 ? true : false;
	}

	@Override
	public boolean updateEmployee(Employee emp) throws SQLException {
		int updCount = 0;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(
						"update tbl_employee set empName=?,deptNo=?,doj=?,dob=?,salary=?,salaryGrade=? where empNo=?")) {
			ps.setString(1, emp.getEmpName());
			ps.setInt(2, emp.getDeptNo());
			ps.setDate(3, new Date(emp.getDoj().getTime()));
			ps.setDate(4, new Date(emp.getDob().getTime()));
			ps.setFloat(5, emp.getSalary());
			ps.setInt(6, emp.getSalGrade());
			ps.setInt(7, emp.getEmpNo());
			updCount = ps.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		}
		return updCount > 0 ? true : false;
	}

	@Override
	public int addEmployee(Employee emp) throws SQLException{
		int addCount = 0;
		int id = 0;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("insert into tbl_employee values(?,?,?,?,?,?,?)")) {
			id = getNextEmpId();
			ps.setString(2, emp.getEmpName());
			ps.setInt(3, emp.getDeptNo());
			ps.setDate(4, new Date(emp.getDoj().getTime()));
			ps.setDate(5, new Date(emp.getDob().getTime()));
			ps.setFloat(6, emp.getSalary());
			ps.setInt(7, emp.getSalGrade());
			ps.setInt(1, id);
			System.out.println("dao"+id+","+emp.getSalGrade()+","+emp.getEmpName());
			addCount = ps.executeUpdate();
			System.out.println("add count"+addCount);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}
		return addCount > 0 ? id : 0;
	}

	private int getNextEmpId() throws SQLException {
		int empId = 0;
		try (Connection conn = dataSource.getConnection();
				Statement st = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement("select max(empNo) from tbl_employee")) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				empId = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw e;
		}
		return empId + 1;
	}

}
