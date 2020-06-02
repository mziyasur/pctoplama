
package controller;

import dao.HarddiskDAO;
import entity.Harddisk;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class HarddiskBean implements Serializable {

    private HarddiskDAO dao;
    private Harddisk entity;
    
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
        return "/parca/harddisk/list";
    }

    public List<Harddisk> getRead() {

        return this.getDao().read(page, pageSize);
    }

    public String updateForm(Harddisk c) {
        this.entity = c;

        return "/parca/harddisk/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Harddisk();

        return "/parca/harddisk/list";

    }

    public void delete(Harddisk c) {
        this.getDao().delete(c);

    }
    public HarddiskBean() {
    }

    public HarddiskDAO getDao() {
        if (this.dao == null) {
            this.dao = new HarddiskDAO();
        }
        return dao;

    }

    public void setDao(HarddiskDAO dao) {
        this.dao = dao;
    }

    public Harddisk getEntity() {
        if (this.entity == null) {
            this.entity = new Harddisk();
        }
        return entity;
    }

    public void setEntity(Harddisk entity) {
        this.entity = entity;
    }

}
