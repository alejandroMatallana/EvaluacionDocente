/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

/**
 * @author Alejandro
 *
 */
public class PregEvalPK implements Serializable{

	
	private int idPregunta;
	
	private int idEvaluacion;

	public PregEvalPK(int idPregunta, int idEvaluacion) {
		super();
		this.idPregunta = idPregunta;
		this.idEvaluacion = idEvaluacion;
	}

	public PregEvalPK() {
		super();
	}

	/**
	 * @return the idPregunta
	 */
	public int getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the idEvaluacion
	 */
	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	/**
	 * @param idEvaluacion the idEvaluacion to set
	 */
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvaluacion;
		result = prime * result + idPregunta;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PregEvalPK other = (PregEvalPK) obj;
		if (idEvaluacion != other.idEvaluacion)
			return false;
		if (idPregunta != other.idPregunta)
			return false;
		return true;
	}
}
