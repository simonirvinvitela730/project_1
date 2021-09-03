package dao;

public class EmployeeDAOFactory {
	
	private static EmployeeDAO dao;
	
	private EmployeeDAOFactory() {}
	
	public static EmployeeDAO getEmployeeDAO() throws ClassNotFoundException {
		if(dao == null)
			dao = new EmployeeDAOImpl();
		return dao;
	}
}