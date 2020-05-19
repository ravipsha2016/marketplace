package com.example.demo;

import com.example.demo.models.Cab;
import com.example.demo.models.Geneder;
import com.example.demo.models.Passenger;
import com.example.demo.services.AvailabilityService;
import com.example.demo.services.BookingService;
import com.example.demo.services.CabRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		CabRegisterService registerService = new CabRegisterService();
		AvailabilityService availabilityService = new AvailabilityService(registerService);

		for(int i =1 ; i<10 ; i++){
			Cab cab = new Cab("KA01 AB 123"+i);
			registerService.registerCabWithAggregator(cab);
			availabilityService.registerAvailability(cab);

		}



		Passenger passenger = new Passenger("A", Geneder.MALE);
		SpringApplication.run(DemoApplication.class, args);


	}

}
