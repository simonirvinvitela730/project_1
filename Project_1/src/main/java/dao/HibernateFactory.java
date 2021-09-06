package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	public static SessionFactory factory;
	
	public static SessionFactory getFactory() throws HibernateException {
		if(factory==null) {
			Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        factory = cfg.buildSessionFactory();
		}
		return factory;
	}
}