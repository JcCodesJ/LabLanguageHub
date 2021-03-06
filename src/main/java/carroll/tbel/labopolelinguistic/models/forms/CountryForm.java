package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class CountryForm {

    @NotBlank
    private String countryId;

    @NotBlank
    private String name;

    @NotBlank
    private String continent;

    @NotEmpty
    private List<String> countryIds;

}
