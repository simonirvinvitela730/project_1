package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.simonirvinvitela.*;

public class EmployeeDAOImpl implements EmployeeDAO{
    
	@Override
	public List<Ticket> viewTicket(int emp_id) throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from ticket where employee_emp_id ="+emp_id;
		Query query = session.createQuery(hql);
		tickets = query.list();
	}catch(Exception e) {
		e.printStackTrace();
	}return tickets;
}

	@Override
	public Ticket addReimbursement(double amount, String type, String description, Employee employee, String ts) throws SQLException {
		Ticket ticket = new Ticket();
		try(Session session = HibernateFactory.getFactory().openSession()){
		       ticket.setAmount(amount);
		       ticket.setType(type);
		       ticket.setDescription(description);
		       ticket.setEmployee(employee);
		       ticket.setStatus("pending");
		       ticket.setTs(ts);
		       
		       Transaction t = session.beginTransaction();
		       
		       session.save(ticket);
		       t.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}return ticket;
		   
	}

	@Override
	public List<Employee> getEmployeeByLogin(String username, String password){
		Transaction transaction;
		List<Employee> employeeList = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
			String hql = "from employee where username = :n and password = :g";
	        Query query = session.createQuery(hql);
	        transaction=session.beginTransaction();
	        query.setParameter("n", username);
	        query.setParameter("g", password);
	        employeeList=query.list();
	        transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public void updateEmployee(int emp_id, List<Ticket> tickets, String firstName, String lastName, String username,
			String password, String email, int emp_type) throws SQLException {
		Transaction transaction;
		try(Session session = HibernateFactory.getFactory().openSession()){
			transaction=session.beginTransaction();
			Employee employee = new Employee(emp_id, tickets, firstName, lastName, username, password, email, emp_type);
			session.update(employee);
			transaction.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Employee employeeById(int emp_id) throws SQLException {
		Transaction transaction;
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		try(Session session = HibernateFactory.getFactory().openSession()){
			String hql = "from employee where emp_id= :n";
	        Query query = session.createQuery(hql);
	        transaction=session.beginTransaction();
	        query.setParameter("n", emp_id);
	        employeeList=query.list();
	        transaction.commit();
	        
	        Iterator<Employee> listIterator = employeeList.iterator();
	        while (listIterator.hasNext()) {
	        	employee = listIterator.next();
		}
		return employee;
		}
	}
		
		
		
		
//		Employee employee = new Employee();
//		String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
//		statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(sql);
//		
//    	while(resultSet.next()){
//        		int emp_id = resultSet.getInt(1);
//               	String email = resultSet.getString(2);
//               	String firstName = resultSet.getString(3);
//               	String lastName = resultSet.getString(4);
//               	int type = resultSet.getInt(6);
//               	
//               	employee.setEmp_id(emp_id);
//               	employee.setFirstName(firstName);
//    			employee.setLastName(lastName);
//    			employee.setEmail(email);
//    			employee.setUsername(username);
//    			employee.setPassword(password);
//    			employee.setType(type);
			
	}
	
