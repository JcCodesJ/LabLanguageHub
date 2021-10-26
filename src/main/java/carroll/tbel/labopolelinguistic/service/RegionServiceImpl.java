package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.exceptions.ElementAlreadyExistsException;
import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.mappers.RegionMapper;
import carroll.tbel.labopolelinguistic.models.dto.RegionDTO;
import carroll.tbel.labopolelinguistic.models.entity.Region;
import carroll.tbel.labopolelinguistic.models.forms.RegionForm;
import carroll.tbel.labopolelinguistic.models.forms.RegionUpdateForm;
import carroll.tbel.labopolelinguistic.repository.RegionRepository;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService{

    private final RegionMapper regionMapper;
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionMapper regionMapper, RegionRepository regionRepository) {
        this.regionMapper = regionMapper;
        this.regionRepository = regionRepository;
    }

    @Override
    public RegionDTO getOne(String regionId) {
        return regionRepository.findById(regionId)
                .map(regionMapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public RegionDTO insert(RegionForm toInsert) {
        return null;
    }

    @Override
    public RegionDTO delete(String regionId) {
        Region toDelete = regionRepository.findById(regionId)
                .orElseThrow(ElementAlreadyExistsException::new);

        regionRepository.delete(toDelete);

        return regionMapper.toDTO(toDelete);
    }

    @Override
    public RegionDTO update(String regionId, RegionUpdateForm regionUpdateForm) {
        Region toUpdate = regionRepository.findById(regionId)
                .orElseThrow(ElementAlreadyExistsException::new);

        toUpdate.setName(regionUpdateForm.getName());

        toUpdate = regionRepository.save(toUpdate);


        return regionMapper.toDTO(toUpdate);
    }
}
