package test.clase;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Location("paginas/pregunta.jsf")
public class PaginaCrearPregunta {

	@FindBy(name="texto")
	private WebElement texto;
	
	@FindBy(name="valor")
	private WebElement valor;
	
	@FindBy(name="crearPregunta")
	private WebElement crearPregunta;
	
	@FindBy(name="facesMessage")
	private WebElement facesMessage;
	
	
	public String crearPreguntaVista(){
		texto.sendKeys("Hola mundo");
		valor.sendKeys("2");
		
		Graphene.guardAjax(crearPregunta).click();
		Graphene.waitModel().until().element(facesMessage).is().present();
		
		return facesMessage.getText();
	}
	
}
