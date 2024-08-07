package br.edu.ifba.redesmoveis.servidor.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.redesmoveis.servidor.infra.response.PeakTime;
import br.edu.ifba.redesmoveis.servidor.infra.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public void registerPerson(@RequestBody String payload) {
        personService.register(payload);
    }

    @GetMapping("/peaktime")
    public ResponseEntity<PeakTime> getPeakTime() {
        return ResponseEntity.ok(personService.getPeakTime());
    }
}
