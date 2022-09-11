package repository.inter;

import entity.City;
import entity.Customer;
import entity.Product;
import entity.TypeShop;

import java.util.List;

public interface ProductInter {

    public void insert(Product product);

    public Product findByid(Integer id);

    public Product findByName(String name);

    public List<Product> findAll();

    public List<Product> findTypeShop(TypeShop typeShop);

    public void update(Product product);

    public void delete(Integer id);

}
