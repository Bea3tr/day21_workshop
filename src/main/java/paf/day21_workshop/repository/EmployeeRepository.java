package paf.day21_workshop.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day21_workshop.model.Employee;
import paf.day21_workshop.model.exception.ResourceNotFoundException;
import paf.day21_workshop.utils.sql;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Employee> getEmployees(int limit, int offset) {
        List<Employee> employees = new LinkedList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.getAllEmployees);
        while(sqlRowSet.next()) {
            Employee employee = new Employee(sqlRowSet.getInt("id"), 
                sqlRowSet.getString("first_name"), sqlRowSet.getString("last_name"), 
                sqlRowSet.getString("email"), sqlRowSet.getString("job_title"), 
                sqlRowSet.getString("department"), sqlRowSet.getDate("employment_date"),
                sqlRowSet.getFloat("salary"), sqlRowSet.getBoolean("active"));
            employees.add(employee);
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee e = null;
        try {
            e = template.queryForObject(sql.getEmployeeById, 
                BeanPropertyRowMapper.newInstance(Employee.class), id);
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }
        return e;
    }

    public boolean deleteEmployeeById(int id) {
        int employeeDeleted = template.update(sql.deleteEmployeeById, id);
        if(employeeDeleted > 0)
            return true;
        return false;
    }

    public boolean updateEmployeeById(Employee employee, int id) {
        int employeeUpdated = template.update(sql.updateEmployeeById, employee.getFirst_name(), 
            employee.getLast_name(), employee.getEmail(), employee.getJob_title(), employee.getDepartment(), 
            employee.getEmployment_date(), employee.getSalary(), employee.isActive(), id);
        if(employeeUpdated > 0)
            return true;
        return false;
    }

    public boolean insertNewEmployee(Employee employee) {
        int employeeCreated = template.update(sql.insertEmployee, employee.getFirst_name(), 
            employee.getLast_name(), employee.getEmail(), employee.getJob_title(), employee.getDepartment(), 
            employee.getEmployment_date(), employee.getSalary(), employee.isActive());
        if(employeeCreated > 0) {
            return true;
        }
        return false;
    }
    
}
