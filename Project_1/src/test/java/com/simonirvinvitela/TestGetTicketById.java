package com.simonirvinvitela;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.*;

import dao.*;

class TestGetTicketById {
	
	@Test
	void testTicketById() throws SQLException, ClassNotFoundException {
			AdminDAO dao;
			dao = AdminDAOFactory.getAdminDAO();
			int ticket_id = 13;
			Ticket ticket = dao.getTicketById(ticket_id);
			
			assertEquals(ticket.getTicket_id(), 13);
			assertEquals(ticket.getStatus(), "approved");
			assertEquals(ticket.getAmount(), 172.36);
			assertEquals(ticket.getDescription(), "Trip to Rome.");
			assertEquals(ticket.getTs(), "6-9-2021 1:55:20");
			assertEquals(ticket.getType(), "travel");
			
			
			System.out.println("Account: "+ticket_id+" tested...");
	}

}
