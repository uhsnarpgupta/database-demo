package com.uhsnarp.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uhsnarp.database.databasedemo.entity.Person;
import com.uhsnarp.database.databasedemo.springdata.SpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", repository.findAll());
		repository.deleteById(10002);
		LOGGER.info("User id 10001-> {}", repository.findById(10001));
		LOGGER.info("Inserting : 10004 -> {}", repository.save(new Person(10004, "Chcha", "Berlin", new Date())));
		LOGGER.info("Update : 10003 -> {}", repository.save(new Person(10003, "Mary", "Utrecht", new Date())));

	}
}
