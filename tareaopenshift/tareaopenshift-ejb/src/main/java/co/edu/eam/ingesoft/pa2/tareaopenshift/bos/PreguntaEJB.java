/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.tareaopenshift.ejbremote.PreguntaRemoteEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.implementacion.EJBGenerico;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
@Remote(PreguntaRemoteEJB.class)
public class PreguntaEJB extends EJBGenerico<Pregunta> implements PreguntaRemoteEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Pregunta.class;
	}

	/**
	 * Metodo para crear las preguntas
	 */
	public void crear(Pregunta pregunta) {
		dao.crear(pregunta);
	}

}
