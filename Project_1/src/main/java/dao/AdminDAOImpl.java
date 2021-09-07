package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.simonirvinvitela.*;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public Employee getEmployeeById(int emp_id) throws SQLException {
//		Employee employee = new Employee();
//		String sql = "select * from employee where id ="+emp_id;
//		statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(sql);
//		while(resultSet.next()) {
//			String email = resultSet.getString(2);
//			String firstName = resultSet.getString(3);
//			String lastName = resultSet.getString(4);
//			String password = resultSet.getString(5);
//			int type = resultSet.getInt(6);
//			String username = resultSet.getString(7);
//			
//			employee.setEmp_id(emp_id);
//			employee.setFirstName(firstName);
//			employee.setLastName(lastName);
//			employee.setEmail(email);
//			employee.setUsername(username);
//			employee.setPassword(password);
//			employee.setType(type);
//			
//		}return employee;
		return null;
	}
	
	@Override
	public Ticket getTicketById(int ticket_id) throws SQLException {
		Transaction transaction;
		List<Ticket> ticketList = new ArrayList<>();
		Ticket ticket = new Ticket();
		try(Session session = HibernateFactory.getFactory().openSession()){
			String hql = "from ticket where ticket_id= :n";
			Query query = session.createQuery(hql);
			transaction=session.beginTransaction();
			query.setParameter("n", ticket_id);
		    ticketList=query.list();
		    transaction.commit();
		        
		    Iterator<Ticket> listIterator = ticketList.iterator();
		        while (listIterator.hasNext()) {
		        	ticket = listIterator.next();
			}
			return ticket;
		}
	}


	@Override
	public List<Ticket> viewTickets() throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from ticket";
		Query query = session.createQuery(hql);
		tickets = query.list();
	}catch(Exception e) {
		e.printStackTrace();
	}return tickets;
}
	
	@Override
	public List<Ticket> viewApproved() throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from ticket where status = 'approved'";
		Query query = session.createQuery(hql);
		tickets = query.list();
	}catch(Exception e) {
		e.printStackTrace();
	}return tickets;
}
	
	@Override
	public List<Ticket> viewRejected() throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from ticket where status = 'rejected'";
		Query query = session.createQuery(hql);
		tickets = query.list();
	}catch(Exception e) {
		e.printStackTrace();
	}return tickets;
}
	
	@Override
	public List<Ticket> viewPending() throws SQLException {
		List<Ticket> tickets = new ArrayList<>();
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from ticket where status = 'pending'";
		Query query = session.createQuery(hql);
		tickets = query.list();
	}catch(Exception e) {
		e.printStackTrace();
	}return tickets;
}

	@Override
	public void approveTicket(Ticket ticket) throws SQLException {
		Transaction transaction = null;
		try(Session session = HibernateFactory.getFactory().openSession()){
	        	String hql = "update ticket set status = :n where ticket_id="+ticket.getTicket_id();
		        Query query = session.createQuery(hql);
		        transaction= session.beginTransaction();
		        query.setParameter("n", "approved");
		        
		        int count = query.executeUpdate();
		        transaction.commit();
			}catch(Exception e){
				transaction.rollback();
				e.printStackTrace();
			}

	}

	@Override
	public void rejectTicket(Ticket ticket) throws SQLException {
		Transaction transaction = null;
		try(Session session = HibernateFactory.getFactory().openSession()){
	        	String hql = "update ticket set status = :n where ticket_id="+ticket.getTicket_id();
		        Query query = session.createQuery(hql);
		        transaction= session.beginTransaction();
		        query.setParameter("n", "rejected");
		        
		        int count = query.executeUpdate();
		        transaction.commit();
			}catch(Exception e){
				transaction.rollback();
				e.printStackTrace();
			}

	}
	
	@Override
	public void resetTicket(Ticket ticket) throws SQLException{ 
		Transaction transaction = null;
	    try(Session session = HibernateFactory.getFactory().openSession()){
	    		String hql = "update ticket set status = :n where ticket_id="+ticket.getTicket_id();
	    		Query query = session.createQuery(hql);
	    		transaction= session.beginTransaction();
	    		query.setParameter("n", "pending");
        
	    		int count = query.executeUpdate();
	    		transaction.commit();
	    	}catch(Exception e){
	    		transaction.rollback();
	    		e.printStackTrace();
	    	}

}
	
	
	
	public List<Admin> getAdminByLogin(String username, String password){
		List<Admin> adminList = new ArrayList<>();
		Transaction transaction = null;
		try(Session session = HibernateFactory.getFactory().openSession()){
		String hql = "from admin where username = :n and password = :g";
        Query query = session.createQuery(hql);
        transaction= session.beginTransaction();
        query.setParameter("n", username);
        query.setParameter("g", password);
        adminList = query.list();
        transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return adminList;
	}

	
	
//	@Override
//	public Admin getAdminByLogin(String username, String password) throws SQLException {
//		Admin admin = new Admin();
//		String sql = "select * from admin where username = '"+username+"' and password = '"+password+"'";
//		statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(sql);
//		
//    	while(resultSet.next()){
//        		int adm_id = resultSet.getInt(1);
//               	String email = resultSet.getString(2);
//               	String firstName = resultSet.getString(3);
//               	String lastName = resultSet.getString(4);
//               	int type = resultSet.getInt(6);
//               	
//               	admin.setAdm_id(adm_id);
//               	admin.setFirstName(firstName);
//    			admin.setLastName(lastName);
//    			admin.setEmail(email);
//    			admin.setUsername(username);
//    			admin.setPassword(password);
//    			admin.setType(type);
//    			
//    	}return admin;	
//	}	

}
