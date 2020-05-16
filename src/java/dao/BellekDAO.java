/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bellek;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author mehme
 */
public class BellekDAO extends DBConnection {
    //CRUD İŞLEMLERİ
    //this.connect();

    public Bellek getById(int id) {
        Bellek b = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from bellek where bellek_id=" + id);
            rs.next();
            b = new Bellek(rs.getInt("bellek_id"), rs.getString("bellek_adı"), rs.getInt("kapasite"), rs.getString("bellek_turu"), rs.getString("calisma_hizi"), rs.getString("gecikme_degeri"), rs.getInt("bellek_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return b;
    }

    public void create(Bellek c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into bellek (bellek_adı,kapasite,bellek_turu,calisma_hizi,gecikme_degeri,bellek_fiyat) values ('" + c.getBellek_adı() + "','" + c.getKapasite() + "','" + c.getBellek_turu() + "','" + c.getCalisma_hizi() + "','" + c.getGecikme_degeri() + "','" + c.getBellek_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Bellek> read() {
        List<Bellek> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from bellek order by bellek_id asc");
            while (rs.next()) {
                Bellek tmp = new Bellek(rs.getInt("bellek_id"), rs.getString("bellek_adı"), rs.getInt("kapasite"), rs.getString("bellek_turu"), rs.getString("calisma_hizi"), rs.getString("gecikme_degeri"), rs.getInt("bellek_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Bellek c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update bellek set bellek_adı='" + c.getBellek_adı() + "',kapasite='" + c.getKapasite() + "',bellek_turu='" + c.getBellek_turu() + "',calisma_hizi='" + c.getCalisma_hizi() + "',gecikme_degeri='" + c.getGecikme_degeri() + "',bellek_fiyat='" + c.getBellek_fiyat() + "'where bellek_id=" + c.getBellek_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Bellek c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from bellek where bellek_id=" + c.getBellek_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
}
