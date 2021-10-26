package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.CountryMapper;
import carroll.tbel.labopolelinguistic.models.dto.CountryDTO;
import carroll.tbel.labopolelinguistic.models.entity.Country;
import carroll.tbel.labopolelinguistic.models.forms.CountryForm;
import carroll.tbel.labopolelinguistic.models.forms.CountryUpdateForm;
import carroll.tbel.labopolelinguistic.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDTO getOne(String countryId) {
        return countryRepository.findById(countryId)
                .map(countryMapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public CountryDTO insert(CountryForm insertInfo) {
        if (countryRepository.existsById(insertInfo.getCountryId()) )
            throw new ElementAlreadyExistsException();


        Country toInsert = countryMapper.formToEntity(countryForm);

        toInsert = countryRepository.save(toInsert);

        return countryMapper.toDTO(toInsert);
    }

    @Override
    public CountryDTO delete(String countryId) {
        Country toDelete = countryRepository.findById(countryId)
                .orElseThrow(ElementAlreadyExistsException::new);

        countryRepository.delete(toDelete);

        return countryMapper.toDTO(toDelete);
    }

    @Override
    public CountryDTO update(String countryId, CountryUpdateForm countryUpdateForm) {
        Country toUpdate = countryRepository.findById(countryId)
                .orElseThrow(ElementAlreadyExistsException::new);

        toUpdate.setName(countryUpdateForm.getName());
        toUpdate.setContinent(countryUpdateForm.getContinent());

        toUpdate = countryRepository.save(toUpdate);

        return countryMapper.toDTO(toUpdate);
    }
}
