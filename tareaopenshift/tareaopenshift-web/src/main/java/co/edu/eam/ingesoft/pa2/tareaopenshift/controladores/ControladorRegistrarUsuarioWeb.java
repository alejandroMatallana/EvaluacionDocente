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
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor.ExcepcionLogger;
import co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor.Secured;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Coordinador;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Decano;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.MD5Util;

@Named("usuarioWeb")
@ViewScoped
@ExcepcionLogger
public class ControladorRegistrarUsuarioWeb implements Serializable {

	
	private Facultad facultadEnti;

	private Programa programaEnti;
	
	/**
	 * EJB de usuario
	 */
	@EJB
	private UsuarioEJB usuarioEJB;

	/**
	 * EJB Programa
	 */
	@EJB
	private ProgramaEJB programaEJB;
	
	/**
	 * EJB Facultad
	 */
	@EJB
	private FacultadEJB facultadEJB;

	/**
	 * Identificacion del usuario
	 */
	private int id;

	/**
	 * nombre del usuario
	 */
	private String nombre;

	/**
	 * apellido del usuario
	 */
	private String apellido;

	/**
	 * usuario del usuario
	 */
	private String user;

	/**
	 * contraseña del usuario
	 */
	private String password;

	/**
	 * El programa del coordinador
	 */
	private String idPrograma;

	/**
	 * La facultad del decano
	 */
	private String idFacultad;

	private String usuarioSeleccionado;

	private List<Programa> programa;
	private List<Facultad> facultad;

	/**
	 * crea un usuario
	 */
	@Secured
	public void crear() {
		if (nombre != null && id != 0 && apellido != null && user != null && password != null) {
			if (usuarioSeleccionado.equals("0")) {
				password =  MD5Util.code(password);// Esto es para cifrar las contraseñas
				Coordinador c = new Coordinador(nombre, apellido, user, password, id, programaEnti);
				usuarioEJB.crear(c);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Coordinador fue registrado con exito",  null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else if (usuarioSeleccionado.equals("1")) {
				password =  MD5Util.code(password);// Esto es para cifrar las contraseñas
				Decano d = new Decano(nombre, apellido, user, password, id, facultadEnti);
				usuarioEJB.crear(d);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Decano fue registrado con exito",  null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} else {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor llene los campos para continuar", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public void cargarFacultadPrograma() {

		if (usuarioSeleccionado.equals("0")) {
			facultad = null;
			programa = programaEJB.listarPrograma();
		} else {
			programa = null;
			facultad = facultadEJB.listarFacultad();
		}
	}

	@PostConstruct
	public void inicializar() {
		facultad = new LinkedList<>();
		programa = programaEJB.listarPrograma();
		usuarioSeleccionado = "0";
	}

	/**
	 * Metodo para renderizar
	 * @return
	 */
	public boolean usuarioSelecFacul(){
		if (usuarioSeleccionado.equals("1")) {
			facultad= facultadEJB.listarFacultad();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean usuarioSelecProgra(){
		if (usuarioSeleccionado.equals("0")) {
			programa = programaEJB.listarPrograma();
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * busca un usuario por su cedula
	 * 
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	public void buscar() {

	}

	public String getApellido() {
		return apellido;
	}

	public int getId() {
		return id;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public String getIdPrograma() {
		return idPrograma;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(String usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Programa> getPrograma() {
		return programa;
	}

	public void setPrograma(List<Programa> programa) {
		this.programa = programa;
	}

	public List<Facultad> getFacultad() {
		return facultad;
	}

	public void setFacultad(List<Facultad> facultad) {
		this.facultad = facultad;
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
