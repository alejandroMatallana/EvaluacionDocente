/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.AccesoRol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.UsuarioRol;

/**
 * @author Alejandro
 *
 */
@Stateless
@LocalBean
public class SeguridadEJB extends EJBGenerico<Usuario> {


	public List<Rol> listarRolesUsuario(Usuario usuario){
		return dao.ejecutarNamedQuery(Rol.LISTA_ROLES_POR_USUARIOS, usuario);
	}
	
	public List<Acceso> listarAccesoRol(List<Rol> roles){
		return dao.ejecutarNamedQuery(Acceso.LISTAR_ACCESOS_POR_ROL, roles);
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}
	
}
