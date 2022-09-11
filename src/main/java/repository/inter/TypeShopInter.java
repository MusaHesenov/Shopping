package repository.inter;

import entity.City;
import entity.TypeShop;

import java.util.List;

public interface TypeShopInter {
    public void insert(TypeShop typeShop);

    public List<TypeShop> findAll();

    public TypeShop findById(Integer id);

    public TypeShop findByName(String name);
}
