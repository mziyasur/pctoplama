/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MonitorDAO;
import entity.Monitor;
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
public class MonitorBean implements Serializable {

    private MonitorDAO dao;
    private Monitor entity;

    //CRUD
    public String create() {
        this.getDao().create(entity);
        return "/monitor/list";
    }

    public List<Monitor> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Monitor c) {
        this.entity = c;

        return "/monitor/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Monitor();

        return "/monitor/list";

    }

    public void delete(Monitor c) {
        this.getDao().delete(c);

    }

    public MonitorBean() {
    }

    public MonitorDAO getDao() {
        if (this.dao == null) {
            this.dao = new MonitorDAO();
        }
        return dao;

    }

    public void setDao(MonitorDAO dao) {
        this.dao = dao;
    }

    public Monitor getEntity() {
        if (this.entity == null) {
            this.entity = new Monitor();
        }
        return entity;
    }

    public void setEntity(Monitor entity) {
        this.entity = entity;
    }

}
