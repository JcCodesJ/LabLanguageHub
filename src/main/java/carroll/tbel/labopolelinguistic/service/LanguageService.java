package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.LanguageDTO;
import carroll.tbel.labopolelinguistic.models.forms.LanguageForm;
import carroll.tbel.labopolelinguistic.models.forms.LanguageUpdateForm;

public interface LanguageService {

    LanguageDTO getOne(String langId);
    LanguageDTO insert(LanguageForm toInsert);
    LanguageDTO delete(String langId);
    LanguageDTO update(String langId, LanguageUpdateForm languageUpdateForm);

}
