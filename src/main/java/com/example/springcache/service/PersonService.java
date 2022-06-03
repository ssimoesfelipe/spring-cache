package com.example.springcache.service;

import com.example.springcache.model.Person;
import com.example.springcache.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository repository;

  public Person save(Person person) {
    return repository.save(person);
  }

  public Person findById(Long id) {
    return repository.findById(id).orElseThrow();
  }
}
