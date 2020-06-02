/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KullaniciKampanyaDAO;
import entity.KullaniciKampanya;
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
public class KullaniciKampanyaBean implements Serializable {

    private KullaniciKampanyaDAO aDao;
    private KullaniciKampanya entity;
    private List<KullaniciKampanya> aList;

    private int page = 1;
    private int pageSize = 5;
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
        this.pageCount = (int) Math.ceil(this.getaDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.getaDao().create(entity);
        this.entity = new KullaniciKampanya();

        return "/kulkam/list";
    }

    public String listForm() {
        this.entity = new KullaniciKampanya();
        return "/kulkam/list";
    }

    public String updateForm(KullaniciKampanya c) {
        this.entity = c;
        return "/kulkam/update";
    }

    public String update() {
        this.getaDao().update(entity);
        this.entity = new KullaniciKampanya();
        return "/kulkam/list";
    }

    public String delete() {
        this.getaDao().delete(this.getEntity());
        this.entity = new KullaniciKampanya();
        return "/kulkam/list";
    }

    public String deleteConfirm(KullaniciKampanya a) {
        this.entity = a;
        return "/kulkam/confirmDelete";
    }

    public KullaniciKampanyaDAO getaDao() {
        if (this.aDao == null) {
            aDao = new KullaniciKampanyaDAO();
        }
        return aDao;
    }

    public void setaDao(KullaniciKampanyaDAO aDao) {
        this.aDao = aDao;
    }

    public KullaniciKampanya getEntity() {
        if (this.entity == null) {
            entity = new KullaniciKampanya();
        }
        return entity;
    }

    public void setEntity(KullaniciKampanya entity) {
        this.entity = entity;
    }

    public List<KullaniciKampanya> getRead() {
        this.aList = this.getaDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<KullaniciKampanya> aList) {
        this.aList = aList;
    }

}
