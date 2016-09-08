package test.clase;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class PruebaCrearPreguntaVista {

	@Drone
	private WebDriver browser;
	
	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaCrearPreguntaVista.class));
		return ear;

	}

	@BeforeClass
	public static void inicio() {

	}
	
	@Test
	@RunAsClient
	public void testCrearCuenta(@InitialPage PaginaCrearPregunta pag){
		String res = pag.crearPreguntaVista();
		ArquillianUtil.takeScreenshot(browser, "testCrearPregunta.jpg");
		Assert.assertEquals("La pregunta fue registrada con exito", res);
		
	}

	@AfterClass
	public static void fin() {

	}
	
}
