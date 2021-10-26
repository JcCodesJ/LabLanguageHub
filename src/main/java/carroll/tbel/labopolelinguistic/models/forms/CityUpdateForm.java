package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class CityUpdateForm {

    @NotBlank
    private String name;

    @NotBlank
    private long postCode;

}
