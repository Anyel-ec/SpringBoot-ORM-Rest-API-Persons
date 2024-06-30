package top.anyel.orm.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.anyel.orm.models.Address;
import top.anyel.orm.models.Person;
import top.anyel.orm.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons/v1")
@Validated
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;

    }

    @PostMapping("/save")
    public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personService.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personService.findById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Person> updateById(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person updatedPerson = personService.updateById(id, person);
        if (updatedPerson == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String result = personService.deleteById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/address/house/{id}")
    public ResponseEntity<List<Address>> findHouseAddressesById(@PathVariable Long id) {
        List<Address> addresses = personService.findHouseAddressesById(id);
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/findAllByEmailCity")
    public ResponseEntity<List<Person>> findAllByEmailCity(@RequestParam String email, @RequestParam String city) {
        List<Person> persons = personService.findAllByEmailCity(email, city);
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/findByIdentification")
    public ResponseEntity<List<Person>> findByIdentification(@RequestParam String identification) {
        List<Person> persons = personService.findByIdentification(identification);
        return ResponseEntity.ok(persons);
    }


}