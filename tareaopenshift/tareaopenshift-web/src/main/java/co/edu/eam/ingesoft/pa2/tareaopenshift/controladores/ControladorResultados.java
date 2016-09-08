package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.FacultadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor.ExcepcionLogger;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

@Named("resultadoWeb")
@ViewScoped
@ExcepcionLogger
public class ControladorResultados implements Serializable {

	
	private Facultad facultadEnti;
	
	private Programa programaEnti;
	
	
	@EJB
	private FacultadEJB facultadEJB;
	
	@EJB
	private ProgramaEJB programaEJB;
	
	private List<Facultad> facultad;
	
	private List<Programa> programa;

	public List<Facultad> getFacultad() {
		facultad = facultadEJB.listarFacultad();
		return facultad;
	}

	public void setFacultad(List<Facultad> facultad) {
		this.facultad = facultad;
	}

	public List<Programa> getPrograma() {
		programa = programaEJB.listarPrograma();
		return programa;
	}

	public void setPrograma(List<Programa> programa) {
		this.programa = programa;
	}

	public Facultad getFacultadEnti() {
		return facultadEnti;
	}

	public void setFacultadEnti(Facultad facultadEnti) {
		this.facultadEnti = facultadEnti;
	}

	public Programa getProgramaEnti() {
		return programaEnti;
	}

	public void setProgramaEnti(Programa programaEnti) {
		this.programaEnti = programaEnti;
	}
	
	
	
}
