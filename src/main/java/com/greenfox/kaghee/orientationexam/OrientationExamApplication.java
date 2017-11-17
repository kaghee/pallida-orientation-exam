package com.greenfox.kaghee.orientationexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class OrientationExamApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OrientationExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
