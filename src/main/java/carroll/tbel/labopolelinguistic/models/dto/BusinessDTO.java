package carroll.tbel.labopolelinguistic.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BusinessDTO {

    private String businessId;
    private String typeBusiness;
    private String name;
    private String address;
    private List<BusinessDTO.CityDTO> city;


    public static class CityDTO{

        private String cityId;
        private String name;
        private long postCode;
    }

}
