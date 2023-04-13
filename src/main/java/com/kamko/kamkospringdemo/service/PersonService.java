package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    String getPersonByPassport(String passport);

    void addProfession(String passport, Integer profession);

    List<String> getPersonsByProfession(Integer professionNumber);
}
