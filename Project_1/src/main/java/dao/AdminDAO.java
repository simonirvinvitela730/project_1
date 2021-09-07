package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simonirvinvitela.*;

public interface AdminDAO {
	Employee getEmployeeById(int emp_id) throws SQLException;
	Ticket getTicketById(int ticket_id) throws SQLException;
	List<Ticket> viewTickets() throws SQLException;
	List<Ticket> viewApproved() throws SQLException;
	List<Ticket> viewRejected() throws SQLException;
	List<Ticket> viewPending() throws SQLException;
	void approveTicket(Ticket ticket) throws SQLException;
	void rejectTicket(Ticket ticket) throws SQLException;
	void resetTicket(Ticket ticket) throws SQLException;
	List<Admin> getAdminByLogin(String username, String password) throws SQLException;
}
