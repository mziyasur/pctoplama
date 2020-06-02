package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("CozunurlukValidator")
public class CozunurlukValidator implements Validator {

    String cozunurluk = "\\d{4}\\s*(x|X)\\s*\\d{3,4}";
    

    private Pattern patternObject;
    private Matcher matcherObject;

    public CozunurlukValidator() {
        patternObject = Pattern.compile(cozunurluk);
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
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+" değerlerini _ _ _ _ x _ _ _ veya _ _ _ _ x _ _ _ _ şeklinde girmelisiniz!  örn: 1440x900 veya 1920x1080");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }}
    }
}
