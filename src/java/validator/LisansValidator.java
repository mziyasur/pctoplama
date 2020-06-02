package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@FacesValidator("LisansValidator")
public class LisansValidator implements Validator {

    String lisans = "(oem|retail|volume|esd)\\s*([(]online[)])?";
    

    private Pattern patternObject;
    private Matcher matcherObject;

    public LisansValidator() {
        patternObject = Pattern.compile(lisans, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
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
            FacesMessage message = new FacesMessage(uiComponent.getAttributes().get("label")+"'nü oem,esd, retail veya volume olarak girmelisiniz. Eğer online ise parantez içinde belirtiniz! örn: Esd(Online)");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }}
    }
}
