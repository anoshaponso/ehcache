package com.example.cache.service;

import com.example.cache.model.Person;


public interface PersonService {

    Person find(Long id);

    Person add(Person person);
}
