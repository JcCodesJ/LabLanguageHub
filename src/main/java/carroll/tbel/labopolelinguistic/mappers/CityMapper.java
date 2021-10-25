package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.models.entity.City;
import org.springframework.stereotype.Service;

@Service
public class CityMapper {

    public CityDTO toDTO(City entity){

        if (entity == null)
            return null;

        return CityDTO.builder()
                .cityId(entity.getCityId() )
                .name(entity.getName() )
                .postCode(entity.getPostCode() )
                .build();

    }

}
