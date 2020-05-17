package converter;

import dao.IsletimSistemiDAO;
import entity.IsletimSistemi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "isletimsistemiConverter")

public class IsletimSistemiConverter implements Converter {

    private IsletimSistemiDAO isletimsistemiDao;

    public IsletimSistemiDAO getIsletimsistemiDao() {
        if (isletimsistemiDao == null) {
            this.isletimsistemiDao = new IsletimSistemiDAO();
        }
        return isletimsistemiDao;
    }

    public void setIsletimsistemiDao(IsletimSistemiDAO isletimsistemiDao) {
        this.isletimsistemiDao = isletimsistemiDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getIsletimsistemiDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        IsletimSistemi a = (IsletimSistemi) t;
        return String.valueOf(a.getIsletim_id());
    }
}
