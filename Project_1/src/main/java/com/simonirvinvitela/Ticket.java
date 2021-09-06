package com.simonirvinvitela;

import java.sql.Timestamp;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue
	private int ticket_id;
	
//	@JoinColumn(name = "FK_emp_id")
//	@ManyToOne
//	private Employee employee;
	
	@ManyToOne
	private Employee employee;
	
	private String status;
	private String type;
	private double amount;
	private String description;
	private String ts;
	
	public Ticket(){}

	public Ticket(int ticket_id, Employee employee, String status, String type, double amount, String description,
			String ts) {
		this.ticket_id = new Random().nextInt(10000);
		this.employee = employee;
		this.status = status;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.ts = ts;
	}



	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}