package com.pizzeria.utils;

import org.springframework.security.core.Authentication;

public class Utils {

	//numeros de elementos por pagina
	public static final int PAGESIZE = 20;
	
	public static final String ERRORPEDIDO404 = "redirect:/pedidos?error=No se ha podido realizar la operaci%C3%B3n. Esa pizza ya no existe";
	public static final String ERRORRESERVA404 = "redirect:/reservas?error=No se ha podido realizar la operaci%C3%B3n. Esa reserva ya no existe";
	//comprueba si hay un usuario con la sesion iniciada
	public static boolean isLogged(Authentication authentication) {
		return authentication != null && authentication.isAuthenticated();
	}
	
	//comprueba que una cadena no es ni null ni esta vacia
	public static boolean validarCadena(String cadena) {
		return cadena != null && !cadena.trim().isEmpty();
	}
}