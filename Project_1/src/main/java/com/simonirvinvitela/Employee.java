package com.simonirvinvitela;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int emp_id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private int type;
	
//	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
//    Set ticket = new HashSet();
//	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="emp_id")
//	private Set<Ticket> tickets;
	
	@OneToMany
	private List<Ticket> tickets;

	public Employee() {}
	
	
	
	public Employee(int emp_id, List<Ticket> tickets, String firstName, String lastName, String username,
			String password, String email, int type) {
		this.emp_id = emp_id;
		this.tickets = tickets;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}



	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public List<Ticket> getTickets() {
		return tickets;
	}



	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}



	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", type=" + type + ", tickets=" + tickets
				+ "]";
	}

	
	
	
}