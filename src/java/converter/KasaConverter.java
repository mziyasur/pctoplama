package converter;

import dao.KasaDAO;
import entity.Kasa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "kasaConverter")

public class KasaConverter implements Converter {

    private KasaDAO kasaDao;

    public KasaDAO getKasaDao() {
        if (kasaDao == null) {
            this.kasaDao = new KasaDAO();
        }
        return kasaDao;
    }

    public void setKasaDao(KasaDAO kasaDao) {
        this.kasaDao = kasaDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getKasaDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Kasa a = (Kasa) t;
        return String.valueOf(a.getKasa_id());
    }
}
