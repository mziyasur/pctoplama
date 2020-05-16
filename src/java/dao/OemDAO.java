/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Anakart;
import entity.Bellek;
import entity.EkranKarti;
import entity.Harddisk;
import entity.Islemci;
import entity.IsletimSistemi;
import entity.Kasa;
import entity.Monitor;
import entity.Oem;
import entity.Ssd;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author mehme
 */
public class OemDAO extends DBConnection {
    //CRUD İŞLEMLERİ
    //this.connect();

    private AnakartDAO anakDao;
    private BellekDAO bellekDao;
    private EkranKartiDAO ekrankartiDao;
    private HarddiskDAO harddiskDao;
    private IslemciDAO islemciDao;
    private KasaDAO kasaDao;
    private MonitorDAO monitorDao;
    private SsdDAO ssdDao;
    private IsletimSistemiDAO isletimsistemiDao;

    public AnakartDAO getAnakDao() {
        if (anakDao == null) {
            this.anakDao = new AnakartDAO();
        }
        return anakDao;
    }

    public void setAnakDao(AnakartDAO anakDao) {
        this.anakDao = anakDao;
    }

    public BellekDAO getBellekDao() {
        if (bellekDao == null) {
            this.bellekDao = new BellekDAO();
        }
        return bellekDao;
    }

    public void setBellekDao(BellekDAO bellekDao) {
        this.bellekDao = bellekDao;
    }

    public EkranKartiDAO getEkrankartiDao() {
        if (ekrankartiDao == null) {
            this.ekrankartiDao = new EkranKartiDAO();
        }
        return ekrankartiDao;
    }

    public void setEkrankartiDao(EkranKartiDAO ekrankartiDao) {
        this.ekrankartiDao = ekrankartiDao;

    }

    public HarddiskDAO getHarddiskDao() {
        if (harddiskDao == null) {
            this.harddiskDao = new HarddiskDAO();
        }
        return harddiskDao;
    }

    public void setHarddiskDao(HarddiskDAO harddiskDao) {
        this.harddiskDao = harddiskDao;
    }

    public IslemciDAO getIslemciDao() {
        if (islemciDao == null) {
            this.islemciDao = new IslemciDAO();
        }
        return islemciDao;
    }

    public void setIslemciDao(IslemciDAO islemciDao) {
        this.islemciDao = islemciDao;
    }

    public KasaDAO getKasaDao() {
        if (kasaDao == null) {
            this.kasaDao = new KasaDAO();
        }
        return kasaDao;
    }

    public void setKasaDao(KasaDAO kasaDao) {
        this.kasaDao = kasaDao;
    }

    public MonitorDAO getMonitorDao() {
        if (monitorDao == null) {
            this.monitorDao = new MonitorDAO();
        }
        return monitorDao;
    }

    public void setMonitorDao(MonitorDAO monitorDao) {
        this.monitorDao = monitorDao;
    }

    public SsdDAO getSsdDao() {
        if (ssdDao == null) {
            this.ssdDao = new SsdDAO();
        }
        return ssdDao;
    }

    public void setSsdDao(SsdDAO ssdDao) {
        this.ssdDao = ssdDao;
    }

    public IsletimSistemiDAO getIsletimsistemiDao() {
        if (isletimsistemiDao == null) {
            this.isletimsistemiDao = new IsletimSistemiDAO();
        }
        return isletimsistemiDao;
    }

    public void setIsletimsistemiDao(IsletimSistemiDAO isletimsistemiDao) {
        this.isletimsistemiDao = isletimsistemiDao;
    }

    public void create(Oem c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into oem (islemci_id ,anakart_id ,bellek_id ,kasa_id ,ekrankart_id,harddisk_id ,ssd_id ,monitor_id ,isletim_id) values ('" + c.getIslemci().getIslemci_id() + "','" + c.getAnakart().getAnakart_id() + "','" + c.getBellek().getBellek_id() + "','" + c.getKasa().getKasa_id() + "','" + c.getEkrankarti().getEkrankart_id() + "','" + c.getHarddisk().getHarddisk_id() + "','" + c.getSsd().getSsd_id() + "','" + c.getMonitor().getMonitor_id() + "','" + c.getIsletimsistemi().getIsletim_id() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Oem> read() {
        List<Oem> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from oem order by oem_id asc");
            while (rs.next()) {
                Islemci a = this.getIslemciDao().getById(rs.getInt("islemci_id"));
                Anakart b = this.getAnakDao().getById(rs.getInt("anakart_id"));
                Bellek c = this.getBellekDao().getById(rs.getInt("bellek_id"));
                Kasa d = this.getKasaDao().getById(rs.getInt("kasa_id"));
                EkranKarti e = this.getEkrankartiDao().getById(rs.getInt("ekrankart_id"));
                Harddisk f = this.getHarddiskDao().getById(rs.getInt("harddisk_id"));
                Ssd g = this.getSsdDao().getById(rs.getInt("ssd_id"));
                Monitor h = this.getMonitorDao().getById(rs.getInt("monitor_id"));
                IsletimSistemi k = this.getIsletimsistemiDao().getById(rs.getInt("isletim_id"));

                Oem tmp = new Oem(rs.getInt("oem_id"), a, b, c, d, e, f, g, h, k);
                list.add(tmp);
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Oem c) {

        try {
            Statement st = this.connect().createStatement();
            //st.executeUpdate("update oem set oem_adı='" + c.getOem_adı() + "',uyumlu_kasa='" + c.getUyumlu_kasa() + "',soket_turu='" + c.getSoket_turu() + "',bellek_turu='" + c.getBellek_turu() + "',maxbellek='" + c.getMaxbellek() + "'where oem_id=" + c.getOem_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Oem c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from oem where oem_id=" + c.getOem_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
}
