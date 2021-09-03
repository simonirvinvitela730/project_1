package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
				
				Session session = FactoryProvider.getFactory().openSession();
				Transaction transaction = session.beginTransaction();
				//session.save(employee);
				transaction.commit();
				
				//Employee employee1 = session.get(Employee.class, emp_Id);
				
				EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
				Employee employee = dao.getEmployeeByLogin(username, password);
				AdminDAO dao2 = AdminDAOFactory.getAdminDAO();
				Admin admin = dao2.getAdminByLogin(username, password);
				
				if(username.equals(employee.getUsername()) && password.equals(employee.getPassword()) && (employee.getType() == 0)) {
					RequestDispatcher rd = request.getRequestDispatcher("/employee.html");
					rd.forward(request, response);
				}else if(username.equals(admin.getUsername()) && password.equals(admin.getPassword()) && (admin.getType() == 1)) {
					RequestDispatcher rd = request.getRequestDispatcher("/admin.html");
					rd.forward(request, response);
				}else {
					out.println("Sorry invalid username and password");
					RequestDispatcher rd = request.getRequestDispatcher("/login.html");
					rd.include(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
}