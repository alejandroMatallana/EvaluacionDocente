package co.edu.eam.ingesoft.pa2.tareaopenshift.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.tareaopenshift.bos.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.tareaopenshift.persistencia.entidades.Programa;

@Named
@FacesConverter(value="programa", forClass = Programa.class)
public class ProgramaConverter  implements Converter{

	
	@EJB
	private ProgramaEJB ejb;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() ==0 || string.equals("Seleccione")) {
			return null;
		}
		return ejb.buscar(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof Programa) {
			Programa pro = (Programa) arg2;
			return String.valueOf(pro.getIdPrograma());
		}
		return null;
	}

}
