package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("MaxValidator")
public class MaxValidator implements Validator {

    String max = "\\d{2,4}";
    

    private Pattern patternObject;
    private Matcher matcherObject;

    public MaxValidator() {
        patternObject = Pattern.compile(max);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcherObject = patternObject.matcher(o.toString());
        if (o!=null) {
            if(o.toString().trim().equals("0")){
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+ " girilmedi!");
            message.setSeverity(FacesMessage.SEVERITY_WARN);
            throw new ValidatorException(message);
        }
       else if (!matcherObject.matches()) {
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+" için 10-9999 aralığında değer girmelisiniz!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }}
    }
}
