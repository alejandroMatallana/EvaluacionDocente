/**
 * 
 */
package test.clase;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.WsdlEJB;

/**
 * @author Alejandro
 *
 */
@RunWith(Arquillian.class)
public class WsdlSOAP {

	@EJB
	private WsdlEJB wsdlEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(WsdlSOAP.class));
		return ear;
	}
	
	@Test
	public void buscar (){
		Assert.assertTrue(wsdlEJB.buscarCursos("123", "123"));
	}
	
	@Test
	public void crear(){
		wsdlEJB.crearAsignatura("123", "123");
	}
}
