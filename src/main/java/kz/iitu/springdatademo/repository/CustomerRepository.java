package kz.iitu.springdatademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kz.iitu.springdatademo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    }