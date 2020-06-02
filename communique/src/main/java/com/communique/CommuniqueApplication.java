package com.communique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.communique.repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CommuniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommuniqueApplication.class, args);
	}

}
