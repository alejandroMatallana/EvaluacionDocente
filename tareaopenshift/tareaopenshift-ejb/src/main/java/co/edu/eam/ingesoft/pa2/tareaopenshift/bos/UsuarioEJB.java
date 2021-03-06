package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.UsuarioRemotoEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;


@LocalBean
@Stateless
@Remote(UsuarioRemotoEJB.class)
public class UsuarioEJB extends EJBGenerico<Usuario> implements UsuarioRemotoEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	/**
	 * Metodo para crear un usuario
	 */
	public void crear(Usuario usuario) throws ExcepcionNegocio {
		if (buscar(usuario.getId()) != null) {
			throw new ExcepcionNegocio("El usuario ya se encuentra registrado");
		} else {
			dao.crear(usuario);
		}
	}

	/**
	 * Metodo para buscar un usuario por su id
	 */
	public Usuario buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	@Override
	public List<Usuario> buscarPorUsuarios(Object pk){
		return dao.ejecutarNamedQuery(Usuario.BUSCAR_USER, pk);
	}

}
