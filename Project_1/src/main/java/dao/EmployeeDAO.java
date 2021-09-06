package dao;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.simonirvinvitela.*;

public interface EmployeeDAO {
	List<Ticket> viewTicket(int emp_id) throws SQLException;
	Ticket addReimbursement(double Amount, String type, String description, Employee employee, String ts) throws SQLException;
	List<Employee> getEmployeeByLogin(String username, String password);
	void updateEmployee(int emp_id, List<Ticket> tickets, String firstName, String lastName, String username,
			String password, String email, int emp_type) throws SQLException;
	Employee employeeById(int emp_id) throws SQLException;
}
