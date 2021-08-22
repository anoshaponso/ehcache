package com.example.cache.controller;

import com.example.cache.model.Person;
import com.example.cache.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.servlet.http.HttpServletResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonControllerTest {

    @Mock
    HttpServletResponse httpServletResponse;
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonServiceImpl personService;

    @Test
    public void getPersonTest() {

        ReflectionTestUtils.setField(personController, "personService", personService);

        Person person = new Person();
        person.setName("Test");
        person.setNic("951458963V");

        Person ret = person;
        ret.setId(1l);
        when(personService.add(person)).thenReturn(ret);
        when(personService.find(1l)).thenReturn(ret);

        person = personController.savePerson(person);

        personService.find(1l);
        personService.find(1l);

        Mockito.verify(personService, Mockito.times(1)).find(any());

    }
}