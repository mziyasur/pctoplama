package entity;

public class Admin {

    private int admin_id;
    private String admin_ad;
    private String admin_sifre;

    public Admin() {
    }

    public Admin(int admin_id, String admin_ad, String admin_sifre) {
        this.admin_id = admin_id;
        this.admin_ad = admin_ad;
        this.admin_sifre = admin_sifre;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_ad() {
        return admin_ad;
    }

    public void setAdmin_ad(String admin_ad) {
        this.admin_ad = admin_ad;
    }

    public String getAdmin_sifre() {
        return admin_sifre;
    }

    public void setAdmin_sifre(String admin_sifre) {
        this.admin_sifre = admin_sifre;
    }

    @Override
    public String toString() {
        return "Admin{" + "admin_id=" + admin_id + ", admin_ad=" + admin_ad + ", admin_sifre=" + admin_sifre + '}';
    }

}
