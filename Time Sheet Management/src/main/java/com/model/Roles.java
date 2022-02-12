package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Roles {
	@Id
	private int roleId;
	@OneToOne
	private TeamMember teamMember;
	

	public Roles() {
		super();
	}

	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}
	

}
