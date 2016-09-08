package test.clase;

import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("paginas/pagina.jsf")
public class PaginaCrearUsuario {

	@FindBy(name="nombre")
	private WebElement nombre;
	
	@FindBy(name="apellido")
	private WebElement apellido;


	@FindBy(name="cedula")
	private WebElement cedula;
	
	@FindBy(name="usuario")
	private WebElement usuario;
	
	@FindBy(name="contrasenia")
	private WebElement contrasenia;
	
	@FindBy(name="crearUsu")
	private WebElement crearUsu;
	
	
	
	
}
