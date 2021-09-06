package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.simonirvinvitela.Employee;
import com.simonirvinvitela.Ticket;

import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
			
		if(session != null) {
			int emp_id = (Integer)session.getAttribute("emp_id");
			String firstName = (String)session.getAttribute("emp_first");
			String lastName = (String)session.getAttribute("emp_last");
			String username = (String)session.getAttribute("emp_username");
			String password = (String)session.getAttribute("emp_password");
			int emp_type = (Integer)session.getAttribute("emp_type");
			String email = (String)session.getAttribute("emp_email");
			List<Ticket> tickets = (List<Ticket>)session.getAttribute("emp_ticket");
			
			Employee employee = new Employee(emp_id, tickets, firstName, lastName, username,
			password, email, emp_type);
			
			try {
				EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
				List<Ticket> ticketList = dao.viewTicket(emp_id);
				
				out.print("<br>");
				out.print("<h5 class='text-center'> Employee "+firstName+" "+lastName+"</h5>");
	        	
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
		        	
		        	out.print("<table class='table table-bordered'><thead><tr>");
		        	out.print("<th>Ticket Id</th>");
		        	out.print("<th>Type</th>");
		        	out.print("<th>Description</th>");
		        	out.print("<th>Amount</th>");
		        	out.print("<th>Timestamp</th>");
		        	out.print("<th>Status</th>");
		        	out.print("</tr></thead>");
		        	out.print("<tbody><tr>");
		        	out.print("<td>"+ticket_id+"</td>");
		        	out.print("<td>"+type+"</td>");
		        	out.print("<td>"+description+"</td>");
		        	out.print("<td>"+amount+"</td>");
		        	out.print("<td>"+timestamp+"</td>");
		        	out.print("<td>"+status+"</td>");
		    		out.print("</tr></tbody></table>");
		        }
			
				}catch(Exception e) {
				e.printStackTrace();
					}	
				}		
		}
}