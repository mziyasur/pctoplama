/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OemDAO;
import entity.Oem;
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
public class OemBean implements Serializable {

    private OemDAO dao;
    private Oem entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/oem/list";
    }

    public List<Oem> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Oem c) {
        this.entity = c;

        return "/oem/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Oem();

        return "/oem/list";

    }

    public void delete(Oem c) {
        this.getDao().delete(c);

    }

    public OemBean() {
    }

    public OemDAO getDao() {
        if (this.dao == null) {
            this.dao = new OemDAO();
        }
        return dao;

    }

    public void setDao(OemDAO dao) {
        this.dao = dao;
    }

    public Oem getEntity() {
        if (this.entity == null) {
            this.entity = new Oem();
        }
        return entity;
    }

    public void setEntity(Oem entity) {
        this.entity = entity;
    }

}
