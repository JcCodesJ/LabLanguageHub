package carroll.tbel.labopolelinguistic.repository;

import carroll.tbel.labopolelinguistic.models.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, String> {
}
