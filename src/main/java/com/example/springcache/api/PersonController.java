package com.example.springcache.api;

import com.example.springcache.model.Person;
import com.example.springcache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PersonController {

  private final PersonService service;

  @GetMapping("/hello")
  @Cacheable("hello")
  public String hello(){
    System.out.println("Chamada sem cache!");
    return "Hello World!";
  }

  @GetMapping("/delete-hello")
  @CacheEvict("hello")
  public String deleteHello() {
    System.out.println("Apagando o cache!");
    return "Hello World!";
  }

  @PostMapping("/save")
  public Person save(@RequestBody Person person) {
    return service.save(person);
  }

  @GetMapping("/find-by-id/{id}")
  @Cacheable("person")
  public Person findById(@PathVariable("id") Long id) {
    System.out.println("Chamada sem cache!");
    return service.findById(id);
  }

}
