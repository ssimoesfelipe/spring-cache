package com.example.springcache.repository;

import com.example.springcache.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.Id;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
