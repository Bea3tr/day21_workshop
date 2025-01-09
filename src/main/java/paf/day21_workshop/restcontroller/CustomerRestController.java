package paf.day21_workshop.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> opt = custSvc.getCustomerById(id);
        if(opt.isEmpty())
            return ResponseEntity.status(404).body(new Customer());
        return ResponseEntity.ok().body(opt.get());
    }

}