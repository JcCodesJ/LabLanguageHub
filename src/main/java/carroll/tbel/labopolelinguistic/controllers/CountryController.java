package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.models.dto.RegionDTO;
import carroll.tbel.labopolelinguistic.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{regionId}")
    public ResponseEntity<RegionDTO> getOne(@PathVariable String regionId){
        return ResponseEntity
                .ok(countryService.getOne(regionId) );
    }

    public ResponseEntity<RegionDTO> getOneByParam(@RequestParam String )

}
