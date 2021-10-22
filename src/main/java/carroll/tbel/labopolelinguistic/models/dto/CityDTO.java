package carroll.tbel.labopolelinguistic.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityDTO {

    private String cityId;
    private String name;
    private long postCode;
    private List<CityDTO.BusinessDTO> business;


    public static class BusinessDTO{

        private String businessId;
        private String typeBusiness;
        private String name;
        private String address;
    }

}
