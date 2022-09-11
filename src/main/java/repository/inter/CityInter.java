package repository.inter;

import entity.City;

import java.util.List;

public interface CityInter {
    public void delete(Integer id);

    public void insert(City city);

    public void update(City city);

    public List<City> findAll();

    public City findByid(Integer id);

    public City findByName(String name);
}
