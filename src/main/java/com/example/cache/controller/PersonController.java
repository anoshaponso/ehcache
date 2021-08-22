package com.example.cache.controller;

import com.example.cache.model.Person;
import com.example.cache.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Person getById(@PathVariable("id") Long id, HttpServletResponse response) {
        Person person = personService.find(id);
        if (person != null) {
            return person;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }

    @PostMapping("/")
    public Person savePerson(@RequestBody Person person) {
        return personService.add(person);
    }
}
