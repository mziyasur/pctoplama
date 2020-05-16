/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.AnakartDAO;
import dao.BellekDAO;
import entity.Anakart;
import entity.Bellek;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehme
 */
@FacesConverter(value = "bellekConverter")
//Yapmış olduğu görev nedir converterlerin 
//Bean sınıfları xthtm tarafayıla istek cevap üzrüne kurulu
//create anakart id gönderiyoduk kendisini gördermemiz lazm
public class BellekConverter implements Converter {

    private BellekDAO bellekDao;

    public BellekDAO getBellekDao() {
        if (bellekDao == null) {
            this.bellekDao = new BellekDAO();
        }
        return bellekDao;
    }

    public void setBellekDao(BellekDAO bellekDao) {
        this.bellekDao = bellekDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getBellekDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Bellek a = (Bellek) t;
        return String.valueOf(a.getBellek_id());

    }

}
