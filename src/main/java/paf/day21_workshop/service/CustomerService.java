package paf.day21_workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import paf.day21_workshop.model.Customer;
import paf.day21_workshop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired 
    private CustomerRepository custRepo;

    public List<Customer> getAllCustomers(int limit, int offset) {
        return custRepo.getCustomers(limit, offset);
    }

    public Optional<Customer> getCustomerById(int id) {
        SqlRowSet rs = custRepo.getCustomerById(id);
        if(rs.first()) {
            return Optional.of(new Customer(rs.getInt("id"), 
                rs.getString("fullname"), rs.getString("email")));
        }
        return Optional.empty();
    }
    
}
