package com.model;

import javax.persistence.*;
@Entity
@Table(name="teammember")
public class TeamMember {
	@ManyToOne(targetEntity = Team.class)
	Team team ;
	@Id
	private int teamMemberId;
	@OneToOne
	private Employee e1;
	@OneToOne
	private Roles r1;
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getTeamMemberId() {
		return teamMemberId;
	}
	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}
	public Employee getE1() {
		return e1;
	}
	public void setE1(Employee e1) {
		this.e1 = e1;
	}
	public Roles getR1() {
		return r1;
	}
	public void setR1(Roles r1) {
		this.r1 = r1;
	}
	
	
	
	

}
