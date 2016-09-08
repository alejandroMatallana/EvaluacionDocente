package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Messages.Message;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.SeguridadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

@Named("SesionBean")
@SessionScoped
public class SesionBean implements Serializable {

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SesionBean.class);


	private String nombreUser;

	private String password;

	private List<Acceso> accesos;

	private List<Rol> roles;

	private Usuario usuari;

	@EJB
	private UsuarioEJB usuario;
	
	@EJB
	private SeguridadEJB seguridadEJB;

	public String login() {
		Usuario usu = null;
		if (!usuario.buscarPorUsuarios(nombreUser).isEmpty()) {
			 usu = usuario.buscarPorUsuarios(nombreUser).get(0);
			password = MD5Util.code(password);
			}
			if (usu != null && password.equals(usu.getPassword())) {
				usuari = usu;
				roles = seguridadEJB.listarRolesUsuario(usuari);
				System.out.println(roles.size()+"-----------1");
				accesos = seguridadEJB.listarAccesoRol(roles);
				System.out.println(accesos.size()+"-----------2");

				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicio de sesion exitoso",
						null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "/paginas/inicio.jsf?faces-redirect=true";
			
			}else {
				usuari = null;
				roles = null;
				accesos = null;
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o contraseña incorrecta",
						null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
	}

	/**
	 * Metodo que valida si hay sesion
	 * 
	 * @return
	 */
	public boolean islogged() {
		return this.usuari != null;
	}

	public String LogOut() {
		Faces.getSession().invalidate();
		return "/index.jsf?faces-redirect=true";
	}

	public UsuarioEJB getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEJB usuario) {
		this.usuario = usuario;
	}

	public String getNombreUser() {
		return nombreUser;
	}

	public void setNombreUser(String nombreUser) {
		this.nombreUser = nombreUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
