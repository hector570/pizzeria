package com.pizzeria;

import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S4JpaSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(S4JpaSpringWebApplication.class, args);
		
		//los usuarios que se crean por defecto son admin:temporal que tiene roles de admin
		//y registrado:temporal que tiene roles de usuario
		Persistence.generateSchema("pizzeria", null);
	}

}

