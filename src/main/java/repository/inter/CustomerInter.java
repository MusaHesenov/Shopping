package repository.inter;

import entity.City;
import entity.Customer;
import entity.TypeShop;
import exception.ExceptionCustomerNotFound;

import java.util.List;

public interface CustomerInter {
    public void insert(Customer customer);

    public Customer findById(Integer id);

    public Customer findByUserName(String name) throws ExceptionCustomerNotFound;

    public List<Customer> findByCity(City city);

    public void update(Customer customer);

}
