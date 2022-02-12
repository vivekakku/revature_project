package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="team")
public class Team {
	@Id
	private int teamID;//primary key
	private String teamName;
	private String teamLeader;
	private String teamNotes;
	
	@OneToOne
	private Project project;
	
	
    private String countries;
    @OneToMany
	private List<TeamMember> teamMembers;
	@ManyToOne
	private Employee employee;
	
	public Team() {
		super();
	}
	public Team(int teamID, String teamName, String teamLeader, String teamNotes, Project project,
			String countries, List<TeamMember> teamMembers, Employee employee) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.teamLeader = teamLeader;
		this.teamNotes = teamNotes;
		this.project = project;
		this.countries = countries;
		this.teamMembers = teamMembers;
		this.employee = employee;
	}
	public String getCountries() {
		return countries;
	}
	public void setCountries(String countries) {
		this.countries = countries;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}
	
	public String getTeamNotes() {
		return teamNotes;
	}
	public void setTeamNotes(String teamNotes) {
		this.teamNotes = teamNotes;
	}
	
	
	public Project getProject() {
		return project;
	}
	@OneToOne(targetEntity = Project.class)
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	public List<TeamMember> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	@OneToMany
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Team [teamID=" + teamID + ", teamName=" + teamName + ", teamLeader=" + teamLeader + ", teamNotes="
				+ teamNotes + ", project=" + project + ", countries=" + countries + ", teamMembers=" + teamMembers
				+ ", employee=" + employee + "]";
	}
	

}
