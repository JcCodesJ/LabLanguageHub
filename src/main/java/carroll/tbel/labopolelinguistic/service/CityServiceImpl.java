package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.mappers.CityMapper;
import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.models.forms.CityForm;
import carroll.tbel.labopolelinguistic.models.forms.CityUpdateForm;
import carroll.tbel.labopolelinguistic.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final CityMapper mapper;
    private final CityRepository repository;

    public CityServiceImpl(CityMapper mapper, CityRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<CityDTO> getAll() {
        return null;
    }

    @Override
    public CityDTO getOne(String cityId) {
        return null;
    }

    @Override
    public CityDTO insert(CityForm toInsert) {
        return null;
    }

    @Override
    public CityDTO delete(String cityId) {
        return null;
    }

    @Override
    public CityDTO update(String cityId, CityUpdateForm form) {
        return null;
    }
}
