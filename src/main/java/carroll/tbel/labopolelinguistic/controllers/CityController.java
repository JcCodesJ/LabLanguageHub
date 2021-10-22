package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.models.dto.CityDTO;
import carroll.tbel.labopolelinguistic.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    public ResponseEntity<CityDTO> getOne(@PathVariable String cityId){
        return ResponseEntity.ok(service.getOne(cityId) );
    }

}
