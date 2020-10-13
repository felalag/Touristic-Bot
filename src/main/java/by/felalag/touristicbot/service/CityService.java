package by.felalag.touristicbot.service;

import by.felalag.touristicbot.domain.entity.City;

import java.util.List;

public interface CityService {

    City create(City city);

    List<City> findAll();

    City findById(Long id);

    String findInfoByName(String name);

    City update(Long id, City city);

    void delete(Long id);

}
