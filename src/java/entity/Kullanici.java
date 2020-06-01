package entity;

public class Kullanici {

    private int kullanici_id;
    private String kullanici_ad;
    private String kullanici_sifre;

    public Kullanici() {
    }

    public Kullanici(int kullanici_id, String kullanici_ad, String kullanici_sifre) {
        this.kullanici_id = kullanici_id;
        this.kullanici_ad = kullanici_ad;
        this.kullanici_sifre = kullanici_sifre;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_ad() {
        return kullanici_ad;
    }

    public void setKullanici_ad(String kullanici_ad) {
        this.kullanici_ad = kullanici_ad;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullanici_id=" + kullanici_id + ", kullanici_ad=" + kullanici_ad + ", kullanici_sifre=" + kullanici_sifre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.kullanici_id;
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
        final Kullanici other = (Kullanici) obj;
        if (this.kullanici_id != other.kullanici_id) {
            return false;
        }
        return true;
    }

}
