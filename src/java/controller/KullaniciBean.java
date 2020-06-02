/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
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
public class KullaniciBean implements Serializable{

    private KullaniciDAO kullaniciDao;
    private Kullanici entity;
    private List<Kullanici> aList;

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
        this.pageCount = (int) Math.ceil(this.getKullaniciDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.getKullaniciDao().create(entity);
        this.entity = new Kullanici();
        return "/kullanici/list";
    }

    public String updateForm(Kullanici a) {
        this.entity = a;
        return "/kullanici/update";
    }

    public String update() {
        System.out.println("****" +entity.getKullanici_id());
        this.getKullaniciDao().update(entity);
        this.entity = new Kullanici();
        return "/kullanici/list";
    }

    public String delete() {
        this.getKullaniciDao().delete(this.getEntity());
        this.entity = new Kullanici();
        return "/kullanici/list";
    }
    
     public String deleteConfirm(Kullanici a) {
        this.entity = a;
        return "/kullanici/confirmDelete";
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public Kullanici getEntity() {
        if (this.entity == null) {
            entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public List<Kullanici> getRead() {
        this.aList = this.getKullaniciDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<Kullanici> aList) {
        this.aList = aList;
    }

}
