package com.example.demo;

import com.example.demo.models.Cab;
import com.example.demo.models.Gender;
import com.example.demo.models.User;
import com.example.demo.services.AvailabilityService;
import com.example.demo.services.CabRegisterService;
import com.example.demo.services.UserRegistrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		CabRegisterService registerService = new CabRegisterService();
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		AvailabilityService availabilityService = new AvailabilityService(registerService);

		for(int i =1 ; i<10 ; i++){
			Cab cab = new Cab("KA01 AB 123"+i);
			registerService.registerCabWithAggregator(cab);
			availabilityService.registerAvailability(cab);
		}

		for(int i =1 ; i<=10 ; i++){
			User male_user = new User("Male_"+i , Gender.MALE);
			User female_user = new User("Female_"+i , Gender.FEMALE);
			userRegistrationService.reegisterUser(male_user);
			userRegistrationService.reegisterUser(female_user);

		}



		User user = new User("A", Gender.MALE);
		SpringApplication.run(DemoApplication.class, args);


	}

}
