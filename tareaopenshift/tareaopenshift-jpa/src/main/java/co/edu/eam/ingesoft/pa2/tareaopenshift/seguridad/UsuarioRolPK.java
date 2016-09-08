/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */

public class UsuarioRolPK implements Serializable {

	private int usuario;

	private Long rol;

	// Constructor vacio
	public UsuarioRolPK() {
		super();
	}

	public UsuarioRolPK(int usuario, long rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	// Accesores y modificadores

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public Long getRol() {
		return rol;
	}

	public void setRol(Long rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((String.valueOf(usuario) == null) ? 0 : String.valueOf(usuario).hashCode());
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
		UsuarioRolPK other = (UsuarioRolPK) obj;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (String.valueOf(usuario) == null) {
			if (String.valueOf(usuario) != null)
				return false;
		} else if (!String.valueOf(usuario).equals(other.usuario))
			return false;
		return true;
	}

}
