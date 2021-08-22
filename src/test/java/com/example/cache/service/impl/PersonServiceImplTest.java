package com.example.cache.service.impl;

import com.example.cache.model.Person;
import com.example.cache.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addTest() {
        Person person = new Person();
        person.setName("Test");
        person.setNic("951458963V");

        Person actPerson = personService.add(person);

        assertEquals(actPerson.getName(), person.getName());
        assertEquals(actPerson.getNic(), person.getNic());
        assertNotNull(actPerson.getId());
    }

    @Test
    public void getPersonTest() {

        Person person = new Person();
        person.setName("Test");
        person.setNic("951458963V");

        PersonService mockPersonService = mock(PersonService.class);
        person = personService.add(person);

        Person actPerson = personService.find(person.getId());
        personService.find(person.getId());


        assertEquals(actPerson.getId(), person.getId());
        assertEquals(actPerson.getName(), person.getName());
        assertEquals(actPerson.getNic(), person.getNic());
    }
}