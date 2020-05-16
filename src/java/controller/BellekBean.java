/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BellekDAO;
import entity.Bellek;
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
public class BellekBean implements Serializable {

    private BellekDAO dao;
    private Bellek entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/bellek/list";
    }

    public List<Bellek> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Bellek c) {
        this.entity = c;

        return "/bellek/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Bellek();

        return "/bellek/list";

    }

    public void delete(Bellek c) {
        this.getDao().delete(c);

    }

    public BellekBean() {
    }

    public BellekDAO getDao() {
        if (this.dao == null) {
            this.dao = new BellekDAO();
        }
        return dao;

    }

    public void setDao(BellekDAO dao) {
        this.dao = dao;
    }

    public Bellek getEntity() {
        if (this.entity == null) {
            this.entity = new Bellek();
        }
        return entity;
    }

    public void setEntity(Bellek entity) {
        this.entity = entity;
    }

}
