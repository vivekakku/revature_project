
package com.model;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity

public class Project {
	@Id
	@GeneratedValue
	private int project_ID;//primary key

	@Embedded
	private Client client;
	@OneToOne
	private Team team;

	private String project_Name;
	private String project_client_Name;
	private String project_brief;
	private String project_client_manager;
	private String project_client_email;
	public Project(Client client, Team team, String project_Name, String project_client_Name, String project_brief,
			String project_client_manager, String project_client_email, String project_OS_ID, String project_DB_ID,
			String project_App_server_ID, String project_manager_name, String project_PL, String project_notes,
			String project_start_date, String project_end_date, String project_status) {
		super();
		this.client = client;
		this.team = team;
		this.project_Name = project_Name;
		this.project_client_Name = project_client_Name;
		this.project_brief = project_brief;
		this.project_client_manager = project_client_manager;
		this.project_client_email = project_client_email;
		this.project_OS_ID = project_OS_ID;
		this.project_DB_ID = project_DB_ID;
		this.project_App_server_ID = project_App_server_ID;
		this.project_manager_name = project_manager_name;
		this.project_PL = project_PL;
		this.project_notes = project_notes;
		this.project_start_date = project_start_date;
		this.project_end_date = project_end_date;
		this.project_status = project_status;
	}
	private String project_OS_ID;
	private String project_DB_ID;
	private String project_App_server_ID;
	private String project_manager_name;
	private String project_PL;
	private String project_notes;
	private String project_start_date;//
	private String project_end_date;//
	private String project_status;

	public int getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(int project_ID) {
		this.project_ID = project_ID;
	}


	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@OneToOne
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}


	public String getProject_Name() {
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public String getProject_client_Name() {
		return project_client_Name;
	}
	public void setProject_client_Name(String project_client_Name) {
		this.project_client_Name = project_client_Name;
	}
	public String getProject_brief() {
		return project_brief;
	}
	public void setProject_brief(String project_brief) {
		this.project_brief = project_brief;
	}
	public String getProject_client_manager() {
		return project_client_manager;
	}
	public void setProject_client_manager(String project_client_manager) {
		this.project_client_manager = project_client_manager;
	}
	public String getProject_client_email() {
		return project_client_email;
	}
	public void setProject_client_email(String project_client_email) {
		this.project_client_email = project_client_email;
	}
	public String getProject_OS_ID() {
		return project_OS_ID;
	}
	public void setProject_OS_ID(String project_OS_ID) {
		this.project_OS_ID = project_OS_ID;
	}
	public String getProject_DB_ID() {
		return project_DB_ID;
	}
	public void setProject_DB_ID(String project_DB_ID) {
		this.project_DB_ID = project_DB_ID;
	}
	public String getProject_App_server_ID() {
		return project_App_server_ID;
	}
	public void setProject_App_server_ID(String project_App_server_ID) {
		this.project_App_server_ID = project_App_server_ID;
	}
	public String getProject_manager_name() {
		return project_manager_name;
	}
	public void setProject_manager_name(String project_manager_name) {
		this.project_manager_name = project_manager_name;
	}
	public String getProject_PL() {
		return project_PL;
	}
	public void setProject_PL(String project_PL) {
		this.project_PL = project_PL;
	}
	public String getProject_notes() {
		return project_notes;
	}
	public void setProject_notes(String project_notes) {
		this.project_notes = project_notes;
	}
	public String getProject_start_date() {
		return project_start_date;
	}
	public void setProject_start_date(String project_start_date) {
		this.project_start_date = project_start_date;
	}
	public String getProject_end_date() {
		return project_end_date;
	}
	public void setProject_end_date(String project_end_date) {
		this.project_end_date = project_end_date;
	}
	public String getProject_status() {
		return project_status;
	}
	public void setProject_status(String project_status) {
		this.project_status = project_status;
	}



}