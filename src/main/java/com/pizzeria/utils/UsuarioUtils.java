package com.pizzeria.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pizzeria.modelo.RolVO;
import com.pizzeria.modelo.UsuarioRolVO;
import com.pizzeria.modelo.UsuarioVO;
import com.pizzeria.servicios.ServicioRol;

public class UsuarioUtils {
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	ServicioRol rolService;
	
	public void transformarUsuario(UsuarioVO usuario) {
		
		//añadimos el rol al usuario
		//(cuando se registran tienen el rol de usuario que tiene el id 1)
		RolVO rol = rolService.findById(1).get();
		UsuarioRolVO usuRol = new UsuarioRolVO(usuario, rol);
		usuario.getlUsuarioRol().add(usuRol);
		
		//el usuario por defecto esta activado
		usuario.setEnabled(true);
	
		if (Utils.validarCadena(usuario.getPassword())) {
			//encriptamos la contraseña
			usuario.setPassword(pwEncoder.encode(usuario.getPassword()));
		}
	}
	
	public boolean validarUsuario(UsuarioVO usuario) {
		
		return Utils.validarCadena(usuario.getNombre()) && Utils.validarCadena(usuario.getPassword());
		
	}
	
}
