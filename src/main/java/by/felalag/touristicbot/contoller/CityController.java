package by.felalag.touristicbot.contoller;

import by.felalag.touristicbot.domain.entity.City;
import by.felalag.touristicbot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City createCity(@RequestBody City city) {
        if (city.getName() == null || city.getInfo() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Content provided");
        }
        return cityService.create(city);
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.findAll();
    }

    @GetMapping("{id}")
    public City getCityById(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @PutMapping("{id}")
    public City replaceCity(@PathVariable("id") Long id, @RequestBody City city) {
        if (city.getName() == null || city.getInfo() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Content provided");
        }
        return cityService.update(id, city);
    }

    @PatchMapping("{id}")
    public City updateCityPartially(@PathVariable("id") Long id, @RequestBody City city) {
        if (city.getName() == null && city.getInfo() == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Content provided");
        }
        return cityService.update(id, city);
    }

    @DeleteMapping("{id}")
    public void deleteCityById(@PathVariable("id") Long id) {
        cityService.delete(id);
    }

}
