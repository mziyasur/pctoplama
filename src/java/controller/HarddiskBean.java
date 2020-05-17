
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

    
    public String create() {
        this.getDao().create(entity);
        return "/harddisk/list";
    }

    public List<Harddisk> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Harddisk c) {
        this.entity = c;

        return "/harddisk/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Harddisk();

        return "/harddisk/list";

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
