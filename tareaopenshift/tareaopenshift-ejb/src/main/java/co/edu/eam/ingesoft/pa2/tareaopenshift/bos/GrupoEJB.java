/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Grupo;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class GrupoEJB extends EJBGenerico<Grupo> implements Serializable{

	
	public void crear(Grupo grupo){
		dao.crear(grupo);
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Grupo.class;
	}
	
	public Grupo buscar(Object pk){
		return dao.buscar(pk);
	}
}
