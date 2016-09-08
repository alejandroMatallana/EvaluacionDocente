/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name=Acceso.LISTAR_ACCESOS_POR_ROL, query="SELECT acc FROM AccesoRol acrol JOIN acrol.rol ro JOIN acrol.acceso acc WHERE acrol.rol IN ?1")
})
public class Acceso implements Serializable{

	public static final String LISTAR_ACCESOS_POR_ROL ="Acceso.listarPorRoles";
	
	
	@Id
	@SequenceGenerator(name = "accesos_seq", sequenceName = "accesos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accesos_seq")
	private long id;
	
	
	private String url;
	
	private String nombre;

	//Constructor vacio
	public Acceso() {
		super();
	}

	public Acceso(long id, String url, String nombre) {
		super();
		this.id = id;
		this.url = url;
		this.nombre = nombre;
	}

	//Accesores y modificadores
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
