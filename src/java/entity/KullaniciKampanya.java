/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author mehme
 */
public class KullaniciKampanya {

    private int kullaniciKampanya_id;
    private Kullanici kullaniciEntity;
    private Kampanya kampanyaEntity;
    private Date kampanyaTarih;

    public KullaniciKampanya() {
    }

    public KullaniciKampanya(int kullaniciKampanya_id, Kullanici kullaniciEntity, Kampanya kampanyaEntity, Date kampanyaTarih) {
        this.kullaniciKampanya_id = kullaniciKampanya_id;
        this.kullaniciEntity = kullaniciEntity;
        this.kampanyaEntity = kampanyaEntity;
        this.kampanyaTarih = kampanyaTarih;
    }

    public int getKullaniciKampanya_id() {
        return kullaniciKampanya_id;
    }

    public void setKullaniciKampanya_id(int kullaniciKampanya_id) {
        this.kullaniciKampanya_id = kullaniciKampanya_id;
    }

    public Kullanici getKullaniciEntity() {
        if (this.kullaniciEntity == null) {
            kullaniciEntity = new Kullanici();
        }
        return kullaniciEntity;
    }

    public void setKullaniciEntity(Kullanici kullaniciEntity) {
        this.kullaniciEntity = kullaniciEntity;
    }

    public Kampanya getKampanyaEntity() {
        if (this.kampanyaEntity == null) {
            kampanyaEntity = new Kampanya();
        }
        return kampanyaEntity;
    }

    public void setKampanyaEntity(Kampanya kampanyaEntity) {
        this.kampanyaEntity = kampanyaEntity;
    }

    public Date getKampanyaTarih() {
        return kampanyaTarih;
    }

    public void setKampanyaTarih(Date kampanyaTarih) {
        this.kampanyaTarih = kampanyaTarih;
    }

}
