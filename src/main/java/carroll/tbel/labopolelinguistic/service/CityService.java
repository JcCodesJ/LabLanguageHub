package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.models.forms.CityForm;
import carroll.tbel.labopolelinguistic.models.forms.CityUpdateForm;

import java.util.List;

public interface CityService {

    List<CityDTO> getAll();
    CityDTO getOne(String cityId);
    CityDTO insert(CityForm toInsert);
    CityDTO delete(String cityId);
    CityDTO update(String cityId, CityUpdateForm form);

}
