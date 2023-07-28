package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import net.javaguides.registration.model.Employees;

public class EmployeeDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
	private String username = "root";
	private String password = "root";
	private String insertemp = "INSERT INTO  testdb.employeetbl (id,first_name,Skills,Age,Salary,`Joining Date`)  "
			+ "values(?,?,?,?,?,?);";
	private String selectempbyid = "select id,first_name,Skills,Age,Salary,`Joining Date` from testdb.employeetbl where id = ?";
	private String allskills = "select Skills from testdb.employeetbl ";
	private String selectskills = "select id,first_name,Skills,Age,Salary,`Joining Date` from testdb.employeetbl where skills = ?";
	private String selectemp = "select id,first_name,Skills,Age,Salary,`Joining Date` from testdb.employeetbl";
	private String deleteemp = "delete from testdb.employeetbl where id = ?";
	private String updateemp = "update testdb.employeetbl set first_name=? , skills=?, Age=?, Salary = ?, `Joining Date` = ? where id = ? ";

	protected Connection getconnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void insertEmp(Employees emp) {
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(insertemp)) {
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getFirstname());
			ps.setString(3, emp.getSkills());
			ps.setString(4, emp.getAge());
			ps.setString(5, emp.getSalary());
			ps.setString(6, emp.getJoiningdate());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateEmp(Employees emp) {
		boolean rowupdated = false;
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(updateemp)) {
			ps.setString(1, emp.getFirstname());
			ps.setString(2, emp.getSkills());
			ps.setString(3, emp.getAge());
			ps.setString(4, emp.getSalary());
			ps.setString(5, emp.getJoiningdate());
			ps.setInt(6, emp.getId());
			System.out.println(ps);
			rowupdated = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowupdated;
	}

	public Employees selectEmployee(int id) {
		Employees emp = null;
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(selectempbyid)) {
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String first_name = rs.getString("first_name");
				String skills = rs.getString("Skills");
				String age = rs.getString("Age");
				String salary = rs.getString("Salary");
				String joiningdate = rs.getString("Joining Date");
				emp = new Employees(id, first_name, skills, age, salary, joiningdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employees> ListAllEmployee() {
		List<Employees> emp = new ArrayList<Employees>();
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(selectemp)) {

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String skills = rs.getString("Skills");
				String age = rs.getString("Age");
				String salary = rs.getString("Salary");
				String joiningdate = rs.getString("Joining Date");
				emp.add(new Employees(id, first_name, skills, age, salary, joiningdate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Employees> ListAllSkills() {
		List<Employees> emp = new ArrayList<Employees>();
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(allskills)) {

			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				String skills = rs.getString("Skills");
			
				emp.add(new Employees(skills));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Employees> ListSkillsBySkill(String skill) {
		List<Employees> emp = new ArrayList<Employees>();
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(selectskills)) {
			ps.setString(1, skill);
			ResultSet rs = ps.executeQuery();
			
			
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) 
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String age = rs.getString("Age");
				String salary = rs.getString("Salary");
				String joiningdate = rs.getString("Joining Date");
				emp.add(new Employees(id, first_name, skill, age, salary, joiningdate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public boolean deleteEmployee(int id) {
		boolean rowdeleted=false;
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(deleteemp)) {
			ps.setInt(1, id);
			rowdeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowdeleted;
	}

//	public int registerEmployee(Employees emp ) throws ClassNotFoundException
//	{
//		String insertemp = "INSERT INTO  testdb.employeetbl (id,first_name,Skills,Age,Salary,`Joining Date`)  "
//				+ "values(?,?,?,?,?,?);";
//		int result = 0;
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		try(Connection connecion = DriverManager
//				.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false","root","root"))
//		{
//			PreparedStatement ps = connecion.prepareStatement(insertemp);
//			ps.setInt(1, 1);
//			ps.setString(2, emp.getFirstname());
//			ps.setString(3, emp.getSkills());
//			ps.setString(4, emp.getAge());
//			ps.setString(5, emp.getSalary());
//			ps.setString(6, emp.getJoiningdate());
//			System.out.println(ps);
//			result = ps.executeUpdate();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return result;
//	}
}
