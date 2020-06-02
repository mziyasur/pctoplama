/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author mehme
 */
public class Bellek {

    private int bellek_id;
    private String bellek_adı;
    private int kapasite;
    private String bellek_turu;
    private int calisma_hizi;
    private String gecikme_degeri;
    private int bellek_fiyat;

    public Bellek() {
    }

    public Bellek(int bellek_id, String bellek_adı, int kapasite, String bellek_turu, int calisma_hizi, String gecikme_degeri, int bellek_fiyat) {
        this.bellek_id = bellek_id;
        this.bellek_adı = bellek_adı;
        this.kapasite = kapasite;
        this.bellek_turu = bellek_turu;
        this.calisma_hizi = calisma_hizi;
        this.gecikme_degeri = gecikme_degeri;
        this.bellek_fiyat = bellek_fiyat;
    }

    public int getBellek_id() {
        return bellek_id;
    }

    public void setBellek_id(int bellek_id) {
        this.bellek_id = bellek_id;
    }

    public String getBellek_adı() {
        return bellek_adı;
    }

    public void setBellek_adı(String bellek_adı) {
        this.bellek_adı = bellek_adı;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public String getBellek_turu() {
        return bellek_turu;
    }

    public void setBellek_turu(String bellek_turu) {
        this.bellek_turu = bellek_turu;
    }

    public int getCalisma_hizi() {
        return calisma_hizi;
    }

    public void setCalisma_hizi(int calisma_hizi) {
        this.calisma_hizi = calisma_hizi;
    }

    public String getGecikme_degeri() {
        return gecikme_degeri;
    }

    public void setGecikme_degeri(String gecikme_degeri) {
        this.gecikme_degeri = gecikme_degeri;
    }

    public int getBellek_fiyat() {
        return bellek_fiyat;
    }

    public void setBellek_fiyat(int bellek_fiyat) {
        this.bellek_fiyat = bellek_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.bellek_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bellek other = (Bellek) obj;
        if (this.bellek_id != other.bellek_id) {
            return false;
        }
        return true;
    }

}
