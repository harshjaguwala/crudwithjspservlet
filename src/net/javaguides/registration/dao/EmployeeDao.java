package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import net.javaguides.registration.model.Employees;
import net.javaguides.registration.model.Skiils;

public class EmployeeDao {
	int generateId;
	private String jdbcURL = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
	private String username = "root";
	private String password = "root";
	private String insertemp = "INSERT INTO  testdb.employeetbl (id,first_name,Age,Salary,`Joining Date`,gender)  "
			+ "values(?,?,?,?,?,?);";
	private String selectempbyid = "select e.id,s.skillid,s.skillid,e.first_name,e.Age,e.Salary,e.`Joining Date`,e.gender,s.Skills from  testdb.employeetbl e INNER JOIN testdb.skiils s  where e.id = s.id and e.id=?;";
	private String selectemp = "select e.id,s.skillid,e.first_name,e.Age,e.Salary,e.`Joining Date`,e.gender,s.Skills from  testdb.employeetbl e INNER JOIN testdb.skiils s where e.id = s.id;";
	private String deleteemp = "delete from testdb.employeetbl where id = ?";
	private String updateemp = "update testdb.employeetbl set first_name=? ,  Age=?, Salary = ?, `Joining Date` = ?,gender = ? where id = ? ";
	private String insertskill = "Insert into skiils(skillid,id,Skills) values(?,?,?);";
	private String selectallskill = "Select skillid,Skills,id FROM testdb.skiils;";
	private String updateskill = "update testdb.skiils set Skills=? where id=?;";
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
		try (Connection connecion = getconnection();
			PreparedStatement ps = connecion.prepareStatement(insertemp,java.sql.Statement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getFirstname());
			ps.setString(3, emp.getAge());
			ps.setString(4, emp.getSalary());
			ps.setString(5, emp.getJoiningdate());
			ps.setString(6, emp.getgender());
			System.out.println(ps);
			int affectedrows = ps.executeUpdate();
			if(affectedrows > 0)
			{
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if(generatedKeys.next())
				{
					generateId = generatedKeys.getInt(1);
				}
				generatedKeys.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertSkill(Skiils  skill) {
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(insertskill)) {
			ps.setInt(1, skill.getSkillid());
			ps.setLong(2, generateId);
			ps.setString(3, skill.getSkillname());
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
			ps.setString(2, emp.getAge());
			ps.setString(3, emp.getSalary());
			ps.setString(4, emp.getJoiningdate());
			ps.setString(5, emp.getgender());
			ps.setInt(6, emp.getId());
			System.out.println(ps);
			rowupdated = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowupdated;
	}
	
	public boolean updateSkill(Skiils skill) {
		boolean rowupdated = false;
		try (Connection connecion = getconnection(); PreparedStatement ps = connecion.prepareStatement(updateskill)) {
			ps.setString(1, skill.getSkillname());
			ps.setInt(2, skill.getSkillid() );
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
				String gender = rs.getString("gender");
				String age = rs.getString("Age");
				String salary = rs.getString("Salary");
				String joiningdate = rs.getString("Joining Date");
				String skill = rs.getString("Skills");
				emp = new Employees(id, first_name, gender, age, salary, joiningdate,skill);
				System.out.println("Dao employee " +  emp);
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
				int skillid = rs.getInt("skillid");
				String first_name = rs.getString("first_name");
				String gender = rs.getString("gender");
				String age = rs.getString("Age");
				String salary = rs.getString("Salary");
				String joiningdate = rs.getString("Joining Date");
				String skill = rs.getString("Skills");
				emp.add(new Employees(id, first_name, gender, age, salary, joiningdate, skill, skillid));
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
		}
		return rowdeleted;
	}
}
