package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

public class Filter extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		HttpSession session = request.getSession(false);
			
		if(session != null) {
			String status = request.getParameter("status");
			List<Ticket> ticketList = new ArrayList<>();
		try {
			if(status.equals("all")) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
				rd.include(request, response);
				
				RequestDispatcher rd4 = request.getRequestDispatcher("/form.html");
				rd4.include(request, response);
				
				RequestDispatcher rd2 = request.getRequestDispatcher("AdminServlet");
				rd2.include(request, response);
				
				RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
				rd3.include(request, response);
			}else if(status.equals("approved")) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
				rd.include(request, response);
				
				RequestDispatcher rd4 = request.getRequestDispatcher("/form.html");
				rd4.include(request, response);
				
				AdminDAO dao =  AdminDAOFactory.getAdminDAO();
				ticketList = dao.viewApproved();
		        	
		        for(Ticket t: ticketList) {
		        	int ticket_id = t.getTicket_id();
		        	Employee employee = t.getEmployee();
		        	String description = t.getDescription();
		        	double amount = t.getAmount();
		        	String status2 = t.getStatus();
		        	String timestamp = t.getTs();
		        	String type = t.getType();
		        	
		        	int emp_id = employee.getEmp_id();
		        	String emp_firstName = employee.getFirstName();
		        	String emp_lastName = employee.getLastName();
			        	
		        	out.print("<table class='table table-bordered'><thead><tr>");
		        	out.print("<th>Employee Id</th>");
		        	out.print("<th>Employee Name</th>");
		        	out.print("<th>Ticket Id</th>");
		        	out.print("<th>Type</th>");
		        	out.print("<th>Description</th>");
		        	out.print("<th>Amount</th>");
		        	out.print("<th>Timestamp</th>");
		        	out.print("<th>Current Status</th>");
		        	out.print("<th>Update Status</th>");
		        	out.print("</tr></thead>");
		        	out.print("<tbody><tr>");
		        	out.print("<td>"+emp_id+"</td>");
		        	out.print("<td>"+emp_firstName+" "+emp_lastName+"</td>");
		        	out.print("<td>"+ticket_id+"</td>");
		        	out.print("<td>"+type+"</td>");
		        	out.print("<td>"+description+"</td>");
		        	out.print("<td>"+amount+"</td>");
		        	out.print("<td>"+timestamp+"</td>");
		        	out.print("<td>"+status2+"</td>");
		        	out.print("<td>");
		        	out.print("<form action='Approve' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Approve\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reject' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reject\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reset' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reset\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("</td>");
		    		out.print("</tr></tbody></table>");
		    		
		    		RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
					rd3.include(request, response);
		        }
			}else if(status.equals("rejected")) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
				rd.include(request, response);
				
				RequestDispatcher rd4 = request.getRequestDispatcher("/form.html");
				rd4.include(request, response);
				
				AdminDAO dao =  AdminDAOFactory.getAdminDAO();
				ticketList = dao.viewRejected();
		        	
		        for(Ticket t: ticketList) {
		        	int ticket_id = t.getTicket_id();
		        	Employee employee = t.getEmployee();
		        	String description = t.getDescription();
		        	double amount = t.getAmount();
		        	String status2 = t.getStatus();
		        	String timestamp = t.getTs();
		        	String type = t.getType();
		        	
		        	int emp_id = employee.getEmp_id();
		        	String emp_firstName = employee.getFirstName();
		        	String emp_lastName = employee.getLastName();
			        	
		        	out.print("<table class='table table-bordered'><thead><tr>");
		        	out.print("<th>Employee Id</th>");
		        	out.print("<th>Employee Name</th>");
		        	out.print("<th>Ticket Id</th>");
		        	out.print("<th>Type</th>");
		        	out.print("<th>Description</th>");
		        	out.print("<th>Amount</th>");
		        	out.print("<th>Timestamp</th>");
		        	out.print("<th>Current Status</th>");
		        	out.print("<th>Update Status</th>");
		        	out.print("</tr></thead>");
		        	out.print("<tbody><tr>");
		        	out.print("<td>"+emp_id+"</td>");
		        	out.print("<td>"+emp_firstName+" "+emp_lastName+"</td>");
		        	out.print("<td>"+ticket_id+"</td>");
		        	out.print("<td>"+type+"</td>");
		        	out.print("<td>"+description+"</td>");
		        	out.print("<td>"+amount+"</td>");
		        	out.print("<td>"+timestamp+"</td>");
		        	out.print("<td>"+status2+"</td>");
		        	out.print("<td>");
		        	out.print("<form action='Approve' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Approve\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reject' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reject\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reset' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reset\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("</td>");
		    		out.print("</tr></tbody></table>");
		    		
		    		RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
					rd3.include(request, response);
		        }
			}else if(status.equals("pending")) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
				rd.include(request, response);
				
				RequestDispatcher rd4 = request.getRequestDispatcher("/form.html");
				rd4.include(request, response);
				
				AdminDAO dao =  AdminDAOFactory.getAdminDAO();
				ticketList = dao.viewPending();
		        	
		        for(Ticket t: ticketList) {
		        	int ticket_id = t.getTicket_id();
		        	Employee employee = t.getEmployee();
		        	String description = t.getDescription();
		        	double amount = t.getAmount();
		        	String status2 = t.getStatus();
		        	String timestamp = t.getTs();
		        	String type = t.getType();
		        	
		        	int emp_id = employee.getEmp_id();
		        	String emp_firstName = employee.getFirstName();
		        	String emp_lastName = employee.getLastName();
			        	
		        	out.print("<table class='table table-bordered'><thead><tr>");
		        	out.print("<th>Employee Id</th>");
		        	out.print("<th>Employee Name</th>");
		        	out.print("<th>Ticket Id</th>");
		        	out.print("<th>Type</th>");
		        	out.print("<th>Description</th>");
		        	out.print("<th>Amount</th>");
		        	out.print("<th>Timestamp</th>");
		        	out.print("<th>Current Status</th>");
		        	out.print("<th>Update Status</th>");
		        	out.print("</tr></thead>");
		        	out.print("<tbody><tr>");
		        	out.print("<td>"+emp_id+"</td>");
		        	out.print("<td>"+emp_firstName+" "+emp_lastName+"</td>");
		        	out.print("<td>"+ticket_id+"</td>");
		        	out.print("<td>"+type+"</td>");
		        	out.print("<td>"+description+"</td>");
		        	out.print("<td>"+amount+"</td>");
		        	out.print("<td>"+timestamp+"</td>");
		        	out.print("<td>"+status2+"</td>");
		        	out.print("<td>");
		        	out.print("<form action='Approve' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Approve\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reject' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reject\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("<form action='Reset' method='post'>\r\n"
		        			+ "		<input type=\"submit\" value=\"Reset\" class=\"btn btn-outline-primary btn-block\">\r\n"
		        			+" <input type = 'hidden' name='id' value ='"+ticket_id+"'>"
		        			+ "	</form>");
		        	out.print("</td>");
		    		out.print("</tr></tbody></table>");
		    		
		    		RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
					rd3.include(request, response);
		        }
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			}
			
			
		}
		else {
			out.print("<p>login first to use this functionality</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);		
		}
	}
}