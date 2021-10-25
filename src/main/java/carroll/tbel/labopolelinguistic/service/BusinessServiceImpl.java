package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.BusinessMapper;
import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.entity.Business;
import carroll.tbel.labopolelinguistic.models.entity.City;
import carroll.tbel.labopolelinguistic.models.forms.BusinessForm;
import carroll.tbel.labopolelinguistic.models.forms.BusinessUpdateForm;
import carroll.tbel.labopolelinguistic.repository.BusinessRepository;
import carroll.tbel.labopolelinguistic.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService{

    private final BusinessMapper mapper;
    private final BusinessRepository repository;
    private final CityRepository cityRepository;

    public BusinessServiceImpl(BusinessMapper mapper, BusinessRepository repository, CityRepository cityRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.cityRepository = cityRepository;
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

    //TODO fix or change? lines 48-64
    @Override
    public BusinessDTO insert(BusinessForm businessForm) {
        if (repository.existsById(businessForm.getBusinessId()) )
            throw new ElementAlreadyExistsException();


        Business toInsert = mapper.formToEntity(businessForm); //TODO implement formToEntity method
        Set<City> city = businessForm.getCityIds()
                .stream()
                .map(id -> cityRepository.findById(cityId)
                        .orElseThrow(ElementNotFoundException::new))
                .collect(Collectors.toSet());
        toInsert.setCity(city);

        toInsert = repository.save(toInsert);

        return mapper.toDTO(toInsert);
    }

    @Override
    public BusinessDTO delete(String businessId) {
        Business toDelete = repository.findById(businessId)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public BusinessDTO update(String businessId, BusinessUpdateForm form) {
        Business toUpdate = repository.findById(businessId)
                .orElseThrow(ElementAlreadyExistsException::new);

        toUpdate.setTypeBusiness(form.getTypeBusiness());
        toUpdate.setName(form.getName());
        toUpdate.setAddress(form.getAddress());
        Set<City> city = form.getCity()
                .stream()
                .map(id -> cityRepository.findById(id)
                        .orElseThrow(ElementAlreadyExistsException::new))
                .collect(Collectors.toSet());
        toUpdate.setCity(city);

        toUpdate = repository.save(toUpdate);

        return mapper.toDTO(toUpdate);
    }
}
