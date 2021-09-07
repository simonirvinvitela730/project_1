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
        
        
        //create employee
       Employee employee = new Employee();
       employee.setFirstName("Kid");
       employee.setLastName("Cudi");
       employee.setEmail("kcudi@gmail.com");
       employee.setUsername("manonthemoon");
       employee.setPassword("password");
       employee.setType(0);
       
       Employee employee2 = new Employee();
       employee2.setFirstName("Steve");
       employee2.setLastName("Martin");
       employee2.setEmail("smartin@gmail.com");
       employee2.setUsername("smartin1");
       employee2.setPassword("password");
       employee2.setType(0);
       
//       Admin admin = new Admin();
//       admin.setFirstName("Trisha");
//       admin.setLastName("Folds");
//       admin.setEmail("trish@gmail.com");
//       admin.setUsername("trisha1");
//       admin.setPassword("bestpassword");
//       admin.setType(1);
       
//       Ticket ticket = new Ticket();
//       ticket.setAmount(123.23);
//       ticket.setStatus("pending");
//       ticket.setDescription("Went shopping");
//       ticket.setType("Lodging");
//       
//       Ticket ticket2 = new Ticket();
//       ticket2.setAmount(123.23);
//       ticket2.setStatus("pending");
//       ticket2.setDescription("Went shopping");
//       ticket2.setType("Lodging");
//       
//       List<Ticket> tickets = new ArrayList<>();
//       tickets.add(ticket);
//       tickets.add(ticket2);
//       
//       employee.setTickets(tickets);
//       ticket.setEmployee(employee);
//       ticket2.setEmployee(employee);
       
       
     //begin transaction
       Transaction t = session.beginTransaction();
       
//       session.save(employee);
//       session.save(ticket);
//       session.save(ticket2);
//       session.save(employee);
        session.save(employee);
        session.save(employee2);
        //commit the transaction
        t.commit();
        
       //close the session
        
        session.close();
        sf.close();
        
        
       /* System.out.println(sf);
        System.out.println(sf.isClosed());*/
    }
}
