package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Employee;
import com.model.Project;
import com.model.Timesheet;

@Component
public class TmsService {

	@Autowired
	TmsDAO TmsDAOImpl;

	public void save(Employee e) {
		TmsDAOImpl.save(e);
	}

	public List<Employee> empList(){
		return null;
		
	}

	public void update(Employee e) {
		
	}

	public void saveProject(Project p) {
		
	}

	public void trackStatus(int id) {
		
	}

	public void closeProject(int id) {
		
	}

	public void saveTimesheet(Timesheet t) {
		
	}

	public Timesheet findsheetDetails(int id) {
		return null;
		
	}

	public void approveTimesheet(int id) {
		
	}


}
