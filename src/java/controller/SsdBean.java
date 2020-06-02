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

     private int page = 1;
    private int pageSize = 4;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    public String create() {
        this.getDao().create(entity);
        return "/parca/ssd/list";
    }

    public List<Ssd> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(Ssd c) {
        this.entity = c;

        return "/parca/ssd/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Ssd();

        return "/parca/ssd/list";

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
