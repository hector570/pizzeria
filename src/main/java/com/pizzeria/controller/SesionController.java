package com.pizzeria.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizzeria.modelo.UsuarioVO;
import com.pizzeria.servicios.ServicioUsuario;
import com.pizzeria.utils.UsuarioUtils;
import com.pizzeria.utils.Utils;

@Controller
@RequestMapping("/")
public class SesionController {
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@Autowired
	UsuarioUtils usuarioUtils;
	
	@RequestMapping("/login")
	public String login(Authentication authentication) {
		String resultado;
		
		if (Utils.isLogged(authentication)) {
			resultado = "redirect:/home";
		} else {
			resultado = "login";
		}
		
		return resultado;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String mostrarFormRegistro(Model model, @RequestParam(required=false) String error,
			Authentication authentication) {
	    String resultado;
	    
	    if (!Utils.isLogged(authentication)) {
	    	model.addAttribute("usuario", new UsuarioVO());
		    model.addAttribute("error", error);
		    
		    resultado = "registro";
	    } else {
	    	resultado = "redirect:/home";
	    }
	    
	    
	    return resultado;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public String registrarse(Model model, UsuarioVO usuario, HttpServletRequest request) {
		
		String resultado = "redirect:";
		
		//añade roles, pone como enabled al usuario y encripta la contraseña
		usuarioUtils.transformarUsuario(usuario);
		
		//comprobamos que el nombre y la contraseña no se hayan rellenado solo con espacios en blanco
		if (usuarioUtils.validarUsuario(usuario)) {
			
			try{
				//insertamos al usuario
				servicioUsuario.save(usuario);
				
				//hace un login automatica al usuario
				autologin(usuario, request);
				
				resultado += "/home";
				
			} catch (DataIntegrityViolationException e) {
				
				//si el error es que es una clave duplicada
				if(e.getMostSpecificCause() instanceof SQLIntegrityConstraintViolationException){
					
					resultado += "/registro?error=Ya hay un usuario registrado con ese nombre.";
					
					//si no es que el nombre es demasiado largo
				} else {
					resultado += "/registro?error=El nombre de usuario es demasiado largo";
				}
				
			}
			
			//se han metido solo espacios en el usuario o la contraseña
		} else {
			resultado += "/registro?error=El nombre de usuario y la contrase%C3%B1a no pueden estar vac%C3%ADos";
			
		}
		
		return resultado;
	}
	
	//loguea a un usuario a partir de su usuario y su contraseña
	//este metodo solo es llamado justo despues de que un usuario se registre, si se hace un login normal lo tratara el propio spring
	public void autologin(UsuarioVO usuario, HttpServletRequest request) {
		
		UserDetails userDetails = servicioUsuario.loadUserByUsername(usuario.getNombre());
		
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
	}
}
