package com.clemen.proyecto;

import com.clemen.proyecto.entities.BillingInfo;
import com.clemen.proyecto.entities.Task;
import com.clemen.proyecto.entities.User;
import com.clemen.proyecto.repository.BillingInfoRepository;
import com.clemen.proyecto.repository.TaskRepository;
import com.clemen.proyecto.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ProyectoApplication.class, args);

		//BillingInfo relacion con User
		BillingInfoRepository billingInfoRepository =
				context.getBean(BillingInfoRepository.class);
		UserRepository userRepository =
				context.getBean(UserRepository.class);
		//Probamos
		BillingInfo info1 = new BillingInfo(null, "Ntra del Carmen", "29300", "Archidona", "Spain", "ES543254325432",null);
		BillingInfo info2 = new BillingInfo(null, "ELM", "29310", "Archidona", "Spain", "ES543254325428",null);
		billingInfoRepository.save(info1);
		billingInfoRepository.save(info2);

		User user1 = new User(null, "Clemen", "Pozo", "78787878H", true, LocalDate.of(1975, 12,3));
		User user2 = new User(null, "Alex", "Gomez", "78745878H", true, LocalDate.of(1978, 12,3));
		user1.setBillingInfo(info1);
		user2.setBillingInfo(info2);
		userRepository.save(user1);
		userRepository.save(user2);

		// Task relacion con User Pruebas
		TaskRepository taskRepository = context.getBean(TaskRepository.class);
		Task task1 = new Task(null, "Estudiar JUnit", "Curso OB Java", false, LocalDate.of(2021,12,9),user1);
		Task task2 = new Task(null, "Estudiar React", "Curso OB React", true, LocalDate.of(2021,9,9),user1);
		Task task3 = new Task(null, "Estudiar JS", "Curso JS", false, LocalDate.of(2021,12,11),user2);
		Task task4 = new Task(null, "Estudiar Python", "Curso Python", true, LocalDate.of(2021,3,11),user2);

		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);


		System.out.println("Fin ...");
	}

}
