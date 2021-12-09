package com.clemen.proyecto;

import com.clemen.proyecto.entities.BillingInfo;
import com.clemen.proyecto.entities.User;
import com.clemen.proyecto.repository.BillingInfoRepository;
import com.clemen.proyecto.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProyectoApplication.class, args);

		//
		BillingInfoRepository billingInfoRepository =
				context.getBean(BillingInfoRepository.class);
		UserRepository userRepository =
				context.getBean(UserRepository.class);
		//Probamos
		BillingInfo info1 = new BillingInfo(null, "Ntra del Carmen", "29300", "Archidona", "Spain", "ES543254325432",null);
		billingInfoRepository.save(info1);

		User user1 = new User(null, "Clemen", "Pozo", "78787878H", true, LocalDate.of(1975, 12,3));
		user1.setBillingInfo(info1);
		userRepository.save(user1);


	}

}
