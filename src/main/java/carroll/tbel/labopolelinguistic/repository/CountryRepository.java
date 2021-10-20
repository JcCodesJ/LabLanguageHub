package carroll.tbel.labopolelinguistic.repository;

import carroll.tbel.labopolelinguistic.models.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
