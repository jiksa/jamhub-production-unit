package sage.springcoder.jamhubproductionunit.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sage.springcoder.jamhubproductionunit.web.model.JamDto;
import sage.springcoder.jamhubproductionunit.web.service.JamService;

import java.util.UUID;

@RequestMapping("/api/v1/jam")
@RestController
public class JamController {

    private final JamService jamService;

    public JamController(JamService jamService) {
        this.jamService = jamService;
    }

    @GetMapping({"/{jamId}"})
    public ResponseEntity<JamDto> getJamById(@PathVariable("jamId") UUID jamId){
        return new ResponseEntity<>(jamService.getJamById(jamId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewJam(@RequestBody JamDto jam){
        JamDto savedJamDto = jamService.saveNewJam(jam);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","api/v1/jam/"+savedJamDto.getJamId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{jamId}")
    public ResponseEntity updateJam(@PathVariable("jamId") UUID jamId,@RequestBody JamDto jam){
        jamService.updateJam(jamId,jam);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{jamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJam(@PathVariable("jamId") UUID jamId){
        jamService.deleteById(jamId);
    }
}
