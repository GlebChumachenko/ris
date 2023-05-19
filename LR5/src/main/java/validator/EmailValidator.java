package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = o.toString();
        String regex = "^(.+)@(\\S+)$";
        if (!email.matches(regex) || email.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Incorrect email format");
            throw new ValidatorException(message);
        }
    }
}
