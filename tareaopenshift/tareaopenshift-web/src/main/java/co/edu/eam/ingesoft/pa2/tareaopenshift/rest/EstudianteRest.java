/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.rest;


import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.WsdlEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaEvaluacionDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;

/**
 * @author Alejandro
 *
 */
@Path("/estudiante")
public class EstudianteRest {

	@EJB
	private WsdlEJB wsdlEJB;
	
	@EJB
	private PreguntaEJB preguntaEJB;

	@GET
	@Path("/buscarEstudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarEstudiante(@QueryParam(value = "codi") String codigo,
			@QueryParam(value = "cedu") String cedula) {

		if (wsdlEJB.buscarCursos(codigo, cedula) == false) {
			return new RespuestaDTO(false, "no esta", "3");
		}
		return new RespuestaDTO(true);
	}

	@GET
	@Path("/gruposestudiante")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO gruposEstudiante(@QueryParam(value = "codi") String codigo,
			@QueryParam(value = "cedu") String cedula) {
		List<Grupo> lista = wsdlEJB.cursosEstudiante(codigo, cedula);
		return new RespuestaDTO(lista);
	}	
	
	@GET
	@Path("/listaPregunta")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listaPreguntas(){
		List<Pregunta> lista = preguntaEJB.listarPreguntas();
		return new RespuestaDTO(lista);
	}
	
	@POST
	@Path("/calificar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO calificarEvaluacion(RespuestaEvaluacionDTO res){
		wsdlEJB.responderEval(res);
		return new RespuestaDTO("No esta");
	}
	
}
