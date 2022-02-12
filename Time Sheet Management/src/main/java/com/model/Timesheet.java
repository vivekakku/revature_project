package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="timesheet")
public class Timesheet {
	@Id
	private int timeSheetID;//primary key

	@OneToMany
	private List<Project> project;
	@OneToOne
	private Employee employee;
	
	private String timeSheet_Act;
	private String timeSheet_Date;//
	private String timeSheet_NOHours;
	private String timeSheet_Approved;
	private String timeSheet_ApprovedBy;
	private String timeSheet_Rejected_Reason;
	private String timeSheet_Notes;
	private String timeSheet_Feedback;
	private String timeSheet_Suggestion;
	private String timeSheet_Other_Activities;
	
	
	public Timesheet() {
		super();
	}
	public Timesheet(int timeSheetID, List<Project> project, Employee employee, String timeSheet_Act,
			String timeSheet_Date, String timeSheet_NOHours, String timeSheet_Approved, String timeSheet_ApprovedBy,
			String timeSheet_Rejected_Reason, String timeSheet_Notes, String timeSheet_Feedback,
			String timeSheet_Suggestion, String timeSheet_Other_Activities) {
		super();
		this.timeSheetID = timeSheetID;
		this.project = project;
		this.employee = employee;
		this.timeSheet_Act = timeSheet_Act;
		this.timeSheet_Date = timeSheet_Date;
		this.timeSheet_NOHours = timeSheet_NOHours;
		this.timeSheet_Approved = timeSheet_Approved;
		this.timeSheet_ApprovedBy = timeSheet_ApprovedBy;
		this.timeSheet_Rejected_Reason = timeSheet_Rejected_Reason;
		this.timeSheet_Notes = timeSheet_Notes;
		this.timeSheet_Feedback = timeSheet_Feedback;
		this.timeSheet_Suggestion = timeSheet_Suggestion;
		this.timeSheet_Other_Activities = timeSheet_Other_Activities;
	}
	public int getTimeSheetID() {
		return timeSheetID;
	}
	public void setTimeSheetID(int timeSheetID) {
		this.timeSheetID = timeSheetID;
	}
	
	   
	@JoinColumn(name = "project_ID")
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
	
	
	public Employee getEmployee() {
		return employee;
	}
	@OneToOne(targetEntity = Employee.class)
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getTimeSheet_Act() {
		return timeSheet_Act;
	}
	public void setTimeSheet_Act(String timeSheet_Act) {
		this.timeSheet_Act = timeSheet_Act;
	}
	
	public String getTimeSheet_Date() {
		return timeSheet_Date;
	}
	public void setTimeSheet_Date(String timeSheet_Date) {
		this.timeSheet_Date = timeSheet_Date;
	}
	
	public String getTimeSheet_NOHours() {
		return timeSheet_NOHours;
	}
	public void setTimeSheet_NOHours(String timeSheet_NOHours) {
		this.timeSheet_NOHours = timeSheet_NOHours;
	}
	
	public String getTimeSheet_Approved() {
		return timeSheet_Approved;
	}
	public void setTimeSheet_Approved(String timeSheet_Approved) {
		this.timeSheet_Approved = timeSheet_Approved;
	}
	
	public String getTimeSheet_ApprovedBy() {
		return timeSheet_ApprovedBy;
	}
	public void setTimeSheet_ApprovedBy(String timeSheet_ApprovedBy) {
		this.timeSheet_ApprovedBy = timeSheet_ApprovedBy;
	}
	
	public String getTimeSheet_Rejected_Reason() {
		return timeSheet_Rejected_Reason;
	}
	public void setTimeSheet_Rejected_Reason(String timeSheet_Rejected_Reason) {
		this.timeSheet_Rejected_Reason = timeSheet_Rejected_Reason;
	}
	
	public String getTimeSheet_Notes() {
		return timeSheet_Notes;
	}
	public void setTimeSheet_Notes(String timeSheet_Notes) {
		this.timeSheet_Notes = timeSheet_Notes;
	}
	
	public String getTimeSheet_Feedback() {
		return timeSheet_Feedback;
	}
	public void setTimeSheet_Feedback(String timeSheet_Feedback) {
		this.timeSheet_Feedback = timeSheet_Feedback;
	}
	
	public String getTimeSheet_Suggestion() {
		return timeSheet_Suggestion;
	}
	public void setTimeSheet_Suggestion(String timeSheet_Suggestion) {
		this.timeSheet_Suggestion = timeSheet_Suggestion;
	}
	
	public String getTimeSheet_Other_Activities() {
		return timeSheet_Other_Activities;
	}
	public void setTimeSheet_Other_Activities(String timeSheet_Other_Activities) {
		this.timeSheet_Other_Activities = timeSheet_Other_Activities;
	}
	
}
