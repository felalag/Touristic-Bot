package by.felalag.touristicbot.repository;

import by.felalag.touristicbot.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<CityInfoView> getInfoByName(String name);

}
