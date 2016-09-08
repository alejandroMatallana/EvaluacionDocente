/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

/**
 * @author Alejandro
 *
 */
@Path("/usuario")
public class ClienteRest {

	@EJB
	private UsuarioEJB usuarioEJB;
	
	@GET
	@Path("/buscarUsuario")
	@Produces(MediaType.APPLICATION_JSON) 
	public RespuestaDTO buscar(@QueryParam(value="cedu") int cedula){
	
		System.out.println("Buscando a " + cedula);
		Usuario u = usuarioEJB.buscar(cedula);
		if (u==null) {
			return new RespuestaDTO(u,"no esta","3");
		}
		return new RespuestaDTO(u);
	}

	public ClienteRest() {
		
	}
	
	@Path("/crear")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Usuario usuario){
		if (usuarioEJB.buscar(usuario.getId())== null) {
			usuarioEJB.crear(usuario);
			return new RespuestaDTO(true);
		} else {
			return new RespuestaDTO(false,"ya existe","0");
		}
	}
	
//	@Path("/listar")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public RespuestaDTO listarUsuarios(){
//		List<Usuario> listaUsu = usuarioEJB.listar();
//		return new RespuestaDTO(listaUsu);
//	}
}
