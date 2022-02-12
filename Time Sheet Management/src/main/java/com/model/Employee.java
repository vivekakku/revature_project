package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;//primary key
	
	
	private String empName;
	private String empDesignationID;
	private String empJoinDate;//
	private String skill;
	private String deptID;
	private String empNotes;
	private String empEmail;
	private String phoneNo;
	private String emp_username;
	private String emp_password;
	
	@OneToOne
	private Timesheet timeSheet;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignationID() {
		return empDesignationID;
	}

	public void setEmpDesignationID(String empDesignationID) {
		this.empDesignationID = empDesignationID;
	}

	public String getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(String empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getEmpNotes() {
		return empNotes;
	}

	public void setEmpNotes(String empNotes) {
		this.empNotes = empNotes;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public Timesheet getTimeSheet() {
		return timeSheet;
	}
	@OneToOne(targetEntity =Timesheet.class)
	public void setTimeSheet(Timesheet timeSheet) {
		this.timeSheet = timeSheet;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, String empDesignationID, String empJoinDate, String skill, String deptID,
			String empNotes, String empEmail, String phoneNo, String emp_username, String emp_password,
			Timesheet timeSheet) {
		super();
		this.empName = empName;
		this.empDesignationID = empDesignationID;
		this.empJoinDate = empJoinDate;
		this.skill = skill;
		this.deptID = deptID;
		this.empNotes = empNotes;
		this.empEmail = empEmail;
		this.phoneNo = phoneNo;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.timeSheet = timeSheet;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignationID=" + empDesignationID
				+ ", empJoinDate=" + empJoinDate + ", skill=" + skill + ", deptID=" + deptID + ", empNotes=" + empNotes
				+ ", empEmail=" + empEmail + ", phoneNo=" + phoneNo + ", emp_username=" + emp_username
				+ ", emp_password=" + emp_password + ", timeSheet=" + timeSheet + "]";
	}

	
		

}
