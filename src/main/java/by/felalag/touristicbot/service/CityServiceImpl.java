package by.felalag.touristicbot.service;

import by.felalag.touristicbot.domain.entity.City;
import by.felalag.touristicbot.repository.CityInfoView;
import by.felalag.touristicbot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public String findInfoByName(String name) {
        return cityRepository.getInfoByName(name).map(CityInfoView::getInfo).orElse(null);
    }

    @Override
    public City update(Long id, City newCity) {
        return cityRepository.findById(id)
                .map(city -> {
                    if (newCity.getName() != null) {
                        city.setName(newCity.getName());
                    }
                    if (newCity.getInfo() != null) {
                        city.setInfo(newCity.getInfo());
                    }
                    return cityRepository.save(city);
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

}
