/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EkranKartiDAO;
import entity.EkranKarti;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author mehme
 */
@Named
@SessionScoped
public class EkranKartiBean implements Serializable {

    private EkranKartiDAO dao;
    private EkranKarti entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/ekrankarti/list";
    }

    public List<EkranKarti> getRead() {

        return this.getDao().read();
    }

    public String updateForm(EkranKarti c) {
        this.entity = c;

        return "/ekrankarti/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new EkranKarti();

        return "/ekrankarti/list";

    }

    public void delete(EkranKarti c) {
        this.getDao().delete(c);

    }

    public EkranKartiBean() {
    }

    public EkranKartiDAO getDao() {
        if (this.dao == null) {
            this.dao = new EkranKartiDAO();
        }
        return dao;

    }

    public void setDao(EkranKartiDAO dao) {
        this.dao = dao;
    }

    public EkranKarti getEntity() {
        if (this.entity == null) {
            this.entity = new EkranKarti();
        }
        return entity;
    }

    public void setEntity(EkranKarti entity) {
        this.entity = entity;
    }

}
