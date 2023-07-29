package net.javaguides.registration.model;

public class Employees {
	private int id;
	private String firstname;
	private String gender;
	private String age;
	private String salary;
	private String joiningdate;
	private String skills;
	private int skillid;
	
	
	
	

	public Employees(int id, String firstname, String gender, String age, String salary, String joiningdate,
			String skills, int skillid) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
		this.skillid = skillid;
	}

	public int getSkillid() {
		return skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employees(String firstname, String gender, String age, String salary, String joiningdate, String skills) {
		super();
		this.firstname = firstname;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
	}
	
	public Employees(int id, String firstname, String gender, String age, String salary, String joiningdate) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.gender = gender;
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

	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
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

	public Employees(int id, String firstname, String gender, String age, String salary, String joiningdate,
			String skills) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstname=" + firstname + ", gender=" + gender + ", age=" + age + ", salary="
				+ salary + ", joiningdate=" + joiningdate + ", skills=" + skills + "]";
	}

	

	
}
