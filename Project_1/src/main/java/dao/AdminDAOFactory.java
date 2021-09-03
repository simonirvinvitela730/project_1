package dao;

public class AdminDAOFactory {
	
private static AdminDAO dao;
	
	private AdminDAOFactory() {}
	
	public static AdminDAO getAdminDAO() throws ClassNotFoundException {
		if(dao == null)
			dao = new AdminDAOImpl();
		return dao;
	}
}
