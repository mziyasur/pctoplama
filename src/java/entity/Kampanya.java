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
public class Kampanya {

    private int kampanya_id;
    private String kampanya_turu;
    private String kampanya_adı;
    private int indirim_yuzdesi;

    public Kampanya() {
    }

    public Kampanya(int kampanya_id, String kampanya_turu, String kampanya_adı, int indirim_yuzdesi) {
        this.kampanya_id = kampanya_id;
        this.kampanya_turu = kampanya_turu;
        this.kampanya_adı = kampanya_adı;
        this.indirim_yuzdesi = indirim_yuzdesi;
    }

    public int getKampanya_id() {
        return kampanya_id;
    }

    public void setKampanya_id(int kampanya_id) {
        this.kampanya_id = kampanya_id;
    }

    public String getKampanya_turu() {
        return kampanya_turu;
    }

    public void setKampanya_turu(String kampanya_turu) {
        this.kampanya_turu = kampanya_turu;
    }

    public String getKampanya_adı() {
        return kampanya_adı;
    }

    public void setKampanya_adı(String kampanya_adı) {
        this.kampanya_adı = kampanya_adı;
    }

    public int getIndirim_yuzdesi() {
        return indirim_yuzdesi;
    }

    public void setIndirim_yuzdesi(int indirim_yuzdesi) {
        this.indirim_yuzdesi = indirim_yuzdesi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.kampanya_id;
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
        final Kampanya other = (Kampanya) obj;
        if (this.kampanya_id != other.kampanya_id) {
            return false;
        }
        return true;
    }
    
    

}
