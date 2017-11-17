package com.greenfox.kaghee.orientationexam;

import com.greenfox.kaghee.orientationexam.models.LicencePlate;
import com.greenfox.kaghee.orientationexam.repos.PlateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class OrientationExamApplication implements CommandLineRunner{
 	@Autowired
	PlateRepo plateRepo;

	public static void main(String[] args) {
		SpringApplication.run(OrientationExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		plateRepo.save(new LicencePlate("MXS-803", "Subaru", "Legacy", "Pink", 2001));
		plateRepo.save(new LicencePlate("BFH-682", "Cadillac", "CTS", "Yellow", 2004));
		plateRepo.save(new LicencePlate("QQG-264", "Pontiac", "Grand Prix", "Fuscia", 1964));
		plateRepo.save(new LicencePlate("RB99-01", "Audi", "R8", "White", 2011));
		plateRepo.save(new LicencePlate("JUO-705", "Infiniti", "M", "Crimson", 2004));
		plateRepo.save(new LicencePlate("CICA-01", "Pontiac", "Grand Am", "Aquamarine", 1991));
	}
}
