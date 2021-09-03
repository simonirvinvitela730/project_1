package com.simonirvinvitela;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = (Session)sf.openSession();
        
       
        //HQL Query Syntax
        String hql = "from Employee where username = :n and password = :g";
        Query query = session.createQuery(hql);
        query.setParameter("n", "Username");
        query.setParameter("g", "Password");
        
        List<Employee> employeesList = query.list();
        System.out.println(employeesList);
        
        //create employee
       Employee employee = new Employee();
       employee.setFirstName("Fred");
       employee.setLastName("Flanders");
       employee.setEmail("fred@gmail.com");
       employee.setUsername("fred1");
       employee.setPassword("goodpassword");
       
       Ticket ticket = new Ticket();
       ticket.setAmount(123.23);
       ticket.setStatus("pending");
       ticket.setDescription("Went shopping");
       ticket.setType("Lodging");
       
       Ticket ticket2 = new Ticket();
       ticket2.setAmount(123.23);
       ticket2.setStatus("pending");
       ticket2.setDescription("Went shopping");
       ticket2.setType("Lodging");
       
       List<Ticket> tickets = new ArrayList<>();
       tickets.add(ticket);
       tickets.add(ticket2);
       
       employee.setTickets(tickets);
       
     //begin transaction
       Transaction t = session.beginTransaction();
       
       session.save(employee);
       session.save(ticket);
       session.save(ticket2);
        
        //commit the transaction
        t.commit();
        
       //close the session
        
        session.close();
        sf.close();
        
        
       /* System.out.println(sf);
        System.out.println(sf.isClosed());*/
    }
}
