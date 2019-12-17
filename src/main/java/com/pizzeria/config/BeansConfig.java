package com.pizzeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pizzeria.utils.UsuarioUtils;

@Configuration
public class BeansConfig {

	@Bean
	public UsuarioUtils getUsuarioUtils() {
		return new UsuarioUtils();
	}
}
