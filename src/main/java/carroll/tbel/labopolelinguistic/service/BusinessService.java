package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.forms.BusinessForm;
import carroll.tbel.labopolelinguistic.models.forms.BusinessUpdateForm;

import java.util.List;

public interface BusinessService {

    List<BusinessDTO> getAll();
    BusinessDTO getOne(String businessId);
    BusinessDTO insert(BusinessForm toInsert);
    BusinessDTO delete(String businessId);
    BusinessDTO update(String businessId, BusinessUpdateForm form);

}
