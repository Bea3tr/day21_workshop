package paf.day21_workshop.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day21_workshop.model.Customer;
import paf.day21_workshop.utils.sql;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(int limit, int offset) {
        List<Customer> customers = new LinkedList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.getAllCustomers, limit, offset);
        while(sqlRowSet.next()) {
            Customer cust = new Customer(sqlRowSet.getInt("id"), sqlRowSet.getString("fullname"), 
                sqlRowSet.getString("email"));
            customers.add(cust);
        }
        return customers;
    }

    // Auto mapping - for reference
    public List<Customer> getCustomersAuto() {
        List<Customer> customers = new LinkedList<>();
        customers = template.query(sql.getAllCustomersAuto, BeanPropertyRowMapper.newInstance(Customer.class));
        return customers;
    }
    
}
