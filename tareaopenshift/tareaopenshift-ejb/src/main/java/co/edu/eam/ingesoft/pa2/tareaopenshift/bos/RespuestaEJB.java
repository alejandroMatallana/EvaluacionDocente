/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Respuesta;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class RespuestaEJB extends EJBGenerico<Respuesta> implements Serializable {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Respuesta.class;
	}
	
	/**
	 * Metodo para crear una respuesta
	 * @param respuesta
	 */
	public void crearRes(Respuesta respuesta){
		dao.crear(respuesta);
	}
	
	/**
	 * Metodo para buscar una respuesta
	 */
	public Respuesta buscar (Object pk){
		return dao.buscar(pk);
	}
	
}
