/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Anakart;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author mehme
 */
public class AnakartDAO extends DBConnection {

    //CRUD İŞLEMLERİ
    //this.connect();
    public Anakart getById(int id) {
        Anakart a = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from anakart where anakart_id=" + id);
            rs.next();
            a = new Anakart(rs.getInt("anakart_id"), rs.getString("anakart_adı"), rs.getString("uyumlu_kasa"), rs.getString("soket_turu"), rs.getString("bellek_turu"), rs.getInt("maxbellek"), rs.getInt("anakart_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public void create(Anakart c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into anakart (anakart_adı,uyumlu_kasa,soket_turu,bellek_turu,maxbellek,anakart_fiyat) values ('" + c.getAnakart_adı() + "','" + c.getUyumlu_kasa() + "','" + c.getSoket_turu() + "','" + c.getBellek_turu() + "','" + c.getMaxbellek() + "','" + c.getAnakart_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Anakart> read(int page, int pageSize) {
        List<Anakart> list = new ArrayList<>();
        int start = (page-1)*pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from anakart order by anakart_id asc limit "+start+","+pageSize);
            while (rs.next()) {
                Anakart tmp = new Anakart(rs.getInt("anakart_id"), rs.getString("anakart_adı"), rs.getString("uyumlu_kasa"), rs.getString("soket_turu"), rs.getString("bellek_turu"), rs.getInt("calisma_hizi"), rs.getInt("maxbellek"),rs.getInt("anakart_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Anakart c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update anakart set anakart_adı='" + c.getAnakart_adı() + "',uyumlu_kasa='" + c.getUyumlu_kasa() + "',soket_turu='" + c.getSoket_turu() + "',bellek_turu='" + c.getBellek_turu() + "',maxbellek='" + c.getMaxbellek() + "',anakart_fiyat='" + c.getAnakart_fiyat() + "'where anakart_id=" + c.getAnakart_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Anakart c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from anakart where anakart_id=" + c.getAnakart_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(anakart_id) as anakart_count from anakart");
            rs.next();

            count = rs.getInt("anakart_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
