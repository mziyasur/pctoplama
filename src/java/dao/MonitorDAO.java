/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Monitor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author mehme
 */
public class MonitorDAO extends DBConnection {

    //CRUD İŞLEMLERİ
    //this.connect();
    public Monitor getById(int id) {
        Monitor k = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from monitor where monitor_id=" + id);
            rs.next();
            k = new Monitor(rs.getInt("monitor_id"), rs.getString("monitor_adı"), rs.getFloat("ekranboyutu_inc"), rs.getString("cozunurluk"), rs.getInt("yenileme_hizi"), rs.getFloat("tepkime_suresi"), rs.getString("baglanti_tipi"), rs.getInt("monitor_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }

    public void create(Monitor c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into monitor (monitor_adı,ekranboyutu_inc,cozunurluk,yenileme_hizi,tepkime_suresi,baglanti_tipi,monitor_fiyat) values ('" + c.getMonitor_adı() + "','" + c.getEkranboyutu_inc() + "','" + c.getCozunurluk() + "','" + c.getYenileme_hizi() + "','" + c.getTepkime_suresi() + "','" + c.getBaglanti_tipi() + "','" + c.getMonitor_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

     public List<Monitor> read(int page, int pageSize) {
        List<Monitor> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from monitor order by monitor_id asc limit " + start + "," + pageSize);

            while (rs.next()) {
                Monitor tmp = new Monitor(rs.getInt("monitor_id"), rs.getString("monitor_adı"), rs.getFloat("ekranboyutu_inc"), rs.getString("cozunurluk"), rs.getInt("yenileme_hizi"), rs.getFloat("tepkime_suresi"), rs.getString("baglanti_tipi"), rs.getInt("monitor_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Monitor c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update monitor set monitor_adı='" + c.getMonitor_adı() + "',ekranboyutu_inc='" + c.getEkranboyutu_inc() + "',cozunurluk='" + c.getCozunurluk() + "',yenileme_hizi='" + c.getYenileme_hizi() + "',tepkime_suresi='" + c.getTepkime_suresi() + "',baglanti_tipi='" + c.getBaglanti_tipi() + "',monitor_fiyat='" + c.getMonitor_fiyat() + "'where monitor_id=" + c.getMonitor_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Monitor c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from monitor where monitor_id=" + c.getMonitor_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
    public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();

            ResultSet rs = st.executeQuery("select count(monitor_id) as monitor_count from monitor");
            rs.next();

            count = rs.getInt("monitor_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
