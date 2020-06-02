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
        return "/oem/list";
    }

    public List<Oem> getRead() {

        return this.getDao().read(page, pageSize);
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
