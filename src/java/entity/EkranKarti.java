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
public class EkranKarti {

    private int ekrankart_id;
    private String ekrankart_adı;
    private int ekrankart_bellek;
    private int bit_degeri;
    private String bellek_tipi;
    private String slot_yapisi;
    private int ekrankart_fiyat;

    public EkranKarti() {
    }

    public EkranKarti(int ekrankart_id, String ekrankart_adı, int ekrankart_bellek, int bit_degeri, String bellek_tipi, String slot_yapisi, int ekrankart_fiyat) {
        this.ekrankart_id = ekrankart_id;
        this.ekrankart_adı = ekrankart_adı;
        this.ekrankart_bellek = ekrankart_bellek;
        this.bit_degeri = bit_degeri;
        this.bellek_tipi = bellek_tipi;
        this.slot_yapisi = slot_yapisi;
        this.ekrankart_fiyat = ekrankart_fiyat;
    }

    public int getEkrankart_id() {
        return ekrankart_id;
    }

    public void setEkrankart_id(int ekrankart_id) {
        this.ekrankart_id = ekrankart_id;
    }

    public String getEkrankart_adı() {
        return ekrankart_adı;
    }

    public void setEkrankart_adı(String ekrankart_adı) {
        this.ekrankart_adı = ekrankart_adı;
    }

    public int getEkrankart_bellek() {
        return ekrankart_bellek;
    }

    public void setEkrankart_bellek(int ekrankart_bellek) {
        this.ekrankart_bellek = ekrankart_bellek;
    }

    public int getBit_degeri() {
        return bit_degeri;
    }

    public void setBit_degeri(int bit_degeri) {
        this.bit_degeri = bit_degeri;
    }

    public String getBellek_tipi() {
        return bellek_tipi;
    }

    public void setBellek_tipi(String bellek_tipi) {
        this.bellek_tipi = bellek_tipi;
    }

    public String getSlot_yapisi() {
        return slot_yapisi;
    }

    public void setSlot_yapisi(String slot_yapisi) {
        this.slot_yapisi = slot_yapisi;
    }

    public int getEkrankart_fiyat() {
        return ekrankart_fiyat;
    }

    public void setEkrankart_fiyat(int ekrankart_fiyat) {
        this.ekrankart_fiyat = ekrankart_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.ekrankart_id;
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
        final EkranKarti other = (EkranKarti) obj;
        if (this.ekrankart_id != other.ekrankart_id) {
            return false;
        }
        return true;
    }

}
