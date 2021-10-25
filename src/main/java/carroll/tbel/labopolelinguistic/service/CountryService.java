package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.CountryDTO;
import carroll.tbel.labopolelinguistic.models.forms.CountryForm;
import carroll.tbel.labopolelinguistic.models.forms.CountryUpdateForm;

public interface CountryService {

    CountryDTO getOne(String countryId);
    CountryDTO insert(CountryForm toInsert);
    CountryDTO delete(String countryId);
    CountryDTO update(String countryId, CountryUpdateForm countryUpdateForm);

}
