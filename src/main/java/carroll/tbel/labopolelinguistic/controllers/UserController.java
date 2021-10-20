package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.models.dto.UserDTO;
import carroll.tbel.labopolelinguistic.models.forms.UserForm;
import carroll.tbel.labopolelinguistic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserForm form){
        return ResponseEntity.ok(service.insert(form) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable long id, @Valid @RequestBody UserForm form){
        return ResponseEntity.ok(service.update(id, form) );
    }

    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(service.getAll() );
    }

}
