/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.dto;

import java.util.List;

/**
 * @author Alejandro
 *
 */
public class RespuestaEvaluacionDTO {

	
	private List<RespuestaPreguntaDTO> respuestaDTO;
	
	private String idGrupo;
	private String comentario;
	private String codigoEstudiante;
	
	//Constructor
	public RespuestaEvaluacionDTO() {
		super();
	}

	//Constructor	
	public RespuestaEvaluacionDTO(List<RespuestaPreguntaDTO> respuestaDTO, String idGrupo, String comentario,
			String codigoEstudiante) {
		super();
		this.respuestaDTO = respuestaDTO;
		this.idGrupo = idGrupo;
		this.comentario = comentario;
		this.codigoEstudiante = codigoEstudiante;
	}

	/**
	 * @return the respuestaDTO
	 */
	public List<RespuestaPreguntaDTO> getRespuestaDTO() {
		return respuestaDTO;
	}

	/**
	 * @param respuestaDTO the respuestaDTO to set
	 */
	public void setRespuestaDTO(List<RespuestaPreguntaDTO> respuestaDTO) {
		this.respuestaDTO = respuestaDTO;
	}

	/**
	 * @return the idGrupo
	 */
	public String getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the codigoEstudiante
	 */
	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	/**
	 * @param codigoEstudiante the codigoEstudiante to set
	 */
	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	
}
