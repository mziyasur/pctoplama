package entity;

public class Kasa {

    private int kasa_id;
    private String kasa_adı;
    private String soket_turu;
    private int cikis_gücü;
    private int fan_sayisi;
    private String renk;
    private int kasa_fiyat;

    public Kasa() {
    }

    public Kasa(int kasa_id, String kasa_adı, String soket_turu, int cikis_gücü, int fan_sayisi, String renk, int kasa_fiyat) {
        this.kasa_id = kasa_id;
        this.kasa_adı = kasa_adı;
        this.soket_turu = soket_turu;
        this.cikis_gücü = cikis_gücü;
        this.fan_sayisi = fan_sayisi;
        this.renk = renk;
        this.kasa_fiyat = kasa_fiyat;
    }

    public int getKasa_id() {
        return kasa_id;
    }

    public void setKasa_id(int kasa_id) {
        this.kasa_id = kasa_id;
    }

    public String getKasa_adı() {
        return kasa_adı;
    }

    public void setKasa_adı(String kasa_adı) {
        this.kasa_adı = kasa_adı;
    }

    public String getSoket_turu() {
        return soket_turu;
    }

    public void setSoket_turu(String soket_turu) {
        this.soket_turu = soket_turu;
    }

    public int getCikis_gücü() {
        return cikis_gücü;
    }

    public void setCikis_gücü(int cikis_gücü) {
        this.cikis_gücü = cikis_gücü;
    }

    public int getFan_sayisi() {
        return fan_sayisi;
    }

    public void setFan_sayisi(int fan_sayisi) {
        this.fan_sayisi = fan_sayisi;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public int getKasa_fiyat() {
        return kasa_fiyat;
    }

    public void setKasa_fiyat(int kasa_fiyat) {
        this.kasa_fiyat = kasa_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.kasa_id;
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
        final Kasa other = (Kasa) obj;
        if (this.kasa_id != other.kasa_id) {
            return false;
        }
        return true;
    }
}
