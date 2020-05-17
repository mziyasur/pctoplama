
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

    
    public String create() {
        this.getDao().create(entity);
        return "/islemci/list";
    }

    public List<Islemci> getRead() {

        return this.getDao().read();
    }

    public String updateForm(Islemci c) {
        this.entity = c;

        return "/islemci/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Islemci();

        return "/islemci/list";

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
