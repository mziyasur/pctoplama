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
import javax.faces.component.UIComponent;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici kullanici;
    private KullaniciDAO kullaniciDao;
    public static Kullanici temp;

    private Admin admin;
    private AdminDAO adminDao;
    public static Admin tmp;

    private UIComponent kulbutton;
    private UIComponent adbutton;
    
    public String kullaniciLogin()  {

        
        temp = this.getKullaniciDao().findByusername(this.kullanici.getKullanici_ad());
        String parola = this.kullanici.getKullanici_sifre();
        if (temp != null) {
            if (parola.equals(temp.getKullanici_sifre())) {
                this.kullanici = temp;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_kullanici", this.kullanici);
                kullanici.setKullanici_ad("");
                kullanici.setKullanici_sifre("");
                return "/oem/list.xhtml";
            } else {
                FacesMessage message = new FacesMessage("Hatalı şifre!");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(kulbutton.getClientId(context), message);
                kullanici.setKullanici_sifre("");
                return "/login/kullanicilogin.xhtml";

            }
        } else {
            FacesMessage message = new FacesMessage("Bu isimde bir kullanıcı mevcut değil!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(kulbutton.getClientId(context), message);
            kullanici.setKullanici_ad("");
            kullanici.setKullanici_sifre("");
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
                admin.setAdmin_ad("");
                admin.setAdmin_sifre("");
                return "/parca/anakart/list.xhtml";
            } else {
                FacesMessage message = new FacesMessage("Hatalı şifre!");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(adbutton.getClientId(context), message);
                admin.setAdmin_sifre("");
                return "/login/adminlogin.xhtml";
            }
        } else {
            FacesMessage message = new FacesMessage("Bu isimde bir admin mevcut değil!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(adbutton.getClientId(context), message);
            admin.setAdmin_ad("");
            admin.setAdmin_sifre("");
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

    public UIComponent getKulbutton() {
        return kulbutton;
    }

    public void setKulbutton(UIComponent kulbutton) {
        this.kulbutton = kulbutton;
    }

    public UIComponent getAdbutton() {
        return adbutton;
    }

    public void setAdbutton(UIComponent adbutton) {
        this.adbutton = adbutton;
    }

}
