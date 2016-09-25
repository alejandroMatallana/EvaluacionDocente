/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespPreg;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class RespPreguEJB extends EJBGenerico<RespPreg> implements Serializable {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return RespPreg.class;
	}

	/**
	 * Metodo para crear 
	 */
	public void crear(RespPreg respuPregu){
		dao.crear(respuPregu);
	}
	
	/**
	 * Metodo para buscar
	 */
	public RespPreg buscar(Object pk){
		return dao.buscar(pk);
	}
}
