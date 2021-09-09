package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.simonirvinvitela.Employee;
import com.simonirvinvitela.Ticket;

import dao.AdminDAO;
import dao.AdminDAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Reject extends HttpServlet{
	
	private  static  final Logger logger = LogManager.getLogger(Reject.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
			
		if(session != null) {
				int ticket_id = Integer.parseInt(request.getParameter("id"));
			
				Ticket ticket = new Ticket();
			
			try {
	        	AdminDAO dao =  AdminDAOFactory.getAdminDAO();
	        	ticket = dao.getTicketById(ticket_id);
				dao.rejectTicket(ticket);
				logger.info("Ticket Id: "+ticket_id+" status changed to rejected...");
			}catch(Exception e) {
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
			rd.include(request, response);
			
			RequestDispatcher rd4 = request.getRequestDispatcher("/form.html");
			rd4.include(request, response);
			
			RequestDispatcher rd2 = request.getRequestDispatcher("AdminServlet");
			rd2.include(request, response);
			
			RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
			rd3.include(request, response);
			
		}else {
			
		}
	}
}