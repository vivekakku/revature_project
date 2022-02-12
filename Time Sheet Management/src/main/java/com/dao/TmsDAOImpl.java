package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Employee;
import com.model.Project;
import com.model.Timesheet;
@Component
public class TmsDAOImpl implements TmsDAO{
	Timesheet t=new Timesheet();
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Employee e) 
	{
		Session session=sessionFactory.openSession();
		//session.save(e);
		//session.flush();
		//session.close();
		
		Employee e1=new Employee("vijaykumar","A9","14/08/2021","Java","AWSB1","project_demo","vijay@gmail.com","1234567890","vijay","1234",t);
		session.save(e1);
		
		session.close();
		
		
	}

	@Override
	public List<Employee> empList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveProject(Project p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trackStatus(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeProject(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveTimesheet(Timesheet t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Timesheet findsheetDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveTimesheet(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
