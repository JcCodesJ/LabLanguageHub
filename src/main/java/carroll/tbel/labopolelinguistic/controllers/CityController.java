package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.models.dto.ErrorDTO;
import carroll.tbel.labopolelinguistic.models.forms.CityForm;
import carroll.tbel.labopolelinguistic.models.forms.CityUpdateForm;
import carroll.tbel.labopolelinguistic.service.CityService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDTO> getOne(@PathVariable String cityId){
        return ResponseEntity
                .ok(service.getOne(cityId) );
    }

    @GetMapping(params = {"cityId"})
    public ResponseEntity<CityDTO> getOneByParam(@RequestParam String cityId){
        return ResponseEntity
                .ok(service.getOne(cityId));
    }

    public CityDTO insert(@Valid @RequestBody CityForm cityForm, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key) );
        }
        return service.insert(cityForm);
    }

    @DeleteMapping("/{cityId}")
    public CityDTO delete(@PathVariable(name = "cityId") String cityId){
        return service.delete(cityId);
    }

    @DeleteMapping(params = "cityId")
    public CityDTO deleteByParam(@RequestParam(name = "cityId") String cityId){
        return service.delete(cityId);
    }

    public CityDTO update(@RequestParam String cityId, @Valid @RequestBody CityUpdateForm cityUpdateForm){
        return service.update(cityId, cityUpdateForm);
    }

}
