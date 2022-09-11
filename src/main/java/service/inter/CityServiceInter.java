package service.inter;

import entity.City;

import java.util.List;

public interface CityServiceInter {
    List<City> showAll();
    City findByIdCity(Integer id);
}
