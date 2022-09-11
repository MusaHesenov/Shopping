package repository.inter;

import entity.Customer;
import entity.OrderShopping;

import java.util.List;

public interface OrderedInter {
    public void insert(OrderShopping orderShopping);
    public List<OrderShopping> findByCustomerId(Customer customer);
    public OrderShopping findById(Integer id);
}
