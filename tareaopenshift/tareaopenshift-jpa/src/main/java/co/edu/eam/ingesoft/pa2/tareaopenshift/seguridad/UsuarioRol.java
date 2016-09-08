/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

/**
 * @author Alejandro
 *
 */
@Entity
@IdClass(value=UsuarioRolPK.class)

public class UsuarioRol implements Serializable {
	
	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Rol rol;

	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRol() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	

}
