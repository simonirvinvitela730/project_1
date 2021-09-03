package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.simonirvinvitela.*;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Statement statement = null;
    Connection connection = null;
    
    public EmployeeDAOImpl() throws ClassNotFoundException  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
	@Override
	public void viewTicket(int emp_id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReimbursement() throws SQLException {
		Ticket ticket = new Ticket();
		String sql = "insert into ticket (amount, description, status, ts, type) values"
				+ "(?, ?, 'pending', ?, ?))";
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 preparedStatement.setDouble(1, ticket.getAmount());
		 preparedStatement.setString(2, ticket.getDescription());
		 preparedStatement.setTimestamp(4, ticket.getTs());
		 preparedStatement.setString(5, ticket.getType());
		 int count = preparedStatement.executeUpdate();
		 
		 if(count > 0) {
	            System.out.println("ticket added...");
	        }
	        else {
	            System.out.println("Oops! something went wrong");
	        }
		}

	@Override
	public Employee getEmployeeByLogin(String username, String password) throws SQLException {
		Employee employee = new Employee();
		String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
    	while(resultSet.next()){
        		int emp_id = resultSet.getInt(1);
               	String email = resultSet.getString(2);
               	String firstName = resultSet.getString(3);
               	String lastName = resultSet.getString(4);
               	int type = resultSet.getInt(6);
               	
               	employee.setEmp_id(emp_id);
               	employee.setFirstName(firstName);
    			employee.setLastName(lastName);
    			employee.setEmail(email);
    			employee.setUsername(username);
    			employee.setPassword(password);
    			employee.setType(type);
    			
    	}return employee;	
	}	
}
