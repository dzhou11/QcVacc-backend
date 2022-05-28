package com.qcvacc.qcvaccination.service;

import com.qcvacc.qcvaccination.exception.UserNotFoundException;
import com.qcvacc.qcvaccination.model.Person;
import com.qcvacc.qcvaccination.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person){
        return personRepo.save(person);
    }

    public List<Person> findAllPersons(){
        return personRepo.findAll();
    }
    public Person updatePerson(Person person){
        return personRepo.save(person);
    }
    public Person findPersonById(Long id){
        return personRepo.findPersonById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+ id +" was not found"));
    }
    public void deletePerson(Long id){
        personRepo.deletePersonById(id);
    }
}
