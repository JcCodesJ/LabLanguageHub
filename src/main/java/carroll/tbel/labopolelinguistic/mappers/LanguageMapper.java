package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.LanguageDTO;
import carroll.tbel.labopolelinguistic.models.entity.Language;
import org.springframework.stereotype.Service;

@Service
public class LanguageMapper {

    public LanguageDTO toDTO(Language entity){

        if (entity == null)
            return null;

        return LanguageDTO.builder()
                .langId(entity.getLangId())
                .name(entity.getName())
                .build();

    }

    //TODO link to something else?
    // Add that something else to the return above?

}
