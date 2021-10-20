package carroll.tbel.labopolelinguistic.repository;

import carroll.tbel.labopolelinguistic.models.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
