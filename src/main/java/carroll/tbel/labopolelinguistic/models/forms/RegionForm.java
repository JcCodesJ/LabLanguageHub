package carroll.tbel.labopolelinguistic.models.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class RegionForm {

    @NotBlank
    private String regionId;

    @NotBlank
    private String name;

    @NotEmpty
    private List<String> regionIds;

}
