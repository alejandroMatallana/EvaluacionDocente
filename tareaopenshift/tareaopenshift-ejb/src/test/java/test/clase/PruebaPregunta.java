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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;

/**
 * @author Alejandro
 *
 */
@RunWith(Arquillian.class)
public class PruebaPregunta {

	@EJB
	private PreguntaEJB preguntaEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaPregunta.class));
		return ear;
		
	}

	
	@Test
	public void testCrearPregunta(){
		Pregunta p = new Pregunta();
		
		p.setTexto("Pregunta de la prueba de arquilian");
		p.setValor(5);
		preguntaEJB.crear(p);
		
		Pregunta pre = preguntaEJB.buscar(p.getIdPregunta());
		Assert.assertEquals("Pregunta de la prueba de arquilian", pre.getTexto());
	}
	
	@AfterClass
	public static void finPrueba(){
		TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
		System.out.println("Sali");
	}
	
}
