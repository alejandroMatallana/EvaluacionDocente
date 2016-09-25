/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.AsignaturaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Docente;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class DocenteEJB extends EJBGenerico<Docente> implements Serializable {

	/**
	 * Metodo para crear un docente
	 */
	public void crear(Docente docente){
		dao.crear(docente);
	}

	/**
	 * Metodo para buscar un docente
	 */
	public Docente buscar(Object pk){
		return dao.buscar(pk);
	}
	
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Docente.class;
	}
}
