package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.RegionDTO;
import carroll.tbel.labopolelinguistic.models.entity.Region;
import org.springframework.stereotype.Service;

@Service
public class RegionMapper {

    public RegionDTO toDTO(Region entity){

        if (entity == null)
            return null;

        return RegionDTO.builder()
                .regionId(entity.getRegionId() )
                .name(entity.getName() )
                .build();

    }

}
