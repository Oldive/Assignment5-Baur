package kz.iitu.springdatademo.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import kz.iitu.springdatademo.repository.CustomerRepository;
import kz.iitu.springdatademo.entity.Customer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  private CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public void createCustomer(Customer customer){

    String hashPin = hash(customer.getPin());
    customer.setPin(hashPin);
    repository.save(customer);
  }

  private String hash(String pin) {
    String salt = BCrypt.gensalt(12);
    return BCrypt.hashpw(pin, salt);
  }

  public List<Customer> getCustomer(){
    return repository.findAll();
  }

  public Customer findCustomer(int id) {
    try {
      return repository.findById(id).get();
    } catch (NoSuchElementException e) {
      return null;
    }
  }


  public Customer checkPin(Customer inputCustomer) {

    Customer storedCustomer = findCustomer(inputCustomer.getId());


    if (storedCustomer != null) {
      String hashPin = storedCustomer.getPin();
      if (BCrypt.checkpw(inputCustomer.getPin(), hashPin))
        return storedCustomer;
    }
    return null;
  }

}