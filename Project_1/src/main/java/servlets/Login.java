package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.simonirvinvitela.*;
import dao.*;

public class Login extends HttpServlet{

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter(); 
			
			try {
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String checkbox = request.getParameter("check");
				
				EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
				List<Employee> employee = dao.getEmployeeByLogin(username, password);
				AdminDAO dao2 = AdminDAOFactory.getAdminDAO();
				List<Admin> admin = dao2.getAdminByLogin(username, password);
				
				if(!(employee.isEmpty())) {
					
					Iterator<Employee> listIterator = employee.iterator();
			        while (listIterator.hasNext()) {
			        	HttpSession session = request.getSession();
			        	Employee employee1 = listIterator.next();
			        	session.setAttribute("emp_id", employee1.getEmp_id());
			        	session.setAttribute("emp_username", employee1.getUsername());
			        	session.setAttribute("emp_password", employee1.getPassword());
			        	session.setAttribute("emp_first", employee1.getFirstName());
			        	session.setAttribute("emp_last", employee1.getLastName());
			        	session.setAttribute("emp_email", employee1.getEmail());
			        	session.setAttribute("emp_type", employee1.getType());	
			        	session.setAttribute("emp_ticket", employee1.getTickets());
			        	
			        	RequestDispatcher rd = request.getRequestDispatcher("/employee.html");
						rd.include(request, response);
						
			        	RequestDispatcher rd2 = request.getRequestDispatcher("EmployeeServlet");
						rd2.include(request, response);
						
						RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
						rd3.include(request, response);
						
			        }
					
					
					
				}else if(!(admin.isEmpty())) {
					
					Iterator<Admin> listIterator = admin.iterator();
			        while (listIterator.hasNext()) {
			        	HttpSession session = request.getSession();
			        	Admin admin1 = listIterator.next();
			        	session.setAttribute("adm_id", admin1.getAdm_id());
			        	session.setAttribute("adm_username", admin1.getUsername());
			        	session.setAttribute("adm_password", admin1.getPassword());
			        	session.setAttribute("adm_first", admin1.getFirstName());
			        	session.setAttribute("adm_last", admin1.getLastName());
			        	session.setAttribute("adm_email", admin1.getEmail());
			        	session.setAttribute("adm_type", admin1.getType());	
			        	
			        	RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
						rd.include(request, response);
						
						RequestDispatcher rd2 = request.getRequestDispatcher("AdminServlet");
						rd2.include(request, response);
						
						RequestDispatcher rd4 = request.getRequestDispatcher("/button.html");
						rd4.include(request, response);
						
						RequestDispatcher rd3 = request.getRequestDispatcher("/logout.html");
						rd3.include(request, response);
			        }
					
				}else if(employee.isEmpty() || admin.isEmpty()){
					out.println("Sorry invalid username and password");
					RequestDispatcher rd = request.getRequestDispatcher("/login.html");
					rd.include(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
}