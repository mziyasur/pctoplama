
package controller;

import dao.IslemciDAO;
import entity.Islemci;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class IslemciBean implements Serializable {

    private IslemciDAO dao;
    private Islemci entity;
    
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
        return "/parca/islemci/list";
    }

    public List<Islemci> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(Islemci c) {
        this.entity = c;

        return "/parca/islemci/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Islemci();

        return "/parca/islemci/list";

    }

    public void delete(Islemci c) {
        this.getDao().delete(c);

    }

    public IslemciBean() {
    }

    public IslemciDAO getDao() {
        if (this.dao == null) {
            this.dao = new IslemciDAO();
        }
        return dao;

    }

    public void setDao(IslemciDAO dao) {
        this.dao = dao;
    }

    public Islemci getEntity() {
        if (this.entity == null) {
            this.entity = new Islemci();
        }
        return entity;
    }

    public void setEntity(Islemci entity) {
        this.entity = entity;
    }

}
