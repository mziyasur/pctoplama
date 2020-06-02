/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Anakart;
import entity.EkranKarti;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author mehme
 */
public class EkranKartiDAO extends DBConnection {
    //CRUD İŞLEMLERİ
    //this.connect();

    public EkranKarti getById(int id) {
        EkranKarti c = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ekran_kart where ekrankart_id=" + id);
            rs.next();
            c = new EkranKarti(rs.getInt("ekrankart_id"), rs.getString("ekrankart_adı"), rs.getInt("ekrankart_bellek"), rs.getInt("bit_degeri"), rs.getString("bellek_tipi"), rs.getString("slot_yapisi"), rs.getInt("ekrankart_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void create(EkranKarti c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ekran_kart (ekrankart_adı,ekrankart_bellek,bit_degeri,bellek_tipi,slot_yapisi,ekrankart_fiyat) values ('" + c.getEkrankart_adı() + "','" + c.getEkrankart_bellek() + "','" + c.getBit_degeri() + "','" + c.getBellek_tipi() + "','" + c.getSlot_yapisi() + "','" + c.getEkrankart_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<EkranKarti> read(int page, int pageSize) {
        List<EkranKarti> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ekran_kart order by ekrankart_id asc limit " + start + "," + pageSize);

            while (rs.next()) {
                EkranKarti tmp = new EkranKarti(rs.getInt("ekrankart_id"), rs.getString("ekrankart_adı"), rs.getInt("ekrankart_bellek"), rs.getInt("bit_degeri"), rs.getString("bellek_tipi"), rs.getString("slot_yapisi"), rs.getInt("ekrankart_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(EkranKarti c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ekran_kart set ekrankart_adı='" + c.getEkrankart_adı() + "',ekrankart_bellek='" + c.getEkrankart_bellek() + "',bit_degeri='" + c.getBit_degeri() + "',bellek_tipi='" + c.getBellek_tipi() + "',slot_yapisi='" + c.getSlot_yapisi() + "',ekrankart_fiyat='" + c.getEkrankart_fiyat() + "'where ekrankart_id=" + c.getEkrankart_id());
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(EkranKarti c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ekran_kart where ekrankart_id=" + c.getEkrankart_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
     public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();
            //ResultSet rs = st.executeQuery("select * from anakart order by anakart_id asc");
            ResultSet rs = st.executeQuery("select count(ekrankart_id) as ekran_kart_count from ekran_kart");
            rs.next();

            count = rs.getInt("ekran_kart_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
