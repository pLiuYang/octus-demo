package com.octustest.controllers;

import com.octustest.models.Person;
import com.octustest.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liuyang on 2/21/2017.
 */

@RestController
@RequestMapping("/person")
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method= RequestMethod.GET)
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id) {
        personRepository.delete(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Person update(@PathVariable String id, @RequestBody Person person) {
        Person update = personRepository.findOne(id);
        update.setFirstName(person.getFirstName());
        update.setLastName(person.getLastName());
        return personRepository.save(update);
    }
}
