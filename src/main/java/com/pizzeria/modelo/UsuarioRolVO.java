package com.pizzeria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuariorol")
public class UsuarioRolVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuarioRol;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private UsuarioVO usuario;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private RolVO rol;

	public UsuarioRolVO() {
		super();
	}

	public UsuarioRolVO(UsuarioVO usuario, RolVO rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRolVO(Long idUsuarioRol, UsuarioVO usuario, RolVO rol) {
		super();
		this.idUsuarioRol = idUsuarioRol;
		this.usuario = usuario;
		this.rol = rol;
	}

	public Long getIdUsuarioRol() {
		return idUsuarioRol;
	}

	public void setIdUsuarioRol(Long idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuarioRol == null) ? 0 : idUsuarioRol.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRolVO other = (UsuarioRolVO) obj;
		if (idUsuarioRol == null) {
			if (other.idUsuarioRol != null)
				return false;
		} else if (!idUsuarioRol.equals(other.idUsuarioRol))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioRolVO [idUsuarioRol=" + idUsuarioRol + ", usuario=" + usuario.getIdUsuario() + ", rol=" + rol.getIdRol() + "]";
	}
	
}
