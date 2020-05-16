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
public class Oem {

    private int oem_id;
    private Islemci islemci;
    private Anakart anakart;
    private Bellek bellek;
    private Kasa kasa;
    private EkranKarti ekrankarti;
    private Harddisk harddisk;
    private Ssd ssd;
    private Monitor monitor;
    private IsletimSistemi isletimsistemi;

    public Oem() {
    }

    public Oem(int oem_id, Islemci islemci, Anakart anakart, Bellek bellek, Kasa kasa, EkranKarti ekrankarti, Harddisk harddisk, Ssd ssd, Monitor monitor, IsletimSistemi isletimsistemi) {
        this.oem_id = oem_id;
        this.islemci = islemci;
        this.anakart = anakart;
        this.bellek = bellek;
        this.kasa = kasa;
        this.ekrankarti = ekrankarti;
        this.harddisk = harddisk;
        this.ssd = ssd;
        this.monitor = monitor;
        this.isletimsistemi = isletimsistemi;
    }

    public int getOem_id() {
        return oem_id;
    }

    public void setOem_id(int oem_id) {
        this.oem_id = oem_id;
    }

    public Islemci getIslemci() {
        return islemci;
    }

    public void setIslemci(Islemci islemci) {
        this.islemci = islemci;
    }

    public Anakart getAnakart() {
        return anakart;
    }

    public void setAnakart(Anakart anakart) {
        this.anakart = anakart;
    }

    public Bellek getBellek() {
        return bellek;
    }

    public void setBellek(Bellek bellek) {
        this.bellek = bellek;
    }

    public Kasa getKasa() {
        return kasa;
    }

    public void setKasa(Kasa kasa) {
        this.kasa = kasa;
    }

    public EkranKarti getEkrankarti() {
        return ekrankarti;
    }

    public void setEkrankarti(EkranKarti ekrankarti) {
        this.ekrankarti = ekrankarti;
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(Harddisk harddisk) {
        this.harddisk = harddisk;
    }

    public Ssd getSsd() {
        return ssd;
    }

    public void setSsd(Ssd ssd) {
        this.ssd = ssd;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public IsletimSistemi getIsletimsistemi() {
        return isletimsistemi;
    }

    public void setIsletimsistemi(IsletimSistemi isletimsistemi) {
        this.isletimsistemi = isletimsistemi;
    }

}
