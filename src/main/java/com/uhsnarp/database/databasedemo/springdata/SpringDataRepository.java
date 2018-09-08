package com.uhsnarp.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhsnarp.database.databasedemo.entity.Person;

public interface SpringDataRepository extends JpaRepository<Person, Integer> {

}
