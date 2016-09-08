/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.FacultadEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Facultad;

/**
 * @author Alejandro
 *
 */
@Named
@FacesConverter(value="facultad", forClass = Facultad.class)
public class FacultadConverter implements Converter {

	@EJB
	private FacultadEJB ejb;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		// TODO Auto-generated method stub
		if (string == null || string.trim().length() ==0 || string.equals("Seleccione")) {
			return null;
		}
		return ejb.buscar(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if (arg2 instanceof Facultad) {
			Facultad fa = (Facultad) arg2;
			return String.valueOf(fa.getIdFacultad());
		}
		return null;
	}

}
