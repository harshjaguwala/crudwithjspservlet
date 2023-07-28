package net.javaguides.registration.model;

public class Employees {
	private int id;
	private String firstname;
	private String skills;
	private String age;
	private String salary;
	private String joiningdate;

	public Employees(String firstname, String skills, String age, String salary, String joiningdate) {
		super();
		this.firstname = firstname;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Employees(int id, String firstname, String skills, String age, String salary, String joiningdate) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
	}

	public Employees(String skills) {
		super();

		this.skills = skills;

	}
}
