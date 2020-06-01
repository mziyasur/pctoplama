package converter;

import dao.KullaniciDAO;
import entity.Kullanici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "kullaniciConverter")
public class KullaniciConverter implements Converter {

    private KullaniciDAO kullaniciDao;

    public KullaniciDAO getKullaniciDao() {
        if (kullaniciDao == null) {
            kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getKullaniciDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kullanici kul = (Kullanici) t;
        return String.valueOf(kul.getKullanici_id());
    }

}
