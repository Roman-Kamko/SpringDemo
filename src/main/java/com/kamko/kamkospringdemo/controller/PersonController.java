package com.kamko.kamkospringdemo.controller;

import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.exceptions.BadPersonNumberException;
import com.kamko.kamkospringdemo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/person")
    public String getPersonInfo(@RequestParam("number") Integer number) {
        return personService.getPerson(number);
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer profession
    ) {
        Person person = new Person(name, surname, passport, profession);
        personService.addPerson(person);
        return "Person added";
    }
}
