package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("stateValidator")
public class StateValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String state = o.toString();
        String regex = "\\d{2}";
        if (!state.matches(regex)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Incorrect state format");
            throw new ValidatorException(message);
        }
    }
}
