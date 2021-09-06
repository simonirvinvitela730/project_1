package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.simonirvinvitela.*;

import dao.AdminDAO;
import dao.AdminDAOFactory;
import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
			
		if(session != null) {
			int adm_id = (Integer)session.getAttribute("adm_id");
			String firstName = (String)session.getAttribute("adm_first");
			String lastName = (String)session.getAttribute("adm_last");
			String username = (String)session.getAttribute("adm_username");
			String password = (String)session.getAttribute("adm_password");
			int adm_type = (Integer)session.getAttribute("adm_type");
			String email = (String)session.getAttribute("adm_email");
			
			Admin admin = new Admin(adm_id, firstName, lastName, username, password, email, adm_type);
			List<Ticket> ticketList;
			
			try {
				AdminDAO dao =  AdminDAOFactory.getAdminDAO();
				ticketList = dao.viewTickets();
				
				out.print("<br>");
				out.print("<h5 class='text-center'> Welcome "+firstName+" "+lastName+"</h5>");
	        	
				Iterator<Ticket> listIterator = ticketList.iterator();
		        while (listIterator.hasNext()) {
		        	Ticket ticket = listIterator.next();
		        	int ticket_id = ticket.getTicket_id();
		        	Employee employee2 = ticket.getEmployee();
		        	String description = ticket.getDescription();
		        	double amount = ticket.getAmount();
		        	String status = ticket.getStatus();
		        	String timestamp = ticket.getTs();
		        	String type = ticket.getType();
		        	
		        	session.setAttribute("ticket_id", ticket_id);
		        	session.setAttribute("ticket_employee", employee2);
		        	session.setAttribute("description", description);
		        	session.setAttribute("amount", amount);
		        	session.setAttribute("timestamp", timestamp);
		        	session.setAttribute("ticket_type", type);
		        	
		        	out.print("<table class='table table-bordered'><thead><tr>");
		        	out.print("<th>Ticket Id</th>");
		        	out.print("<th>Type</th>");
		        	out.print("<th>Description</th>");
		        	out.print("<th>Amount</th>");
		        	out.print("<th>Timestamp</th>");
		        	out.print("<th>Current Status</th>");
		        	out.print("<th>Update Status</th>");
		        	out.print("</tr></thead>");
		        	out.print("<tbody><tr>");
		        	out.print("<td>"+ticket_id+"</td>");
		        	out.print("<td>"+type+"</td>");
		        	out.print("<td>"+description+"</td>");
		        	out.print("<td>"+amount+"</td>");
		        	out.print("<td>"+timestamp+"</td>");
		        	out.print("<td>"+status+"</td>");
		        	out.print("<td> <form action='UpdateTicket' method='post' name='status'>"
		        			+ "                <select name='status' class= 'form-field'>"
		        			+ "                  <option value='pending'>pending</option>"
		        			+ " 				 <option value='rejected'>rejected</option>"
		        			+ "                  <option value='approved'>approved</option>"
		        			+ "                </select>"
		        			+" "
		        			+ " </form></td>");
		    		out.print("</tr></tbody></table>");
		        }
			
				}catch(Exception e) {
				e.printStackTrace();
					}	
				}		
		}
}
