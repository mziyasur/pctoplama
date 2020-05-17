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

    public String create() {
        this.getDao().create(entity);
        return "/kasa/list";
    }

    public List<Kasa> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Kasa c) {
        this.entity = c;
        return "/kasa/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Kasa();
        return "/kasa/list";
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
