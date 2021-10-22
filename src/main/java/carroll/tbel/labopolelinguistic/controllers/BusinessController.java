package carroll.tbel.labopolelinguistic.controllers;

import carroll.tbel.labopolelinguistic.exceptions.ElementNotFoundException;
import carroll.tbel.labopolelinguistic.models.dto.BusinessDTO;
import carroll.tbel.labopolelinguistic.models.dto.ErrorDTO;
import carroll.tbel.labopolelinguistic.models.forms.BusinessForm;
import carroll.tbel.labopolelinguistic.models.forms.BusinessUpdateForm;
import carroll.tbel.labopolelinguistic.service.BusinessService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @GetMapping(path = {"", "/", "/all"})
    public ResponseEntity<List<BusinessDTO>> getAll(){
        return ResponseEntity
                .ok(service.getAll());
    }

    @GetMapping("/{businessId")
    public ResponseEntity<BusinessDTO> getOne(@PathVariable String businessId){
        return ResponseEntity
                .ok(service.getOne(businessId) );
    }

    @GetMapping(params = {"businessId"})
    public ResponseEntity<BusinessDTO> getOneByParam(@RequestParam String businessId){
        return ResponseEntity
                .ok(service.getOne(businessId));
    }

    public BusinessDTO insert(@Valid @RequestBody BusinessForm form, @RequestHeader HttpHeaders headers){

        for (String key : headers.keySet()) {
            System.out.println( headers.get(key) );
        }
        return service.insert(form);
    }

    @DeleteMapping(params = "businessId")
    public BusinessDTO deleteByParam(@RequestParam(name = "businessId") String id){
        return service.delete(id);
    }

    @DeleteMapping("/{businessId}")
    public BusinessDTO delete(@PathVariable(name = "businessId") String id){
        return service.delete(id);
    }

    @PutMapping(params = "businessId")
    public BusinessDTO update(@RequestParam String businessId, @Valid @RequestBody BusinessUpdateForm form){
        return service.update(businessId, form);
    }

    public ResponseEntity<ErrorDTO> handle(ElementNotFoundException ex){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Expires", Instant.now().plusMillis(600_000).toString());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .headers(headers)
                .body(new ErrorDTO(ex.getMessage()));
    }

}
