package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	public void reviewTicket(Ticket ticket) throws SQLException {
		// TODO Auto-generated method stub
		
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
	public void approveTicket(int ticket_id) throws SQLException {
		
//		String sql = "update ticket set status = 'approved' where ticket_id ="+ticket_id;
//		
//		statement = connection.createStatement();
//		int update = statement.executeUpdate(sql); 
		
	}

	@Override
	public void rejectTicket(int ticket_id) throws SQLException {
//		String sql = "update ticket set status = 'rejeted' where ticket_id ="+ticket_id;
//		
//		statement = connection.createStatement();
//		int update = statement.executeUpdate(sql);
		
		
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
