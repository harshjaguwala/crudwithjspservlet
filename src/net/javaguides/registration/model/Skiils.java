package net.javaguides.registration.model;

public class Skiils 
{
	private int skillid;
	private String skillname;
	private int empid;
	
	public int getSkillid() {
		return skillid;
	}
	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public Skiils(int skillid, String skillname, int empid) {
		super();
		this.skillid = skillid;
		this.skillname = skillname;
		this.empid = empid;
	}



	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	public Skiils() {
		super();
	}
	public Skiils(String list) {
		super();
		this.skillname = list;
	}
	public Skiils(String skillname, int empid) {
		super();
		this.skillname = skillname;
		this.empid = empid;
	}
	
	
	
	
	
}
