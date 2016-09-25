/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.Curso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.Estudiante;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.ServiciosEducativosService;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaEvaluacionDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaPreguntaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Docente;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Evaluacion;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.PregEval;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespPreg;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Respuesta;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.RespuestaPregPK;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class WsdlEJB implements Serializable {

	@EJB
	private AsignaturaEJB asignaturaEJB;

	@EJB
	private ProgramaEJB programaEJB;

	@EJB
	private FacultadEJB facultadEJB;

	@EJB
	private GrupoEJB grupoEJB;

	@EJB
	private DocenteEJB docenteEJB;
	
	@EJB
	private PreguntaEJB preguntaEJB;
	
	@EJB
	private RespuestaEJB respuestaEJB;
	
	@EJB
	private PregEvalEJB pregEvalEJB;
	
	@EJB
	private RespPreguEJB resPreguEJB;

	private Facultad f;
	private Programa p;

	/**
	 * Metodo que busca si hay un estudiante con un codigo y una cedula
	 * 
	 * @param codigo
	 * @param cedula
	 * @return true si encuentra el estudiante, false si no lo encuentra
	 */
	public boolean buscarCursos(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		Estudiante e = servicio.consultaEstudiante(codigo, cedula);
		if (e != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para crear una asignatura
	 * 
	 * @param codigo
	 * @param cedula
	 */
	public void crearAsignatura(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		List<Curso> dto = servicio.consultarCursosEstudiante(codigo, cedula);
		for (int i = 0; i < dto.size(); i++) {

			Facultad facul = facultadEJB.buscar(dto.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
			if (facul == null) {
				f = new Facultad();
				f.setIdFacultad(dto.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
				f.setNombre(dto.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
				facultadEJB.crear(f);
			}

			Programa progra = programaEJB.buscar(dto.get(i).getAsignatura().getPrograma().getCodigo());
			if (progra == null) {
				p = new Programa();
				p.setIdFacultad(f);
				p.setIdPrograma(dto.get(i).getAsignatura().getPrograma().getCodigo());
				p.setNombrePrograma(dto.get(i).getAsignatura().getPrograma().getNombre());

				programaEJB.crear(p);
			}

			Asignatura asig = asignaturaEJB.buscar(dto.get(i).getAsignatura().getCodigo());
			if (asig == null) {
				Asignatura a = new Asignatura();
				a.setIdPrograma(p);
				a.setIdAsignatura(dto.get(i).getAsignatura().getCodigo());
				a.setNombreAsignatura(dto.get(i).getAsignatura().getNombre());
				asignaturaEJB.crear(a);

			}

		}
	}

	/**
	 * Metodo para añadir un curso a una lista
	 * 
	 * @param codigo,
	 *            el codigo del estudiante
	 * @param cedula,
	 *            la cedula del estudiante
	 */
	public List<Grupo> cursosEstudiante(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		List<Curso> cursosEstu = servicio.consultarCursosEstudiante(codigo, cedula);

		List<Grupo> lista = new ArrayList<Grupo>();

		for (int i = 0; i < cursosEstu.size(); i++) {

			Facultad facul = facultadEJB
					.buscar(cursosEstu.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
			if (facul == null) {
				facul = new Facultad();
				facul.setIdFacultad(cursosEstu.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
				facul.setNombre(cursosEstu.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
				facultadEJB.crear(facul);
			}

			Programa progra = programaEJB.buscar(cursosEstu.get(i).getAsignatura().getPrograma().getCodigo());
			if (progra == null) {
				progra = new Programa();
				progra.setIdFacultad(facul);
				progra.setIdPrograma(cursosEstu.get(i).getAsignatura().getPrograma().getCodigo());
				progra.setNombrePrograma(cursosEstu.get(i).getAsignatura().getPrograma().getNombre());
				programaEJB.crear(progra);
			}

			Docente docen = docenteEJB.buscar(cursosEstu.get(i).getDocente().getCodigodocente());
			if (docen == null) {
				docen = new Docente();
				docen.setId(cursosEstu.get(i).getDocente().getCodigodocente());
				docen.setNombre(cursosEstu.get(i).getDocente().getNombre());
				docen.setApellido(cursosEstu.get(i).getDocente().getApellido());
				docen.setIdPrograma(progra);
				docenteEJB.crear(docen);
			}

			Asignatura asig = asignaturaEJB.buscar(cursosEstu.get(i).getAsignatura().getCodigo());
			if (asig == null) {
				asig = new Asignatura();
				asig.setIdPrograma(progra);
				asig.setIdAsignatura(cursosEstu.get(i).getAsignatura().getCodigo());
				asig.setNombreAsignatura(cursosEstu.get(i).getAsignatura().getNombre());
				asignaturaEJB.crear(asig);
			}

			Grupo gru = grupoEJB.buscar(cursosEstu.get(i).getId());
			if (gru == null) {
				Grupo g = new Grupo();
				g.setIdGrupo(cursosEstu.get(i).getId());
				g.setIdAsignatura(asig);
				g.setIdDocente(docen);
				g.setPeriodo(3);
				g.setGrupo(cursosEstu.get(i).getGrupo().toString());
				// String fecha = "2016";
				// g.setAnio(null);
				grupoEJB.crear(g);
				lista.add(g);
			} else {
				lista.add(gru);

			}
		}
		return lista;
	}

	/**
	 * Metodo para cargar la fecha
	 * 
	 * @param stringFecha
	 * @return
	 */
	public Date cargarFecha(String stringFecha) {
		SimpleDateFormat fechaFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date fecha = fechaFormat.parse(stringFecha);
			return fecha;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo para responder una evaluacion
	 */
	public void responderEval(RespuestaEvaluacionDTO res){
		res.setCodigoEstudiante("123");
		res.setComentario("La evaluacion esta dura");
		res.setIdGrupo("123");
		Grupo gru = grupoEJB.buscar(res.getIdGrupo());
		

		Pregunta preg = preguntaEJB.buscar(res.getRespuestaDTO().get(0).getIdPregunta());
//		for (int i = 0; i < res.getRespuestaDTO().size(); i++) {
//			preguntaEJB.buscar(res);
//		}
		
		PregEval pr = new PregEval();
		Evaluacion e = new Evaluacion();
		Pregunta pre = new Pregunta();
		pr.setIdEvaluacion(e);
		pr.setIdPregunta(pre);
		pregEvalEJB.crear(pr);
		
		Respuesta r = new Respuesta();
		r.setComentario("La respuesta esta en tu corazon");
		r.setIdGrupo(gru);
		r.setIdRespuestas(1);
		String fecha = "24-09-2016";
		r.setFecha_Hora(cargarFecha(fecha));
		respuestaEJB.crear(r);
		
		
		RespPreg re = new RespPreg();
		re.setCalificacion(5);
		re.setIdPregEval(pr);
		re.setIdRespuesta(r);
		resPreguEJB.crear(re);
		
	}
}
