package com.octustest.controllers;

import com.octustest.models.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by liuyang on 2/22/2017.
 */
public class PersonRestControllerTest {

    private static PersonRestController mockedPersonRestController;
    private static Person person1;
    private static Person person2;

    @BeforeClass
    public static void setUp() throws Exception {
        //Create mock object
        mockedPersonRestController = mock(PersonRestController.class);

        //Create few instances of Person class.
        person1 = new Person();
        person1.setId("1230143594385");
        person1.setFirstName("Firstname1");
        person1.setLastName("Lastname1");

        person2 = new Person();
        person1.setId("9438512301435");
        person2.setFirstName("Firstname2");
        person2.setLastName("Lastname2");

        //Stubbing the methods of mocked PersonRestController with mocked data.
        when(mockedPersonRestController.getAll()).thenReturn(Arrays.asList(person1, person2));
        when(mockedPersonRestController.create(person1)).thenReturn(person1);
        when(mockedPersonRestController.update(person2.getId(), person2)).thenReturn(person2);
    }

    @Test
    public void getAll() throws Exception {
        List<Person> allPersons = mockedPersonRestController.getAll();
        assertEquals(2, allPersons.size());

        Person person = allPersons.get(0);
        assertEquals(person1.getId(), person.getId());
        assertEquals(person1.getFirstName(), person.getFirstName());
        assertEquals(person1.getLastName(), person.getLastName());
    }

    @Test
    public void create() throws Exception {
        Person person = mockedPersonRestController.create(person1);

        assertNotNull(person);
        assertEquals(person1.getId(), person.getId());
        assertEquals(person1.getFirstName(), person.getFirstName());
        assertEquals(person1.getLastName(), person.getLastName());
    }

    @Test
    public void update() throws Exception {
        person2.setLastName("UpdatedName");
        Person person = mockedPersonRestController.update(person2.getId(), person2);

        assertEquals(person2.getId(), person.getId());
        assertEquals(person2.getFirstName(), person.getFirstName());
        assertEquals(person2.getLastName(), person.getLastName());
    }

}