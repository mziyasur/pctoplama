package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("GecikmeValidator")
public class GecikmeValidator implements Validator {

    String gecikme = "cl\\d{1,2}";
    

    private Pattern patternObject;
    private Matcher matcherObject;

    public GecikmeValidator() {
        patternObject = Pattern.compile(gecikme, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcherObject = patternObject.matcher(o.toString());
        if (o!=null) {
            if(o.toString().trim().equals("")){
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+ " girilmedi!");
            message.setSeverity(FacesMessage.SEVERITY_WARN);
            throw new ValidatorException(message);
        }
       else if (!matcherObject.matches()) {
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+" değerini cl_ veya cl_ _ olarak girmelisiniz! örn: cl5 veya cl10");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }}
    }
}
