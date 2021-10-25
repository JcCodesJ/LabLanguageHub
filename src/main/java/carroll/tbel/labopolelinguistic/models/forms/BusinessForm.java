package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class BusinessForm {

    @NotBlank
    private String businessId;

    @NotBlank
    private String cityId;

    @NotBlank
    private String typeBusiness;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

}
