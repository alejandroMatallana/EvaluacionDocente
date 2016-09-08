package test.clase;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.xml.ws.BindingProvider;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.EstudianteEJB;


/**
 * @author Alejandro
 *
 */
@RunWith(Arquillian.class)
public class ClienteSOAP {
	
	@EJB
	private EstudianteEJB estudianteEJB;


	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(ClienteSOAP.class));
		return ear;
	}

	//@Test
	public void BuscarEstudiante(){
		Assert.assertTrue(estudianteEJB.buscar("123", "123"));
	}
	
	//@Test
	public void Crear(){
		estudianteEJB.crearAsignatura("123", "123");
	}
	
}
