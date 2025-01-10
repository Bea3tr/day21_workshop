package paf.day21_workshop.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day21_workshop.model.Customer;
import paf.day21_workshop.model.exception.ResourceNotFoundException;
import paf.day21_workshop.utils.sql;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(int limit, int offset) {
        List<Customer> customers = new LinkedList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.getAllCustomers, limit, offset);
        while(sqlRowSet.next()) {
            Customer cust = new Customer(sqlRowSet.getInt("id"), 
                sqlRowSet.getString("fullname"), sqlRowSet.getString("email"));
            customers.add(cust);
        }
        return customers;
    }

    // Auto mapping - for reference
    public List<Customer> getCustomersAuto() {
        List<Customer> customers = new LinkedList<>();
        customers = template.query(sql.getAllCustomersAuto, 
            BeanPropertyRowMapper.newInstance(Customer.class));
        if(customers.isEmpty())
            throw new ResourceNotFoundException("No record in Customer table");
        return customers;
    }

    public SqlRowSet getCustomerByIdOpt(int id) {
        return template.queryForRowSet(sql.getCustomerById, id);
    }

    public Customer getCustomerById(int id) {
        Customer c = null;
        try {
            c = template.queryForObject(sql.getCustomerById, 
                BeanPropertyRowMapper.newInstance(Customer.class), id);
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException("Customer with id " + id + " not found");
        }
        return c;
    }

    public boolean deleteCustomerById(int id) {
        int customerDeleted = template.update(sql.deleteCustomerById, id);
        if(customerDeleted > 0)
            return true;
        return false;
    }

    public boolean updateCustomerById(Customer customer, int id) {
        int customerUpdated = template.update(sql.updateCustomerById, customer.getFullName(), 
            customer.getEmail(), id);
        if(customerUpdated > 0)
            return true;
        return false;
    }

    public boolean insertNewCustomer(Customer customer) {
        int customerCreated = template.update(sql.insertCustomer, customer.getFullName(), customer.getEmail());
        if(customerCreated > 0) {
            return true;
        }
        return false;
    }
    
}
