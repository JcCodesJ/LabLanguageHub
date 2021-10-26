package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.models.dto.ErrorDTO;
import carroll.tbel.labopolelinguistic.models.dto.LanguageDTO;
import carroll.tbel.labopolelinguistic.models.forms.LanguageForm;
import carroll.tbel.labopolelinguistic.service.LanguageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("/language")
public class LanguageController {
    
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/{langId}")
    public ResponseEntity<LanguageDTO> getOne(@PathVariable String langId){
        return ResponseEntity
                .ok(languageService.getOne(langId) );
    }

    @GetMapping(params = {"langId"})
    public ResponseEntity<LanguageDTO> getOneByParam(@RequestParam String langId){
        return ResponseEntity
                .ok(languageService.getOne(langId));
    }

    public LanguageDTO insert(@Valid @RequestBody LanguageForm languageForm, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key) );
        }
        return languageService.insert(languageForm);
    }

    @DeleteMapping("/{langId}")
    public LanguageDTO delete(@PathVariable(name = "langId") String langId){
        return languageService.delete(langId);
    }

    @DeleteMapping(params = "langId")
    public LanguageDTO deleteByParam(@RequestParam(name = "langId") String langId){
        return languageService.delete(langId);
    }
    
}
