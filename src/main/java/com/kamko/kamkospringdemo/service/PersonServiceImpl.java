package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Driver;
import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.domain.TruckDriver;
import com.kamko.kamkospringdemo.exceptions.BadPersonNumberException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    List<Person> people = List.of
            (
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
            );
    List<String> professions = List.of
            (
                    "безработный",
                    "водитель",
                    "плотник",
                    "столяр"
            );

    @Override
    public String getPerson(Integer number) {
        final Person person;
        if (number >= people.size()) {
            throw new BadPersonNumberException("ошибка в том, что номер человека заведомо больше размера массива");
        }
        person = people.get(number);
        final String personDescription =
                person.getName() + " " +
                        person.getSurname() + " " +
                        person.getPassport() + " " +
                        professions.get(number);
        return personDescription;
    }
}
