/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.bos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.Curso;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.Estudiante;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.tareaopenshift.cliente.ServiciosEducativosService;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

/**
 * @author Alejandro
 *
 */
@LocalBean
@Stateless
public class EstudianteEJB implements Serializable{

	@EJB
	private AsignaturaEJB asignaturaEJB;

	@EJB
	private ProgramaEJB programaEJB;

	@EJB
	private FacultadEJB facultadEJB;

	public boolean buscar(String codigo, String cedula) {
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

	public void crearAsignatura(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();
		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		List<Curso> dto = servicio.consultarCursosEstudiante(codigo, cedula);
		for (int i = 0; i < dto.size(); i++) {
			Facultad f = new Facultad();
			f.setIdFacultad(dto.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
			f.setNombre(dto.get(i).getAsignatura().getPrograma().getFacultad().getNombre());

			Programa p = new Programa();
			p.setIdPrograma(dto.get(i).getAsignatura().getPrograma().getCodigo());
			p.setNombrePrograma(dto.get(i).getAsignatura().getPrograma().getNombre());
			p.setIdFacultad(f);
			

			Asignatura a = new Asignatura();
			a.setIdAsignatura(String.valueOf(dto.get(i).getAsignatura().getCodigo()));
			a.setNombreAsignatura(dto.get(i).getAsignatura().getNombre());
			a.setIdPrograma(p);

			Facultad facultad = facultadEJB.buscar(dto.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
			Programa programa = programaEJB.buscar(dto.get(i).getAsignatura().getPrograma().getCodigo());
			Asignatura asig = asignaturaEJB.buscar(dto.get(i).getAsignatura().getCodigo());
			if (facultad ==null) {
				facultadEJB.crear(f);
			} else if (programa ==null) {
				programaEJB.crear(p);
			} else if (asig ==null) {
				asignaturaEJB.crear(a);
			}
		}
	}
}
