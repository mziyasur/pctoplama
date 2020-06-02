package controller;


import dao.IsletimSistemiDAO;
import entity.IsletimSistemi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IsletimSistemiBean implements Serializable {

    private IsletimSistemiDAO dao;
    private IsletimSistemi entity;

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
        return "/parca/isletimsistemi/list";
    }

    public List<IsletimSistemi> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(IsletimSistemi c) {
        this.entity = c;

        return "/parca/isletimsistemi/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new IsletimSistemi();

        return "/parca/isletimsistemi/list";

    }

    public void delete(IsletimSistemi c) {
        this.getDao().delete(c);

    }

    public IsletimSistemiBean() {
    }

    public IsletimSistemiDAO getDao() {
        if (this.dao == null) {
            this.dao = new IsletimSistemiDAO();
        }
        return dao;

    }

    public void setDao(IsletimSistemiDAO dao) {
        this.dao = dao;
    }

    public IsletimSistemi getEntity() {
        if (this.entity == null) {
            this.entity = new IsletimSistemi();
        }
        return entity;
    }

    public void setEntity(IsletimSistemi entity) {
        this.entity = entity;
    }
}
