package test.clase;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class PruebaCrearUsuarioVista {

	@Drone
	private WebDriver browser;
	
	@Deployment
	public static EnterpriseArchive desplegar() {

		EnterpriseArchive ear = ArquillianUtil.createDeployment("../tareaopenshift-ear/target/tareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaCrearUsuarioVista.class));
		return ear;

	}

	@BeforeClass
	public static void inicio() {

	}

	@AfterClass
	public static void fin() {

	}

}
