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
public class Ssd {

    private int ssd_id;
    private String ssd_adı;
    private int ssd_kapasite;
    private String ssd_arabirim;
    private int ssd_okumahizi;
    private int ssd_yazmahizi;
    private int ssd_fiyat;

    public Ssd() {
    }

    public Ssd(int ssd_id, String ssd_adı, int ssd_kapasite, String ssd_arabirim, int ssd_okumahizi, int ssd_yazmahizi, int ssd_fiyat) {
        this.ssd_id = ssd_id;
        this.ssd_adı = ssd_adı;
        this.ssd_kapasite = ssd_kapasite;
        this.ssd_arabirim = ssd_arabirim;
        this.ssd_okumahizi = ssd_okumahizi;
        this.ssd_yazmahizi = ssd_yazmahizi;
        this.ssd_fiyat = ssd_fiyat;
    }

    public int getSsd_id() {
        return ssd_id;
    }

    public void setSsd_id(int ssd_id) {
        this.ssd_id = ssd_id;
    }

    public String getSsd_adı() {
        return ssd_adı;
    }

    public void setSsd_adı(String ssd_adı) {
        this.ssd_adı = ssd_adı;
    }

    public int getSsd_kapasite() {
        return ssd_kapasite;
    }

    public void setSsd_kapasite(int ssd_kapasite) {
        this.ssd_kapasite = ssd_kapasite;
    }

    public String getSsd_arabirim() {
        return ssd_arabirim;
    }

    public void setSsd_arabirim(String ssd_arabirim) {
        this.ssd_arabirim = ssd_arabirim;
    }

    public int getSsd_okumahizi() {
        return ssd_okumahizi;
    }

    public void setSsd_okumahizi(int ssd_okumahizi) {
        this.ssd_okumahizi = ssd_okumahizi;
    }

    public int getSsd_yazmahizi() {
        return ssd_yazmahizi;
    }

    public void setSsd_yazmahizi(int ssd_yazmahizi) {
        this.ssd_yazmahizi = ssd_yazmahizi;
    }

    public int getSsd_fiyat() {
        return ssd_fiyat;
    }

    public void setSsd_fiyat(int ssd_fiyat) {
        this.ssd_fiyat = ssd_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.ssd_id;
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
        final Ssd other = (Ssd) obj;
        if (this.ssd_id != other.ssd_id) {
            return false;
        }
        return true;
    }

}
