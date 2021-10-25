package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.RegionDTO;
import carroll.tbel.labopolelinguistic.models.entity.Region;
import carroll.tbel.labopolelinguistic.models.forms.RegionForm;
import carroll.tbel.labopolelinguistic.models.forms.RegionUpdateForm;

public interface RegionService {

    RegionDTO getOne(String regionId);
    RegionDTO insert(RegionForm toInsert);
    RegionDTO delete(String regionId);
    RegionDTO update(String regionId, RegionUpdateForm regionUpdateForm);

}
