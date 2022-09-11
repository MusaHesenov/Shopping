package service.impl;

import entity.Customer;
import repository.impl.CustomerImpl;
import repository.inter.CustomerInter;
import service.inter.CustomerServiceInter;

public class CustomerServiceImpl implements CustomerServiceInter {
    private CustomerInter customerInter = new CustomerImpl();

    @Override
    public void registration(Customer customer) {
        customerInter.insert(customer);

    }
}
