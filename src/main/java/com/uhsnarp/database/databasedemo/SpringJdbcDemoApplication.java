package com.uhsnarp.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uhsnarp.database.databasedemo.entity.Person;
import com.uhsnarp.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", personJdbcDao.findAll());
		LOGGER.info("User id 10001-> {}", personJdbcDao.findById(10001));
		LOGGER.info("Location : New York -> {}", personJdbcDao.findByLocation("New York"));
		LOGGER.info("Name : Uhsnarp -> {}", personJdbcDao.findByName("Uhsnarp"));
		LOGGER.info("Delete : 10002 -> {}", personJdbcDao.deleteById(10002));
		LOGGER.info("Inserting : 10004 -> {}", personJdbcDao.insert(new Person(10004, "Chcha", "Berlin", new Date())));
		LOGGER.info("Update : 10003 -> {}", personJdbcDao.update(new Person(10003, "Mary", "Utrecht", new Date())));

	}
}
