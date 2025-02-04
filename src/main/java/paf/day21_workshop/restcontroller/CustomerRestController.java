package paf.day21_workshop.restcontroller;

import java.util.List;
import java.util.Optional;

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

import paf.day21_workshop.model.Customer;
import paf.day21_workshop.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService custSvc;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = custSvc.getAllCustomers(10, 0);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/auto")
    public ResponseEntity<List<Customer>> getAllCustomersAuto() {
        List<Customer> customers = custSvc.getAllCustomersAuto();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/opt/{id}")
    public ResponseEntity<Customer> getCustomerByIdOpt(@PathVariable Integer id) {
        Optional<Customer> opt = custSvc.getCustomerByIdOpt(id);
        if(opt.isEmpty())
            return ResponseEntity.status(404).body(new Customer());
        return ResponseEntity.ok().body(opt.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer c = custSvc.getCustomerById(id);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(custSvc.deleteCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateCustomerById(@PathVariable Integer id,
        @RequestBody Customer customer) {
        
        // Check existing customer
        // Customer c = custSvc.getCustomerById(id);
        // boolean customerUpdated = false;
        // if(c != null)
        //     customerUpdated = custSvc.updateCustomerById(customer, id);
        return ResponseEntity.ok().body(custSvc.updateCustomerById(customer, id));
    }

    @PostMapping
    public ResponseEntity<Boolean> insertNewCustomer(@RequestBody Customer customer) {
        boolean customerCreated = custSvc.insertNewCustomer(customer);
        return ResponseEntity.ok().body(customerCreated);
    }

}