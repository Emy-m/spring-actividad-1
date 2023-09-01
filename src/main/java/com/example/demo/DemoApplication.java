package com.example.demo;

import com.example.demo.domain.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext stx) {
		return args -> {
			CursoRepository cursoRepository = stx.getBean(CursoRepository.class);
			cursoRepository.save(new Curso(null, "Curso de Java", "Curso de Java", LocalDate.now(), LocalDate.now().plusDays(10)));
			System.out.println(cursoRepository.findAll());
		};
	}

}
