package util;

import dao.AdminDAO;
import dao.KullaniciDAO;
import entity.Admin;
import entity.Kullanici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici kullanici;
    private KullaniciDAO kullaniciDao;
    public static Kullanici temp;

    private Admin admin;
    private AdminDAO adminDao;
    public static Admin tmp;

    public String kullaniciLogin() {
        
        temp = this.getKullaniciDao().findByusername(this.kullanici.getKullanici_ad());
        String parola = this.kullanici.getKullanici_sifre();
        if (temp != null) {
            if (parola.equals(temp.getKullanici_sifre())) {
                this.kullanici = temp;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_kullanici", this.kullanici);
                return "/oem/list.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(parola + " - " + temp.getKullanici_sifre()));
                return "/login/kullanicilogin.xhtml";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı veya Şifre!"));
            return "/login/kullanicilogin.xhtml";
        }
    }

    public String adminLogin() {

        tmp = this.getAdminDao().findByadminusername(this.admin.getAdmin_ad());
        String p = this.admin.getAdmin_sifre();
        if (tmp != null) {
            if (p.equals(tmp.getAdmin_sifre())) {
                this.admin = tmp;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_admin", this.admin);
                return "/parca/anakart/list.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(p + " - " + tmp.getAdmin_sifre()));
                return "/login/adminlogin.xhtml";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı veya Şifre!"));
            return "/login/adminlogin.xhtml";
        }

    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public Admin getAdmin() {
        if (this.admin == null) {
            this.admin = new Admin();
        }
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminDAO getAdminDao() {
        if (this.adminDao == null) {
            this.adminDao = new AdminDAO();
        }
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

}
