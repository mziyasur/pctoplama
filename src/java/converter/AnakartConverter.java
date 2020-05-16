/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.AnakartDAO;
import entity.Anakart;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehme
 */
@FacesConverter(value = "anakConverter")
//Yapmış olduğu görev nedir converterlerin 
//Bean sınıfları xthtm tarafayıla istek cevap üzrüne kurulu
//create anakart id gönderiyoduk kendisini gördermemiz lazm
public class AnakartConverter implements Converter {

    private AnakartDAO anakDao;

    public AnakartDAO getAnakDao() {
        if (anakDao == null) {
            this.anakDao = new AnakartDAO();
        }
        return anakDao;
    }

    public void setAnakDao(AnakartDAO anakDao) {
        this.anakDao = anakDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getAnakDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Anakart a = (Anakart) t;
        return String.valueOf(a.getAnakart_id());

    }

}
