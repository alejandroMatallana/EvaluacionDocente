/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.PregEval;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class PregEvalEJB extends EJBGenerico<PregEval> implements Serializable{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return PregEval.class;
	}

	/**
	 * MEtodo para crear 
	 */
	public void crear(PregEval preguEvalu){
		dao.crear(preguEvalu);
	}
	
	/**
	 * Metodo para buscar
	 */
	public PregEval buscar(Object pk){
		return dao.buscar(pk);
	}
}
