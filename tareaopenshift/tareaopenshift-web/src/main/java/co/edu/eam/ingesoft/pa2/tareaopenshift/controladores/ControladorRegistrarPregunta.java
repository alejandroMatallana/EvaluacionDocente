package co.edu.eam.ingesoft.pa2.tareaopenshift.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.interceptor.ExcepcionLogger;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Pregunta;

@Named("preguntaWeb")
@ViewScoped
@ExcepcionLogger
public class ControladorRegistrarPregunta implements Serializable {

	@EJB
	private PreguntaEJB preguntaEJB;

	private String texto;

	private double valor;

	public void crear() {
		if (texto != null && valor != 0 ) {
			if(valor<101){
				Pregunta pre = new Pregunta(texto, valor);
				preguntaEJB.crear(pre);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "La pregunta fue registrada con exito",
						null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "El valor de la pregunta supera el 100%",
						null);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
			
			
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor llene todos los campos para continuar",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
