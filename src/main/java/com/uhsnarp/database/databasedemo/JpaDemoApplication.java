package com.uhsnarp.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uhsnarp.database.databasedemo.entity.Person;
import com.uhsnarp.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", repository.findAll());
		LOGGER.info("User id 10001-> {}", repository.findById(10001));
		// LOGGER.info("Delete : 10002 -> {}", repository.deleteById(10002));
		LOGGER.info("Inserting : 10004 -> {}", repository.insert(new Person(10004, "Chcha", "Berlin", new Date())));
		LOGGER.info("Update : 10003 -> {}", repository.update(new Person(10003, "Mary", "Utrecht", new Date())));
		repository.deleteById(10002);

	}
}
