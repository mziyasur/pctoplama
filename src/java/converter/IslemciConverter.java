/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import dao.IslemciDAO;

import entity.Islemci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value = "islemciConverter")

public class IslemciConverter implements Converter {

    private IslemciDAO islemciDao;

    public IslemciDAO getIslemciDao() {
        if (islemciDao == null) {
            this.islemciDao = new IslemciDAO();
        }
        return islemciDao;
    }

    public void setIslemciDao(IslemciDAO islemciDao) {
        this.islemciDao = islemciDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        return this.getIslemciDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object t) {
        Islemci a = (Islemci) t;
        return String.valueOf(a.getIslemci_id());

    }

}
