package by.task.resliv.repository;

import by.task.resliv.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Modifying
    @Query("delete from City where id in :id")
    void deleteByIds(List<Long> id);

    Optional<City> findOneByCity(String city);

}
