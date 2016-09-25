/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

/**
 * @author Alejandro
 *
 */
public class RespuestaPregPK implements Serializable{
	
	private PregEvalPK idPregEval;
	
	private int idRespuesta;

	public RespuestaPregPK(PregEvalPK idPregEval, int idRespuesta) {
		super();
		this.idPregEval = idPregEval;
		this.idRespuesta = idRespuesta;
	}

	public RespuestaPregPK() {
		super();
	}

	/**
	 * @return the idPregEval
	 */
	public PregEvalPK getIdPregEval() {
		return idPregEval;
	}

	/**
	 * @param idPregEval the idPregEval to set
	 */
	public void setIdPregEval(PregEvalPK idPregEval) {
		this.idPregEval = idPregEval;
	}

	/**
	 * @return the idRespuesta
	 */
	public int getIdRespuesta() {
		return idRespuesta;
	}

	/**
	 * @param idRespuesta the idRespuesta to set
	 */
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPregEval == null) ? 0 : idPregEval.hashCode());
		result = prime * result + idRespuesta;
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
		RespuestaPregPK other = (RespuestaPregPK) obj;
		if (idPregEval == null) {
			if (other.idPregEval != null)
				return false;
		} else if (!idPregEval.equals(other.idPregEval))
			return false;
		if (idRespuesta != other.idRespuesta)
			return false;
		return true;
	}

}
