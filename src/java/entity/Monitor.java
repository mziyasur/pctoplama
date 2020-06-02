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
public class Monitor {

    private int monitor_id;
    private String monitor_adı;
    private float ekranboyutu_inc;
    private String cozunurluk;
    private int yenileme_hizi;
    private float tepkime_suresi;
    private String baglanti_tipi;
    private int monitor_fiyat;

    public Monitor() {
    }

    public Monitor(int monitor_id, String monitor_adı, float ekranboyutu_inc, String cozunurluk, int yenileme_hizi, float tepkime_suresi, String baglanti_tipi, int monitor_fiyat) {
        this.monitor_id = monitor_id;
        this.monitor_adı = monitor_adı;
        this.ekranboyutu_inc = ekranboyutu_inc;
        this.cozunurluk = cozunurluk;
        this.yenileme_hizi = yenileme_hizi;
        this.tepkime_suresi = tepkime_suresi;
        this.baglanti_tipi = baglanti_tipi;
        this.monitor_fiyat = monitor_fiyat;
    }

    public int getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(int monitor_id) {
        this.monitor_id = monitor_id;
    }

    public String getMonitor_adı() {
        return monitor_adı;
    }

    public void setMonitor_adı(String monitor_adı) {
        this.monitor_adı = monitor_adı;
    }

    public float getEkranboyutu_inc() {
        return ekranboyutu_inc;
    }

    public void setEkranboyutu_inc(float ekranboyutu_inc) {
        this.ekranboyutu_inc = ekranboyutu_inc;
    }

    public String getCozunurluk() {
        return cozunurluk;
    }

    public void setCozunurluk(String cozunurluk) {
        this.cozunurluk = cozunurluk;
    }

    public int getYenileme_hizi() {
        return yenileme_hizi;
    }

    public void setYenileme_hizi(int yenileme_hizi) {
        this.yenileme_hizi = yenileme_hizi;
    }

    public float getTepkime_suresi() {
        return tepkime_suresi;
    }

    public void setTepkime_suresi(float tepkime_suresi) {
        this.tepkime_suresi = tepkime_suresi;
    }

    public String getBaglanti_tipi() {
        return baglanti_tipi;
    }

    public void setBaglanti_tipi(String baglanti_tipi) {
        this.baglanti_tipi = baglanti_tipi;
    }

    public int getMonitor_fiyat() {
        return monitor_fiyat;
    }

    public void setMonitor_fiyat(int monitor_fiyat) {
        this.monitor_fiyat = monitor_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.monitor_id;
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
        final Monitor other = (Monitor) obj;
        if (this.monitor_id != other.monitor_id) {
            return false;
        }
        return true;
    }
    
}
