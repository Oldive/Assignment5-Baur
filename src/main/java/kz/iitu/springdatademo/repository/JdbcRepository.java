package kz.iitu.springdatademo.repository;

import java.util.List;
import kz.iitu.springdatademo.entity.Customer;

public interface JdbcRepository {

    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void update(int id, Customer customer);
    void deleteById(int id);

}