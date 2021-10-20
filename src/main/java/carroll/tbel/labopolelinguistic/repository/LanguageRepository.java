package carroll.tbel.labopolelinguistic.repository;

import carroll.tbel.labopolelinguistic.models.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, String> {
}
