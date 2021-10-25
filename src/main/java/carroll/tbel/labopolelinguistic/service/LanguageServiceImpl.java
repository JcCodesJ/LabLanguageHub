package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.LanguageMapper;
import carroll.tbel.labopolelinguistic.models.dto.LanguageDTO;
import carroll.tbel.labopolelinguistic.models.forms.LanguageForm;
import carroll.tbel.labopolelinguistic.models.forms.LanguageUpdateForm;
import carroll.tbel.labopolelinguistic.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService{

    private final LanguageMapper mapper;
    private final LanguageRepository repository;

    public LanguageServiceImpl(LanguageMapper mapper, LanguageRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public LanguageDTO getOne(String langId) {
        return repository.findById(langId)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public LanguageDTO insert(LanguageForm toInsert) {
        return null;
    }

    @Override
    public LanguageDTO delete(String langId) {
        return null;
    }

    @Override
    public LanguageDTO update(String langId, LanguageUpdateForm languageUpdateForm) {
        return null;
    }
}
