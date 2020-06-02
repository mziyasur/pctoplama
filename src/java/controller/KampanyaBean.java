
package controller;

import dao.KampanyaDAO;
import entity.Kampanya;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class KampanyaBean implements Serializable{

    private KampanyaDAO kampanyaDao;
    private Kampanya entity;
    private List<Kampanya> aList;

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
        this.pageCount = (int) Math.ceil(this.getKampanyaDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String create() {
        this.getKampanyaDao().create(entity);
        this.entity = new Kampanya();
        return "/kampanya/list";
    }

    public String updateForm(Kampanya c) {
        this.entity = c;
        return "/kampanya/update";
    }

    public String update() {
        this.getKampanyaDao().update(entity);
        this.entity = new Kampanya();
        return "/kampanya/list";
    }

    public String delete() {
        this.getKampanyaDao().delete(this.getEntity());
        this.entity = new Kampanya();
        return "/kampanya/list";
    }
    
     public String deleteConfirm(Kampanya a) {
        this.entity = a;
        return "/kampanya/confirmDelete";
    }

    public KampanyaDAO getKampanyaDao() {
        if (this.kampanyaDao == null) {
            kampanyaDao = new KampanyaDAO();
        }
        return kampanyaDao;
    }

    public void setKampanyaDao(KampanyaDAO kampanyaDao) {
        this.kampanyaDao = kampanyaDao;
    }

    public Kampanya getEntity() {
        if (this.entity == null) {
            entity = new Kampanya();
        }
        return entity;
    }

    public void setEntity(Kampanya entity) {
        this.entity = entity;
    }

    public List<Kampanya> getRead() {
        this.aList = this.getKampanyaDao().read(page, pageSize);
        return aList;
    }

    public void setaList(List<Kampanya> aList) {
        this.aList = aList;
    }
}
