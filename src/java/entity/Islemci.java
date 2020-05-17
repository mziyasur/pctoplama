
package entity;


public class Islemci {

    private int islemci_id;
    private String islemci_adı;
    private String islemci_turu;
    private String islemci_nesil;
    private int temel_frekans;
    private int turbo_frekans;
    private String onbellek;
    private int cekirdek_sayisi;
    private String soket_turu;
    private int islemci_fiyat;

    public Islemci() {
    }

    public Islemci(int islemci_id, String islemci_adı, String islemci_turu, String islemci_nesil, int temel_frekans, int turbo_frekans, String onbellek, int cekirdek_sayisi, String soket_turu, int islemci_fiyat) {
        this.islemci_id = islemci_id;
        this.islemci_adı = islemci_adı;
        this.islemci_turu = islemci_turu;
        this.islemci_nesil = islemci_nesil;
        this.temel_frekans = temel_frekans;
        this.turbo_frekans = turbo_frekans;
        this.onbellek = onbellek;
        this.cekirdek_sayisi = cekirdek_sayisi;
        this.soket_turu = soket_turu;
        this.islemci_fiyat = islemci_fiyat;
    }

    public int getIslemci_id() {
        return islemci_id;
    }

    public void setIslemci_id(int islemci_id) {
        this.islemci_id = islemci_id;
    }

    public String getIslemci_adı() {
        return islemci_adı;
    }

    public void setIslemci_adı(String islemci_adı) {
        this.islemci_adı = islemci_adı;
    }

    public String getIslemci_turu() {
        return islemci_turu;
    }

    public void setIslemci_turu(String islemci_turu) {
        this.islemci_turu = islemci_turu;
    }

    public String getIslemci_nesil() {
        return islemci_nesil;
    }

    public void setIslemci_nesil(String islemci_nesil) {
        this.islemci_nesil = islemci_nesil;
    }

    public int getTemel_frekans() {
        return temel_frekans;
    }

    public void setTemel_frekans(int temel_frekans) {
        this.temel_frekans = temel_frekans;
    }

    public int getTurbo_frekans() {
        return turbo_frekans;
    }

    public void setTurbo_frekans(int turbo_frekans) {
        this.turbo_frekans = turbo_frekans;
    }

    public String getOnbellek() {
        return onbellek;
    }

    public void setOnbellek(String onbellek) {
        this.onbellek = onbellek;
    }

    public int getCekirdek_sayisi() {
        return cekirdek_sayisi;
    }

    public void setCekirdek_sayisi(int cekirdek_sayisi) {
        this.cekirdek_sayisi = cekirdek_sayisi;
    }

    public String getSoket_turu() {
        return soket_turu;
    }

    public void setSoket_turu(String soket_turu) {
        this.soket_turu = soket_turu;
    }

    public int getIslemci_fiyat() {
        return islemci_fiyat;
    }

    public void setIslemci_fiyat(int islemci_fiyat) {
        this.islemci_fiyat = islemci_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.islemci_id;
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
        final Islemci other = (Islemci) obj;
        if (this.islemci_id != other.islemci_id) {
            return false;
        }
        return true;
    }

}
