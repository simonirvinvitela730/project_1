package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.simonirvinvitela.*;

public class AdminDAOImpl implements AdminDAO{
	
	private static Statement statement = null;
    Connection connection = null;
    
    public AdminDAOImpl() throws ClassNotFoundException  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

	@Override
	public Employee getEmployeeById(int emp_id) throws SQLException {
		Employee employee = new Employee();
		String sql = "select * from employee where id ="+emp_id;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			String email = resultSet.getString(2);
			String firstName = resultSet.getString(3);
			String lastName = resultSet.getString(4);
			String password = resultSet.getString(5);
			int type = resultSet.getInt(6);
			String username = resultSet.getString(7);
			
			employee.setEmp_id(emp_id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setEmail(email);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setType(type);
			
		}return employee;
	}

	@Override
	public void reviewTicket(Ticket ticket) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTickets() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveTicket(int ticket_id) throws SQLException {
		
		String sql = "update ticket set status = 'approved' where ticket_id ="+ticket_id;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql); 
		
	}

	@Override
	public void rejectTicket(int ticket_id) throws SQLException {
		String sql = "update ticket set status = 'rejeted' where ticket_id ="+ticket_id;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql);
		
		
	}
	
	@Override
	public Admin getAdminByLogin(String username, String password) throws SQLException {
		Admin admin = new Admin();
		String sql = "select * from admin where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
    	while(resultSet.next()){
        		int adm_id = resultSet.getInt(1);
               	String email = resultSet.getString(2);
               	String firstName = resultSet.getString(3);
               	String lastName = resultSet.getString(4);
               	int type = resultSet.getInt(6);
               	
               	admin.setAdm_id(adm_id);
               	admin.setFirstName(firstName);
    			admin.setLastName(lastName);
    			admin.setEmail(email);
    			admin.setUsername(username);
    			admin.setPassword(password);
    			admin.setType(type);
    			
    	}return admin;	
	}	

}
