/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "Preguntas")
public class Pregunta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPregunta")
	private int idPregunta;

	@Column(name = "texto")
	private String texto;

	@Column(name = "valor")
	private double valor;

	// Constructor vacio
	public Pregunta() {
		super();
	}

	// Constructor
	public Pregunta(String texto, double valor) {
		super();
		this.texto = texto;
		this.valor = valor;
	}

	public Pregunta(int idPregunta, String texto, double valor) {
		super();
		this.idPregunta = idPregunta;
		this.texto = texto;
		this.valor = valor;
	}

	// Accesores y modificadores
	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
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
