package carroll.tbel.labopolelinguistic.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDTO {

    private String countryId;

    private String name;

    private String continent;

}
