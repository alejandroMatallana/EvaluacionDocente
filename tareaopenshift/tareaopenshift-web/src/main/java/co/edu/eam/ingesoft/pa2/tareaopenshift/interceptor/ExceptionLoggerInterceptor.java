/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.tareaopenshift.excepciones.ExcepcionNegocio;

/**
 * @author Alejandro
 *
 */
@Interceptor
@ExcepcionLogger
public class ExceptionLoggerInterceptor implements Serializable{

	private static Logger log = Logger.getLogger(ExceptionLoggerInterceptor.class); // Aca la importacion debe ser log4
	
	
	@AroundInvoke
	public Object mostrarExcepcion(InvocationContext invocationContext) throws Exception{
		log.info("Ingresando al metodo: "  + invocationContext.getMethod().getName());
				try{
			Object ret = invocationContext.proceed();		
		
		return ret;
		} catch (ExcepcionNegocio exc) {
		
			
			Messages.addFlashGlobalError(exc.getMessage());
			log.error(exc.getMessage(), exc);
			
	} catch (Exception exc) {
			log.error(exc.getMessage(), exc);
			Faces.getApplication().getNavigationHandler().handleNavigation(Faces.getContext(), null,
					"/error.jsf?faces-redirect=true");
			
		} finally {
		
		log.info("Saliendo del metodo: " + invocationContext.getMethod().getName());
     }
		
		return null;
		
	}
}
