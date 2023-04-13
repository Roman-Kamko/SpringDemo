package com.kamko.kamkospringdemo.controller;

import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.exceptions.BadPersonNumberException;
import com.kamko.kamkospringdemo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/person/by-passport")
    public String getPersonInfo(@RequestParam String passport) {
        return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String passport,
                            @RequestParam Integer profession
    ) {
        Person person = new Person(name, surname, passport, profession);
        personService.addPerson(person);
        return "Person added";
    }

    @GetMapping(path = "person/profession/add")
    public String addProfession(@RequestParam String passport,
                                @RequestParam Integer profession) {
        personService.addProfession(passport, profession);
        return "Профессия успешно добавлена";
    }

    @GetMapping("/persons/by-profession")
    public String getByProfession(@RequestParam int profession ) {
        return personService.getPersonsByProfession(profession).toString();
    }

}
