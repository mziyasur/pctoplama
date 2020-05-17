
package converter;

import dao.HarddiskDAO;
import entity.Harddisk;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "harddiskConverter")

public class HarddiskConverter implements Converter {

    private HarddiskDAO harddiskDao;

    public HarddiskDAO getHarddiskDao() {
        if (harddiskDao == null) {
            this.harddiskDao = new HarddiskDAO();
        }

        return harddiskDao;
    }

    public void setHarddiskDao(HarddiskDAO harddiskDao) {
        this.harddiskDao = harddiskDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getHarddiskDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Harddisk a = (Harddisk) t;
        return String.valueOf(a.getHarddisk_id());

    }

}
