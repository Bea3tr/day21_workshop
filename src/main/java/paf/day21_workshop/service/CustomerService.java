package paf.day21_workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
