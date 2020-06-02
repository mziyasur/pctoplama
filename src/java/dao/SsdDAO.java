/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class SsdDAO extends DBConnection {
    //CRUD İŞLEMLERİ
    //this.connect();

    public Ssd getById(int id) {
        Ssd l = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ssd where ssd_id=" + id);
            rs.next();
            l = new Ssd(rs.getInt("ssd_id"), rs.getString("ssd_adı"), rs.getString("ssd_kapasite"), rs.getString("ssd_arabirim"), rs.getString("ssd_okumahizi"), rs.getString("ssd_yazmahizi"), rs.getInt("ssd_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    public void create(Ssd c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ssd (ssd_adı,ssd_kapasite,ssd_arabirim,ssd_okumahizi,ssd_yazmahizi,ssd_fiyat) values ('" + c.getSsd_adı() + "','" + c.getSsd_kapasite() + "','" + c.getSsd_arabirim() + "','" + c.getSsd_okumahizi() + "','" + c.getSsd_yazmahizi() + "','" + c.getSsd_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Ssd> read(int page, int pageSize) {
        List<Ssd> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ssd order by ssd_id asc limit " + start + "," + pageSize);

            while (rs.next()) {
                Ssd tmp = new Ssd(rs.getInt("ssd_id"), rs.getString("ssd_adı"), rs.getInt("ssd_kapasite"), rs.getString("ssd_arabirim"), rs.getInt("ssd_okumahizi"), rs.getInt("ssd_yazmahizi"), rs.getInt("ssd_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }
    public void update(Ssd c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ssd set ssd_adı='" + c.getSsd_adı() + "',ssd_kapasite='" + c.getSsd_kapasite() + "',ssd_arabirim='" + c.getSsd_arabirim() + "',ssd_okumahizi='" + c.getSsd_okumahizi() + "',ssd_yazmahizi='" + c.getSsd_yazmahizi() + "',ssd_fiyat='" + c.getSsd_fiyat() + "'where ssd_id=" + c.getSsd_id());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Ssd c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ssd where ssd_id=" + c.getSsd_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
    
    public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();

            ResultSet rs = st.executeQuery("select count(ssd_id) as ssd_count from ssd");
            rs.next();

            count = rs.getInt("ssd_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
