package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.models.forms.LoginForm;
import carroll.tbel.labopolelinguistic.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public ResponseEntity<String> login(@Valid @RequestBody LoginForm form){
        return ResponseEntity.ok(sessionService.login(form) );
    }

}