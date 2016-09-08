/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.FacultadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor.ExcepcionLogger;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

/**
 * @author Alejandro
 *
 */
@Named("programaWeb")
@ViewScoped
@ExcepcionLogger
public class ControladorRegistrarPrograma implements Serializable {


	private Facultad facultadEnti;
	
	private String nombrePrograma;
	
	private String id;
	
	private String idFacultad;
	
	@EJB	
	private ProgramaEJB programaEJB;
	
	@EJB
	private FacultadEJB facultadEJB;
	
	private List<Facultad> facultad;
	
	public void crear(){
		
		Programa p = new Programa(id, nombrePrograma, facultadEnti);
		programaEJB.crear(p);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El programa fue registrado con exito",  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Facultad getFacultadEnti() {
		return facultadEnti;
	}

	public void setFacultadEnti(Facultad facultadEnti) {
		this.facultadEnti = facultadEnti;
	}

	public String getNombrePrograma() {
		return nombrePrograma;
	}

	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<Facultad> getFacultad() {
		facultad = facultadEJB.listarFacultad();
		return facultad;
	}

	public void setFacultad(List<Facultad> facultad) {
		this.facultad = facultad;
	}
	
	
	@PostConstruct
	public void inicializar() {
		facultad = new LinkedList<>();
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}
	
	
	
}
