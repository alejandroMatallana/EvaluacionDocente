package co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote;

import java.util.List;

import co.edu.eam.ingesoft.pa2.tareaopenshift.interfaces.InterfaceEJBGenerica;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

public interface UsuarioRemotoEJB extends InterfaceEJBGenerica<Usuario>{

	public List<Usuario> buscarPorUsuarios(Object pk);
	
}
