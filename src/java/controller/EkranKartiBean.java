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
        return "/parca/ekrankarti/list";
    }

    public List<EkranKarti> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(EkranKarti c) {
        this.entity = c;

        return "/parca/ekrankarti/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new EkranKarti();

        return "/parca/ekrankarti/list";

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
