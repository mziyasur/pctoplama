/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.AnakartDAO;
import dao.EkranKartiDAO;
import entity.Anakart;
import entity.EkranKarti;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehme
 */
@FacesConverter(value = "ekrankartiConverter")
//Yapmış olduğu görev nedir converterlerin 
//Bean sınıfları xthtm tarafayıla istek cevap üzrüne kurulu
//create anakart id gönderiyoduk kendisini gördermemiz lazm
public class EkranKartiConverter implements Converter {

    private EkranKartiDAO ekrankartiDao;

    public EkranKartiDAO getEkrankartiDao() {
        if (ekrankartiDao == null) {
            this.ekrankartiDao = new EkranKartiDAO();
        }
        return ekrankartiDao;
    }

    public void setEkrankartiDao(EkranKartiDAO ekrankartiDao) {
        this.ekrankartiDao = ekrankartiDao;
    }
    
    

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getEkrankartiDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        EkranKarti a = (EkranKarti) t;
        return String.valueOf(a.getEkrankart_id());
    }

   

}
