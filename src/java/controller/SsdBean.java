/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SsdDAO;
import entity.Ssd;
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
public class SsdBean implements Serializable {

    private SsdDAO dao;
    private Ssd entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/ssd/list";
    }

    public List<Ssd> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Ssd c) {
        this.entity = c;

        return "/ssd/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Ssd();

        return "/ssd/list";

    }

    public void delete(Ssd c) {
        this.getDao().delete(c);

    }

    public SsdBean() {
    }

    public SsdDAO getDao() {
        if (this.dao == null) {
            this.dao = new SsdDAO();
        }
        return dao;

    }

    public void setDao(SsdDAO dao) {
        this.dao = dao;
    }

    public Ssd getEntity() {
        if (this.entity == null) {
            this.entity = new Ssd();
        }
        return entity;
    }

    public void setEntity(Ssd entity) {
        this.entity = entity;
    }

}
