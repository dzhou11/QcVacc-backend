package com.qcvacc.qcvaccination.api;

import com.qcvacc.qcvaccination.model.Person;
import com.qcvacc.qcvaccination.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")//return a http response
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> personList = personService.findAllPersons();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")//return a http response
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id){
        Person person = personService.findPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person newPerson = personService.addPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        Person newPerson = personService.updatePerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        personService.deletePerson(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
