package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.CityMapper;
import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.models.entity.City;
import carroll.tbel.labopolelinguistic.models.entity.Region;
import carroll.tbel.labopolelinguistic.models.forms.CityForm;
import carroll.tbel.labopolelinguistic.models.forms.CityUpdateForm;
import carroll.tbel.labopolelinguistic.repository.CityRepository;
import carroll.tbel.labopolelinguistic.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService{

    private final CityMapper cityMapper;
    private final CityRepository cityRepository;
    private final RegionRepository regionRepository;

    public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository, RegionRepository regionRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public List<CityDTO> getAll() {
        return null;
    }

    @Override
    public CityDTO getOne(String cityId) {
        return cityRepository.findById(cityId)
                .map(cityMapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public CityDTO insert(CityForm toInsert) {
        return null;
    }

    @Override
    public CityDTO delete(String cityId) {
        City toDelete = cityRepository.findById(cityId)
                .orElseThrow(ElementAlreadyExistsException::new);

        cityRepository.delete(toDelete);

        return cityMapper.toDTO(toDelete);
    }

    @Override
    public CityDTO update(String cityId, CityUpdateForm cityUpdateForm) {
        City toUpdate = cityRepository.findById(cityId)
                .orElseThrow(ElementAlreadyExistsException::new);

        toUpdate.setName(cityUpdateForm.getName());
        toUpdate.setPostCode(cityUpdateForm.getPostCode());
        
        toUpdate = cityRepository.save(toUpdate);

        return cityMapper.toDTO(toUpdate);
    }
}
