package paf.day21_workshop.model;

import java.sql.Date;

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String job_title;
    private String department;
    private Date employment_date;
    private float salary;
    private boolean active;
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    
    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public String getJob_title() {return job_title;}
    public void setJob_title(String job_title) {this.job_title = job_title;}
    
    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}
    
    public Date getEmployment_date() {return employment_date;}
    public void setEmployment_date(Date employment_date) {this.employment_date = employment_date;}
    
    public float getSalary() {return salary;}
    public void setSalary(float salary) {this.salary = salary;}

    public boolean isActive() {return active;}
    public void setActive(boolean active) {this.active = active;}

    public Employee() {}
    public Employee(int id, String first_name, String last_name, String email, String job_title, String department,
            Date employment_date, float salary, boolean active) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.job_title = job_title;
        this.department = department;
        this.employment_date = employment_date;
        this.salary = salary;
        this.active = active;
    }
    
}
