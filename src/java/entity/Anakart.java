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
public class Anakart {

    private int anakart_id;
    private String anakart_adı;
    private String uyumlu_kasa;
    private String soket_turu;
    private String bellek_turu;
    private int calisma_hizi;
    private int maxbellek;
    private int anakart_fiyat;

    public Anakart() {
    }

     public Anakart(int anakart_id, String anakart_adı, String uyumlu_kasa, String soket_turu, String bellek_turu, int calisma_hizi, int maxbellek, int anakart_fiyat) {
        this.anakart_id = anakart_id;
        this.anakart_adı = anakart_adı;
        this.uyumlu_kasa = uyumlu_kasa;
        this.soket_turu = soket_turu;
        this.bellek_turu = bellek_turu;
        this.calisma_hizi = calisma_hizi;
        this.maxbellek = maxbellek;
        this.anakart_fiyat = anakart_fiyat;
    }

    public int getAnakart_id() {
        return anakart_id;
    }

    public void setAnakart_id(int anakart_id) {
        this.anakart_id = anakart_id;
    }

    public String getAnakart_adı() {
        return anakart_adı;
    }

    public void setAnakart_adı(String anakart_adı) {
        this.anakart_adı = anakart_adı;
    }

    public String getUyumlu_kasa() {
        return uyumlu_kasa;
    }

    public void setUyumlu_kasa(String uyumlu_kasa) {
        this.uyumlu_kasa = uyumlu_kasa;
    }

    public String getSoket_turu() {
        return soket_turu;
    }

    public void setSoket_turu(String soket_turu) {
        this.soket_turu = soket_turu;
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
    
    public int getMaxbellek() {
        return maxbellek;
    }

    public void setMaxbellek(int maxbellek) {
        this.maxbellek = maxbellek;
    }

    public int getAnakart_fiyat() {
        return anakart_fiyat;
    }

    public void setAnakart_fiyat(int anakart_fiyat) {
        this.anakart_fiyat = anakart_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.anakart_id;
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
        final Anakart other = (Anakart) obj;
        if (this.anakart_id != other.anakart_id) {
            return false;
        }
        return true;
    }

}
