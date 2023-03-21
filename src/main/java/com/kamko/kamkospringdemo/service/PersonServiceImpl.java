package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Driver;
import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.domain.TruckDriver;
import com.kamko.kamkospringdemo.exceptions.BadPersonNumberException;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    Person[] people = {
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    3),
            new Person(
                    "Люк",
                    "Бессон",
                    "32124",
                    2),
            new Person(
                    "Жерар",
                    "Депардье",
                    "71231",
                    0),
            new Driver(
                    "Джейсон",
                    "Стетхэм",
                    "891723",
                    "4376",
                    1),
            new TruckDriver(
                    "Роберт",
                    "Патинсон",
                    "892374",
                    "2456",
                    4)
    };

    String [] professions = {
            "безработный",
            "водитель",
            "плотник",
            "столяр"
    };

    @Override
    public String getPerson(Integer number) {
        final Person person;
        if (number >= people.length) {
            throw new BadPersonNumberException("ошибка в том, что номер человека заведомо больше размера массива");
        }
        person = people[number];
        final String personDescription =
                person.getName() + " " +
                person.getSurname() + " " +
                person.getPassport() + " " +
                professions[person.getProfessionNumber()];
        return personDescription;
    }
}
