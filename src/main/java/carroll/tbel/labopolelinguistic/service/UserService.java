package carroll.tbel.labopolelinguistic.service;

import carroll.tbel.labopolelinguistic.models.dto.UserDTO;
import carroll.tbel.labopolelinguistic.models.forms.UserForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDTO insert(UserForm form);
    UserDTO update(long id, UserForm form);
    List<UserDTO> getAll();

}
