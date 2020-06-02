package dao;

import entity.Kasa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KasaDAO extends DBConnection {

    public Kasa getById(int id) {
        Kasa g = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kasa where kasa_id=" + id);
            rs.next();
            g = new Kasa(rs.getInt("kasa_id"), rs.getString("kasa_adı"), rs.getString("soket_turu"), rs.getInt("cikis_gücü"), rs.getInt("fan_sayisi"), rs.getString("renk"), rs.getInt("kasa_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return g;
    }

    public void create(Kasa c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into kasa (kasa_adı,soket_turu,cikis_gücü,fan_sayisi,renk,kasa_fiyat) values ('" + c.getKasa_adı() + "','" + c.getSoket_turu() + "','" + c.getCikis_gücü() + "','" + c.getFan_sayisi() + "','" + c.getRenk() + "','" + c.getKasa_fiyat() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Kasa> read(int page, int pageSize) {
        List<Kasa> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kasa order by kasa_id asc limit " + start + "," + pageSize);

            while (rs.next()) {
                Kasa tmp = new Kasa(rs.getInt("kasa_id"), rs.getString("kasa_adı"), rs.getString("soket_turu"), rs.getInt("cikis_gücü"), rs.getInt("fan_sayisi"), rs.getString("renk"), rs.getInt("kasa_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Kasa c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update kasa set kasa_adı='" + c.getKasa_adı() + "',soket_turu='" + c.getSoket_turu() + "',cikis_gücü='" + c.getCikis_gücü() + "',fan_sayisi='" + c.getFan_sayisi() + "',renk='" + c.getRenk() + "',kasa_fiyat='" + c.getKasa_fiyat() + "'where kasa_id=" + c.getKasa_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Kasa c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from kasa where kasa_id=" + c.getKasa_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();

            ResultSet rs = st.executeQuery("select count(kasa_id) as kasa_count from kasa");
            rs.next();

            count = rs.getInt("kasa_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
