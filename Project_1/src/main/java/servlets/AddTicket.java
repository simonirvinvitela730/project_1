package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.simonirvinvitela.*;

import dao.EmployeeDAO;
import dao.EmployeeDAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddTicket extends HttpServlet{
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
				String timestamp = request.getParameter("timestamp");
				String type = request.getParameter("type");
				String description = request.getParameter("desc");
				double amount = Double.parseDouble(request.getParameter("amount"));
			
			
				EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
				Ticket ticket = dao.addReimbursement(amount, type, description, employee, timestamp);
				
				List<Ticket> ticketList = dao.viewTicket(emp_id);
			    ticketList.add(ticket);
			    Employee newEmployee = dao.employeeById(emp_id);
			       
			    dao.updateEmployee(emp_id, ticketList, newEmployee.getFirstName(), newEmployee.getLastName(), 
			    		newEmployee.getUsername(), newEmployee.getPassword(), newEmployee.getEmail(), newEmployee.getType());
			       
				
				RequestDispatcher rd = request.getRequestDispatcher("/employee.html");
				rd.include(request, response);
				
	        	RequestDispatcher rd2 = request.getRequestDispatcher("EmployeeServlet");
				rd2.include(request, response);
				
				RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
				rd3.include(request, response);
			
				}catch(Exception e) {
				e.printStackTrace();
					}	
				}		
		}
}
