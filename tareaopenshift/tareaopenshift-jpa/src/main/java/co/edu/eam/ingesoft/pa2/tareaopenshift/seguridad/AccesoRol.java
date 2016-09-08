/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;

/**
 * @author Alejandro
 *
 */
@Entity
@IdClass(value=AccesoRolPK.class)
public class AccesoRol implements Serializable{
	
	@Id
	@ManyToOne
	private Rol rol;
	
	@Id
	@ManyToOne
	private Acceso acceso;

	public AccesoRol() {
		super();
	}

	//Constructor
	public AccesoRol(Rol rol, Acceso acceso) {
		super();
		this.rol = rol;
		this.acceso = acceso;
	}

	//Accesores y modificadores
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	
	
}
