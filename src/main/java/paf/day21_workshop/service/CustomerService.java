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

    public List<Customer> getAllCustomersAuto() {
        return custRepo.getCustomersAuto();
    }

    public Optional<Customer> getCustomerByIdOpt(int id) {
        SqlRowSet rs = custRepo.getCustomerByIdOpt(id);
        if(rs.first()) {
            return Optional.of(new Customer(rs.getInt("id"), 
                rs.getString("fullname"), rs.getString("email")));
        }
        return Optional.empty();
    }

    public Customer getCustomerById(int id) {
        return custRepo.getCustomerById(id);
    }

    public boolean deleteCustomerById(int id) {
        return custRepo.deleteCustomerById(id);
    }

    public boolean updateCustomerById(Customer customer, int id) {
        return custRepo.updateCustomerById(customer, id);
    }

    public boolean insertNewCustomer(Customer customer) {
        return custRepo.insertNewCustomer(customer);
    }

    
}
