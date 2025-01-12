package paf.day21_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day21_workshop.model.Employee;
import paf.day21_workshop.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired 
    private EmployeeRepository employeeRepo;

    public List<Employee> getAllEmployees(int limit, int offset) {
        return employeeRepo.getEmployees(limit, offset);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.getEmployeeById(id);
    }

    public boolean deleteEmployeeById(int id) {
        return employeeRepo.deleteEmployeeById(id);
    }

    public boolean updateEmployeeById(Employee Employee, int id) {
        return employeeRepo.updateEmployeeById(Employee, id);
    }

    public boolean insertNewEmployee(Employee Employee) {
        return employeeRepo.insertNewEmployee(Employee);
    }

    
}
