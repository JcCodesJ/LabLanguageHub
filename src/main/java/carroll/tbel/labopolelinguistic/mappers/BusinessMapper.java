package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.entity.Business;
import org.springframework.stereotype.Service;

@Service
public class BusinessMapper {

    public BusinessDTO toDTO(Business entity){

        if (entity == null)
            return null;

        return BusinessDTO.builder()
                .businessId(entity.getBusinessId() )
                .typeBusiness(entity.getTypeBusiness() )
                .name(entity.getName() )
                .address(entity.getName() )
                .build();

    }

}
