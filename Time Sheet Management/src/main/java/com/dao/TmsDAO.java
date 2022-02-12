package com.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.model.Employee;
import com.model.Project;
import com.model.Timesheet;

@Component
public interface TmsDAO {
	
	public void save(Employee e);
	
	public List<Employee> empList();
	
	public void update(Employee e);
	
	public void saveProject(Project p);
	
	public void trackStatus(int id);
	
	public void closeProject(int id);
	
	public void saveTimesheet(Timesheet t);
	
	public Timesheet findsheetDetails(int id);
	
	public void approveTimesheet(int id);
	
}
