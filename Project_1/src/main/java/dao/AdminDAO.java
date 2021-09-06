package dao;
import java.sql.SQLException;
import java.util.List;

import com.simonirvinvitela.*;

public interface AdminDAO {
	Employee getEmployeeById(int emp_id) throws SQLException;
	void reviewTicket(Ticket ticket) throws SQLException;
	List<Ticket> viewTickets() throws SQLException;
	void approveTicket(int ticket_id) throws SQLException;
	void rejectTicket(int ticket_id) throws SQLException;
	List<Admin> getAdminByLogin(String username, String password) throws SQLException;
}
