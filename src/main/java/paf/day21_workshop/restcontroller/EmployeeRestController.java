package paf.day21_workshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import paf.day21_workshop.model.Employee;
import paf.day21_workshop.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeSvc;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeSvc.getAllEmployees(10, 0);
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Employee c = employeeSvc.getEmployeeById(id);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(employeeSvc.deleteEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEmployeeById(@PathVariable Integer id,
        @RequestBody Employee employee) {
        
        return ResponseEntity.ok().body(employeeSvc.updateEmployeeById(employee, id));
    }

    @PostMapping
    public ResponseEntity<Boolean> insertNewEmployee(@RequestBody Employee employee) {
        boolean employeeCreated = employeeSvc.insertNewEmployee(employee);
        return ResponseEntity.ok().body(employeeCreated);
    }

}