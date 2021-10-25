package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.CountryDTO;
import carroll.tbel.labopolelinguistic.models.entity.Country;
import org.springframework.stereotype.Service;

@Service
public class CountryMapper {

    public CountryDTO toDTO(Country entity){

        if (entity == null)
            return null;

        return CountryDTO.builder()
                .countryId(entity.getCountryId() )
                .name(entity.getName() )
                .continent(entity.getContinent() )
                .build();

    }

}
