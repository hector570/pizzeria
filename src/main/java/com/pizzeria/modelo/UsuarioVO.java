package com.pizzeria.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(unique=true, nullable = false, length = 30)
	private String nombre;
	
	private String password;
	private boolean enabled;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<UsuarioRolVO> lUsuarioRol;

	public UsuarioVO() {
		super();
		
		lUsuarioRol = new ArrayList<UsuarioRolVO>();
	}

	public UsuarioVO(String nombre, String password, boolean enabled, List<UsuarioRolVO> lUsuarioRol) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.enabled = enabled;
		this.lUsuarioRol = lUsuarioRol;
	}

	public UsuarioVO(int idUsuario, String nombre, String password, boolean enabled, List<UsuarioRolVO> lUsuarioRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.enabled = enabled;
		this.lUsuarioRol = lUsuarioRol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<UsuarioRolVO> getlUsuarioRol() {
		return lUsuarioRol;
	}

	public void setlUsuarioRol(List<UsuarioRolVO> lUsuarioRol) {
		this.lUsuarioRol = lUsuarioRol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + idUsuario;
		result = prime * result + ((lUsuarioRol == null) ? 0 : lUsuarioRol.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UsuarioVO other = (UsuarioVO) obj;
		if (enabled != other.enabled)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (lUsuarioRol == null) {
			if (other.lUsuarioRol != null)
				return false;
		} else if (!lUsuarioRol.equals(other.lUsuarioRol))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + ", enabled="
				+ enabled + ", lUsuarioRol=" + lUsuarioRol + "]";
	}
}
