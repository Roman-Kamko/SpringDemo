package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Driver;
import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.domain.TruckDriver;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    Person[] people = {
            new Person(
                    "Жан",
                    "Рено",
                    "12345"
            ),
            new Person(
                    "Люк",
                    "Бессон",
                    "32124"
            ),
            new Person(
                    "Жерар",
                    "Депардье",
                    "71231"
            ),
            new Driver(
                    "Джейсон",
                    "Стетхэм",
                    "891723",
                    "4376"
            ),
            new TruckDriver(
                    "Роберт",
                    "Патинсон",
                    "892374",
                    "2456"
            )
    };

    @Override
    public String getPerson(Integer number) {
        final Person person;
        person = people[number];
        final String personDescription =
                person.getName() + " " +
                        person.getSurname() + " " +
                        person.getPassport();
        return personDescription;
    }
}
