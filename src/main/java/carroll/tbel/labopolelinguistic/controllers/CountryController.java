package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.models.dto.CountryDTO;
import carroll.tbel.labopolelinguistic.models.dto.ErrorDTO;
import carroll.tbel.labopolelinguistic.models.forms.CountryForm;
import carroll.tbel.labopolelinguistic.service.CountryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryDTO> getOne(@PathVariable String countryId){
        return ResponseEntity
                .ok(countryService.getOne(countryId) );
    }

    @GetMapping(params = {"countryId"})
    public ResponseEntity<CountryDTO> getOneByParam(@RequestParam String countryId){
        return ResponseEntity
                .ok(countryService.getOne(countryId));
    }

    public CountryDTO insert(@Valid @RequestBody CountryForm countryForm, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key) );
        }
        return countryService.insert(countryForm);
    }

    @DeleteMapping("/{countryId}")
    public CountryDTO delete(@PathVariable(name = "countryId") String countryId){
        return countryService.delete(countryId);
    }

    @DeleteMapping(params = "countryId")
    public CountryDTO deleteByParam(@RequestParam(name = "countryId") String countryId){
        return countryService.delete(countryId);
    }
}
