package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.BusinessMapper;
import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.entity.Business;
import carroll.tbel.labopolelinguistic.models.entity.Language;
import carroll.tbel.labopolelinguistic.models.forms.BusinessForm;
import carroll.tbel.labopolelinguistic.models.forms.BusinessUpdateForm;
import carroll.tbel.labopolelinguistic.repository.BusinessRepository;
import carroll.tbel.labopolelinguistic.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService{

    private final BusinessMapper mapper;
    private final BusinessRepository repository;
    private final LanguageRepository languageRepository;

    public BusinessServiceImpl(BusinessMapper mapper, BusinessRepository repository, LanguageRepository languageRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<BusinessDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BusinessDTO getOne(String businessId) {
        return repository.findById(businessId)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public BusinessDTO insert(BusinessForm toInsert) {
        if (repository.existsById(form.getBusinessId()) )
            throw new ElementAlreadyExistsException();

        Business toInsert = mapper.formToEntity(form);
        Set<Language> language = form.getLanguageIds()
                .stream()
                .map(id -> languageRepository.findById(langId)
                        .orElseThrow(ElementNotFoundException::new))
                .collect(Collectors.toSet());
        toInsert.setLanguage(language);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public BusinessDTO delete(String businessId) {
        return null;
    }

    @Override
    public BusinessDTO update(String businessId, BusinessUpdateForm form) {
        return null;
    }
}
