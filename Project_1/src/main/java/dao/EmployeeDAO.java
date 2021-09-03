package dao;
import java.sql.SQLException;

import com.simonirvinvitela.*;

public interface EmployeeDAO {
	void viewTicket(int emp_id) throws SQLException;
	void addReimbursement() throws SQLException;
	Employee getEmployeeByLogin(String username, String password) throws SQLException;
}
