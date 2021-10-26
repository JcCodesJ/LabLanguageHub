package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.models.dto.CountryDTO;
import carroll.tbel.labopolelinguistic.models.dto.ErrorDTO;
import carroll.tbel.labopolelinguistic.models.dto.RegionDTO;
import carroll.tbel.labopolelinguistic.models.forms.CountryForm;
import carroll.tbel.labopolelinguistic.models.forms.RegionForm;
import carroll.tbel.labopolelinguistic.service.RegionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/{regionId}")
    public ResponseEntity<RegionDTO> getOne(@PathVariable String regionId){
        return ResponseEntity
                .ok(regionService.getOne(regionId) );
    }

    @GetMapping(params = {"regionId"})
    public ResponseEntity<RegionDTO> getOneByParam(@RequestParam String regionId){
        return ResponseEntity
                .ok(regionService.getOne(regionId));
    }

    public RegionDTO insert(@Valid @RequestBody RegionForm regionForm, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println(headers.get(key) );
        }
        return regionService.insert(regionForm);
    }

    @DeleteMapping("/{regionId}")
    public RegionDTO delete(@PathVariable(name = "regionId") String regionId){
        return regionService.delete(regionId);
    }

    @DeleteMapping(params = "regionId")
    public RegionDTO deleteByParam(@RequestParam(name = "regionId") String regionId){
        return regionService.delete(regionId);
    }

}
