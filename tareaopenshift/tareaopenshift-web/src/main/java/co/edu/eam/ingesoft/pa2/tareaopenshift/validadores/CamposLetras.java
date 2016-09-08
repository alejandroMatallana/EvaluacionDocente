/**
 * 
 */
package co.edu.eam.ingesoft.pa2.tareaopenshift.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 * @author Alejandro
 *
 */
@Named
@FacesValidator(value = "campoLetra")
public class CamposLetras implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value instanceof String) {
			String valor = (String) value;
			if (!valor.matches("[a-zA-Z]*")) {
				throw new ValidatorException(
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Ha ingresado numero en este campo", null));
			}

		} else {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ha ingresado numeros en este campo", null));
		}

	}

}
