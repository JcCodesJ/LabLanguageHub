package carroll.tbel.labopolelinguistic.mappers;

import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.entity.Business;
import carroll.tbel.labopolelinguistic.models.entity.City;
import carroll.tbel.labopolelinguistic.models.forms.BusinessForm;
import carroll.tbel.labopolelinguistic.models.forms.BusinessUpdateForm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter @Setter
public class BusinessMapper {

    public BusinessDTO toDTO(Business entity){

        if (entity == null)
            return null;

        return BusinessDTO.builder()
                .businessId(entity.getBusinessId() )
                .typeBusiness(entity.getTypeBusiness() )
                .name(entity.getName() )
                .address(entity.getName() )
                .city(
                        entity.getCity()
                                .map()
                )
                .build();

    }

    public Business formToEntity(BusinessForm businessForm){

        if (businessForm == null)
            return null;

        Business business = new Business();
        business.setBusinessId(businessForm.getBusinessId());
       // business.setCityId(businessForm.getCityId());
        business.setTypeBusiness(businessForm.getTypeBusiness());
        business.setName(businessForm.getName());
        business.setAddress(businessForm.getAddress());

        return business;
    }

    public Business updateFormToEntity(BusinessUpdateForm businessUpdateForm){
        if (businessUpdateForm == null)
            return null;

        Business business = new Business();
        business.setTypeBusiness(businessUpdateForm.getTypeBusiness());
        business.setName(businessUpdateForm.getName());
        business.setAddress(businessUpdateForm.getAddress());

        return business;
    }

/*
    @Override
    public BusinessDTO entityToDto(City city) {
        return null;
    }

    @Override
    public Business dtoToEntity(BusinessDTO businessDTO) {
        return null;
    }
    */
}
