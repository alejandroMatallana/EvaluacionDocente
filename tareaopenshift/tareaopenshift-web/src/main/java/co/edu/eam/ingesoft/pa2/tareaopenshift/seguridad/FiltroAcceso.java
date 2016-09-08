/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.seguridad;

import java.io.IOException;
import java.util.List;

import java.util.logging.LogRecord;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.omnifaces.servlet.HttpServletResponseOutputWrapper;

/**
 * @author Alejandro
 *
 */
@WebFilter(urlPatterns = "/paginas/*")
public class FiltroAcceso implements Filter {

	@Inject
	private SesionBean sesion;

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FiltroAcceso.class);

	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException,
	ServletException{
		
		HttpServletRequest  httpreq = (HttpServletRequest) request;
		HttpServletResponse  httpresp = (HttpServletResponse) resp;
		
		String urlcompleta = httpreq.getRequestURI().toString();
		String contextpaht = httpreq.getContextPath();
		
		logger.info("url=" + urlcompleta + ",path=" + contextpaht);
		String url = urlcompleta.substring(contextpaht.length());
		
		logger.info("URL a filtar= " + url);
		
		//Si el usuario no esta en sesion y no es la pagina de inicio que todos tienen
	
		if (sesion.islogged()) {
			//Busca si tiene acceso a la pagina
			boolean exito  = false;
			
			if (url.equals("/paginas/inicio.jsf")) {
				exito=true;
				
			} else {
				//Recorre los accesos autorizados 
				List<Acceso> accesos = sesion.getAccesos();
						
						for (Acceso accseso : accesos) {
							//Si esta en la lista de accesos autorizados
							
							if (accseso.getUrl().equals(url)) {
								exito = true;
							}
					}
			}
			
			//No esta en la lista lo redirige al inicio
			if (!exito) {
				httpresp.sendRedirect(httpreq.getContextPath() + "/paginas/inicio.jsf");
			} else {
				//Continua la peticion
				chain.doFilter(request, resp);
			}
		} else { //No esta en sesion lo dirige al principio
			httpresp.sendRedirect(httpreq.getContextPath() + "/index.jsf");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


