package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Driver;
import com.kamko.kamkospringdemo.domain.Person;
import com.kamko.kamkospringdemo.domain.TruckDriver;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    Map<String, Person> personMap = new HashMap<>(Map.of
            (
                    "12345",
                    new Person(
                            "Жан",
                            "Рено",
                            "12345",
                            3),
                    "32124",
                    new Person(
                            "Люк",
                            "Бессон",
                            "32124",
                            2),
                    "71231",
                    new Person(
                            "Жерар",
                            "Депардье",
                            "71231",
                            0),
                    "891723",
                    new Driver(
                            "Джейсон",
                            "Стетхэм",
                            "891723",
                            "4376",
                            1),
                    "892374",
                    new TruckDriver(
                            "Роберт",
                            "Патинсон",
                            "892374",
                            "2456",
                            3)
            ));

    List<String> professions = List.of
            (
                    "безработный",
                    "водитель",
                    "плотник",
                    "столяр",
                    "актер"
            );

    Map<String, Integer> professionsCodes = Map.of(
            "безработный", 0,
            "водитель", 1,
            "плотник", 2,
            "столяр", 3,
            "актер", 4
    );

    @Override
    public List<String> getPersonsByProfession(Integer professionNumber) {
        return personMap.values().stream()
                .map(Person::getPassport)
                .collect(Collectors.toList());
    }

    public List<Person> getProfessionNumbers(List<Integer> professionsNumbers) {
        return personMap.values().stream()
                .filter(person -> person.getProfessionNumbers().containsAll(professionsNumbers))
                .toList();
    }

    @Override
    public void addPerson(Person person) {
        personMap.put(person.getPassport(), person);
    }

    @Override
    public String getPersonByPassport(String passport) {
        Person person = personMap.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с данным номером паспорта не найден");
        }
        final String personDescription =
                person.getName() + " " +
                        person.getSurname() + " " +
                        person.getPassport() + " " +
                        getProfessionNames(person.getProfessionNumbers());
        return personDescription;
    }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        StringBuilder result = new StringBuilder();
        for (Integer professionNumber : professionNumbers) {
            result.append(" ").append(professions.get(professionNumber));
        }
        return result.toString();
    }

    @Override
    public void addProfession(String passport, Integer profession) {
        Person person = personMap.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с данным номером паспорта не найден");
        }
        person.getProfessionNumbers().add(profession);
    }
}
