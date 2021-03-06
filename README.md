# Project_1: DONDA Reimbursement Portal
## Project Description
This project is an employee reimbursement portal which allows employees to submit reimbursement requests. There is a login page which upon logging in you will be redirected to either the employee portal or the admin portal based on the login credentials.

## Technologies Used
<h3>Front-end</h3>
 <ul>
  <li> HTML</li>
  <li> CSS </li>
  <li> Javascript </li>
  <li> Bootstrap </li>
 </ul>
<h3>Back-end</h3>
 <ul>
  <li> Java 16</li>
  <li> Servlets (Http Servlet)</li>
  <li> Hibernate</li>
 </ul>
 <h3> Database </h3>
  <ul>
   <li> MySQL </li>
  </ul>
 <h3> Version Control </h3>
  <ul>
   <li> Git </li>
   <li> Github </li>
  </ul>

## Features
<h3> Employee Portal </h3>
<ul>
  <li> Shared Login - shared login between employee portal and admin portal which differentiates user credentials and redirects to the appropriate page</li>
  <li> View reimbursement requests submitted (tied to the individual employee) </li>
  <li> Submit new reimbursement requests </li>
  <li> Updates view of reimbursement requests upon submission</li>
  <li> Logout - returns user to login page and invalidates the HTTP Session</li>
 </ul>
<h3> Admin Portal </h3>
<ul>
  <li> Shared Login - shared login between admin portal and employee portal which differentiates user credentials and redirects to the appropriate page</li>
  <li> View all pass reimbursement requests </li>
  <li> Change reimbursement request status </li>
  <li> Filter reimbursement requests based on status</li>
  <li> Logout - returns user to login page and invalidates the HTTP Session</li>
 </ul>
 
## Getting Started
<ol>
 <li> First in MySQL create a database by the name of project_1 and update the hibernate.cfg.xml file to include your credentials for your database.</li>
 <li> Next, in src/main/java/com.simonirvinvitela start by running App.java which will be used to create 2 employees and 1 admin users using hibernate. </li>
 <li> Following this, you're going to want to run the server and go to http://localhost:8080/Project_1 </li>
 <li> You should then be able to log in as either an employee or admin with the following credentials</li>
</ol>
 
 <h3>Employee Logins</h3>
 <ul>
 <li> username: manonthemoon password:password </li>
 <li> username: smartin1 password: password </li>
 </ul>
 
 <h3>Admin Logins</h3>
 <ul>
 <li> username: trisha1 password: bestpassword </li>
 </ul>
 
## Usage
<h3> Login Page </h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Employee_Login.png?raw=true)

<br>

<h3> Employee Portal </h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Employee_Portal.png?raw=true)

<br>

<h3> Employee Reimbursement Form </h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Employee_Reimbursement_Form.png?raw=true)

<br>

<h3> Updated Employee Tickets </h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Updated_Employee_Portal.png?raw=true)

<br>

<h3> Admin Portal </h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Admin_Portal.png?raw=true)

<br>

<h3> Admin Ticket Status Change</h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Updated_Admin_Portal.png?raw=true)

<br>

<h3> Admin Status Filtering ("rejected")</h3>

![alt text](https://github.com/simonirvinvitela730/project_1/blob/main/images/Admin_Filtering.png?raw=true)

<br>

## Contributors
 <ul>
  <li> Simon Irvin-Vitela </li>
  <li> Jaydan Jacobs </li>
 </ul>
  
