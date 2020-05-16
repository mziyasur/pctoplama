/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnakartDAO;
import entity.Anakart;
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
public class AnakartBean implements Serializable {

    private AnakartDAO dao;
    private Anakart entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/anakart/list";
    }

    public List<Anakart> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Anakart c) {
        this.entity = c;

        return "/anakart/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Anakart();

        return "/anakart/list";

    }

    public void delete(Anakart c) {
        this.getDao().delete(c);

    }

    public AnakartBean() {
    }

    public AnakartDAO getDao() {
        if (this.dao == null) {
            this.dao = new AnakartDAO();
        }
        return dao;

    }

    public void setDao(AnakartDAO dao) {
        this.dao = dao;
    }

    public Anakart getEntity() {
        if (this.entity == null) {
            this.entity = new Anakart();
        }
        return entity;
    }

    public void setEntity(Anakart entity) {
        this.entity = entity;
    }

}
