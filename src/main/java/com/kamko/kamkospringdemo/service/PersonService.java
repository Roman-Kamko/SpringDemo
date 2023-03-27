package com.kamko.kamkospringdemo.service;

import com.kamko.kamkospringdemo.domain.Person;

public interface PersonService {
    String getPerson(Integer number);

    void addPerson(Person person);
}
