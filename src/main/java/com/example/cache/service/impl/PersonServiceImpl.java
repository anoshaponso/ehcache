package com.example.cache.service.impl;

import com.example.cache.model.Person;
import com.example.cache.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    List<Person> people = new ArrayList<>();

    @Override
    public Person add(Person person) {
        person.setId((long) (int) (Math.random() * 1000));
        people.add(person);
        LOGGER.info("Person added.  Person Id : " + person.getId());

        return person;
    }

    @Override
    @Cacheable(value = "personCache", key = "#id", unless = "#result == null")
    public Person find(Long id) {
        LOGGER.info("Person retrieved ");

        return people.stream().filter(person -> person.getId().equals(id)).findFirst().orElse(null);
    }

}
