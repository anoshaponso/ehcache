package com.example.cache.controller;

import com.example.cache.model.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private PersonService personService;

//    @Autowired
//    private CacheManager cacheManager;


    @GetMapping("/test")
    public String test() {
        Person person = new Person();
        person.setId(1l);
        person.setName("Anosh");
        person.setNic("931421581V");
        personService.add(person);

        personService.find(1l);

        personService.find(1l);
        return "Test";
    }
}

