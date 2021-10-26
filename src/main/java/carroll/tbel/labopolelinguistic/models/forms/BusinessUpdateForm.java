package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class BusinessUpdateForm {

    @NotBlank
    private String typeBusiness;

    @NotBlank
    private String cityId;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

}
