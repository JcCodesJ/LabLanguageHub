package carroll.tbel.labopolelinguistic.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LanguageDTO {

    private String langId;
    private String name;
    private List<LanguageDTO.BusinessDTO> language;

    @Data
    @Builder
    public static class BusinessDTO{

        private String businessId;
        private String typeBusiness;
        private String name;
        private String address;

    }

}
