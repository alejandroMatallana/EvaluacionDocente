/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.dto;

/**
 * @author Alejandro
 *
 */
public class RespuestaDTO {

	private Object obj;
	
	private String mensaje;
	
	private String codigo;

	public RespuestaDTO(Object obj) {
	this.obj = obj;
	mensaje = "Se ejecuto correctamente";
	codigo = "123";
	}
	
	public RespuestaDTO(Object obj, String mensaje, String codigo) {
		super();
		this.obj = obj;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
