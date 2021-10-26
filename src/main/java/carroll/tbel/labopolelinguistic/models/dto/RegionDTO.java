package carroll.tbel.labopolelinguistic.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegionDTO {

    private String regionId;
    private String name;
    private RegionDTO.CountryDTO country;


    @Data
    @Builder
    public static class CountryDTO{

        private String countryId;
        private String name;
        private String continent;
    }

}
