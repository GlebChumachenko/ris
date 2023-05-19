package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
@FacesValidator("zipValidator")
public class ZipValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String zip = o.toString();
        String regex = "\\d{5}";
        if (!zip.matches(regex)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Incorrect zip format");
            throw new ValidatorException(message);
        }
    }
}
