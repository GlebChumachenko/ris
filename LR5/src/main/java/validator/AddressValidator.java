package validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("addressValidator")
public class AddressValidator implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String address = o.toString();
        if (address.equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"", "Incorrect address format");
            throw new ValidatorException(message);
        }
    }
}
