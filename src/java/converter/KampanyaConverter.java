package converter;

import dao.KampanyaDAO;
import entity.Kampanya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "kampanyaConverter")
public class KampanyaConverter implements Converter {

    public KampanyaDAO kampanyaDao;

    public KampanyaDAO getKampanyaDao() {
        if (kampanyaDao == null) {
            kampanyaDao = new KampanyaDAO();
        }
        return kampanyaDao;
    }

    public void setKampanyaDao(KampanyaDAO kampanyaDao) {
        this.kampanyaDao = kampanyaDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getKampanyaDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kampanya kam = (Kampanya) t;
        return String.valueOf(kam.getKampanya_id());
    }

}
