/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.SsdDAO;

import entity.Ssd;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehme
 */
@FacesConverter(value = "ssdConverter")
//Yapmış olduğu görev nedir converterlerin 
//Bean sınıfları xthtm tarafayıla istek cevap üzrüne kurulu
//create anakart id gönderiyoduk kendisini gördermemiz lazm
public class SsdConverter implements Converter {

    private SsdDAO ssdDao;

    public SsdDAO getSsdDao() {
        if (ssdDao == null) {
            this.ssdDao = new SsdDAO();
        }
        return ssdDao;
    }

    public void setSsdDao(SsdDAO ssdDao) {
        this.ssdDao = ssdDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getSsdDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Ssd a = (Ssd) t;
        return String.valueOf(a.getSsd_id());

    }

}
