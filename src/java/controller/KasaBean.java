package controller;


import dao.KasaDAO;
import entity.Kasa;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class KasaBean implements Serializable {

    private KasaDAO dao;
    private Kasa entity;

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
        return "/parca/kasa/list";
    }

    public List<Kasa> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(Kasa c) {
        this.entity = c;

        return "/parca/kasa/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Kasa();

        return "/parca/kasa/list";

    }

    public void delete(Kasa c) {
        this.getDao().delete(c);

    }

    public KasaBean() {
    }

    public KasaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KasaDAO();
        }
        return dao;
    }

    public void setDao(KasaDAO dao) {
        this.dao = dao;
    }

    public Kasa getEntity() {
        if (this.entity == null) {
            this.entity = new Kasa();
        }
        return entity;
    }

    public void setEntity(Kasa entity) {
        this.entity = entity;
    }
}
