/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad.SesionBean;

/**
 * @author Alejandro
 *
 */
@Secured
@Interceptor
public class SecurityInterceptor implements Serializable {

	private static Logger log = Logger.getLogger(SecurityInterceptor.class);

	@Inject
	private SesionBean sesion;

	@AroundInvoke
	public Object mostrarExcepcion(InvocationContext ctx) throws Exception {

		// Verifica que el metodo que se invoca esta anotado
		if (ctx.getMethod().isAnnotationPresent(Secured.class)) {
			if (sesion.islogged()) {
				Object res = ctx.proceed();
				return res;
			} else {
				throw new ExcepcionNegocio("No autorizado");
			}
		} else {
			Object res = ctx.proceed();
			return res;
		}
	}

}
