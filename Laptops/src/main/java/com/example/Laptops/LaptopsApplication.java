package com.example.Laptops;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Laptops.entities.Laptop;
import com.example.Laptops.service.LaptopService;

@SpringBootApplication
public class LaptopsApplication implements CommandLineRunner{

	@Autowired
	LaptopService laptopService;
	public static void main(String[] args) {
		SpringApplication.run(LaptopsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*laptopService.saveLaptop(new Laptop("LENOVO",1200.0,"8gb ram ddr4 512gb stockage",new Date()));
		laptopService.saveLaptop(new Laptop("HP",1300.0,"8gb ram ddr4 512gb stockage",new Date()));
		laptopService.saveLaptop(new Laptop("CONDOR",1400.0,"12gb ram ddr4 512gb stockage",new Date()));
		laptopService.saveLaptop(new Laptop("MSI",5200.0,"64gb ram ddr5 2to stockage",new Date()));*/
		
	}

}
