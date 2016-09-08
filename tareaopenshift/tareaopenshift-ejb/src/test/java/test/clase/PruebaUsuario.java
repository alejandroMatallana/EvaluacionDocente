/**
 * 
 */
package test.clase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Usuario;

/**
 * @author Alejandro
 *
 */
@RunWith(Arquillian.class)
public class PruebaUsuario {

	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaUsuario.class));
		return ear;
		
	}
	
	
	
	@Test
	public void testCrearPregunta(){
		Usuario u = new Usuario();
		u.setApellido("cardona");
		u.setId(123456789);
		u.setNombre("sebastian");
		u.setPassword("1234");
		u.setUsuario("sebas");
		usuarioEJB.crear(u);
		
		
		Usuario usu = usuarioEJB.buscar(123456789);
		Assert.assertNotNull(usu);
	}
	
	@AfterClass
	public static void finPrueba(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
	}
	
	
}
