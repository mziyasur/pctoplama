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

    public String create() {
        this.getDao().create(entity);
        return "/isletimsistemi/list";
    }

    public List<IsletimSistemi> getRead() {
        return this.getDao().read();
    }

    public String updateForm(IsletimSistemi c) {
        this.entity = c;
        return "/isletimsistemi/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new IsletimSistemi();
        return "/isletimsistemi/list";
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
