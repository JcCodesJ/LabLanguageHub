package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class CityForm {

    @NotBlank
    private String cityId;

    @NotBlank
    private String name;

    @NotBlank
    private long postCode;

    @NotEmpty
    private List<String> cityIds;

}
