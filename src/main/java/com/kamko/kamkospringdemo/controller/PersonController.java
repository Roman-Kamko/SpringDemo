package com.kamko.kamkospringdemo.controller;

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
        try {
            final String person = personService.getPerson(number);
            return person;
        } catch (BadPersonNumberException exception) {
            return "Попробуйте другой номер";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Попробуйте в другой раз";
        } finally {
            System.out.println("Робато метода getPersonInfo закончена");
        }
    }
}
