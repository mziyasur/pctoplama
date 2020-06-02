package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("AdValidator")
public class AdValidator implements Validator {

    String ad = "\\P{InGreek}{5,50}";
    

    private Pattern patternObject;
    private Matcher matcherObject;

    public AdValidator() {
        patternObject = Pattern.compile(ad, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        matcherObject = patternObject.matcher(o.toString());
        if (o!=null) {
            if(o.toString().trim().equals("")){
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+ " girilmedi!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else if (!matcherObject.matches()) {
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+" için 5-50 aralığında karakter girmelisiniz!");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(message);
            
        }}
    }
}
