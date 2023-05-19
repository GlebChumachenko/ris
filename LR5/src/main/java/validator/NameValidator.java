package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
public class NameValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String name = o.toString();
        String regex = "\\d+";
        if (name.matches(regex) || name.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Incorrect name format");
            throw new ValidatorException(message);
        }
    }
}
