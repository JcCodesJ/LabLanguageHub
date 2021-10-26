package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.LanguageMapper;
import carroll.tbel.labopolelinguistic.models.dto.LanguageDTO;
import carroll.tbel.labopolelinguistic.models.entity.Language;
import carroll.tbel.labopolelinguistic.models.forms.LanguageForm;
import carroll.tbel.labopolelinguistic.models.forms.LanguageUpdateForm;
import carroll.tbel.labopolelinguistic.repository.LanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService{

    private final LanguageMapper languageMapper;
    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageMapper languageMapper, LanguageRepository languageRepository) {
        this.languageMapper = languageMapper;
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageDTO getOne(String langId) {
        return languageRepository.findById(langId)
                .map(languageMapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override //TODO how??
    public LanguageDTO insert(LanguageForm languageForm) {
        if (languageRepository.existsById(languageForm.getLangId()) )
            throw new ElementAlreadyExistsException();


        return null;
    }

    @Override
    public LanguageDTO delete(String langId) {
        Language toDelete = languageRepository.findById(langId)
                .orElseThrow(ElementAlreadyExistsException::new);

        languageRepository.delete(toDelete);

        return languageMapper.toDTO(toDelete);
    }

    @Override
    public LanguageDTO update(String langId, LanguageUpdateForm languageUpdateForm) {
        Language toUpdate = languageRepository.findById(langId)
                .orElseThrow(ElementAlreadyExistsException::new);

        toUpdate.setName(languageUpdateForm.getName());

        toUpdate = languageRepository.save(toUpdate);

        return languageMapper.toDTO(toUpdate);
    }
}
