package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.simonirvinvitela.Admin;
import com.simonirvinvitela.Employee;
import com.simonirvinvitela.Ticket;

import dao.AdminDAO;
import dao.AdminDAOFactory;
import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateTicket extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
			
		if(session != null) {
			int ticket_id = (Integer)session.getAttribute("ticket_id");
        	Employee employee = (Employee)session.getAttribute("ticket_employee");
        	String description = (String)session.getAttribute("description");
        	double amount = (Double)session.getAttribute("amount");
        	String status = (String)session.getAttribute("status");
        	String timestamp = (String)session.getAttribute("timestamp");
        	String type = (String)session.getAttribute("ticket_type");
        	
        	Ticket ticket = new Ticket(ticket_id, employee, status, type, amount, description, timestamp);
        	
			try {
				if(status.equals("approved")) {
					
				}else if(status.equals("declined")) {
					
				}
				AdminDAO dao =  AdminDAOFactory.getAdminDAO();
				
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}
}
