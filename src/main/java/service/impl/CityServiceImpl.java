package service.impl;

import entity.City;
import repository.impl.CityImpl;
import repository.inter.CityInter;
import service.inter.CityServiceInter;

import java.util.List;

public class CityServiceImpl implements CityServiceInter {
    private CityInter cityInter = new CityImpl();
    @Override
    public List<City> showAll() {
        return cityInter.findAll() ;

    }

    @Override
    public City findByIdCity(Integer id) {
        return cityInter.findByid(id);
    }
}
