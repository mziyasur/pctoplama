
package dao;

import entity.Islemci;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class IslemciDAO extends DBConnection {
    

    public Islemci getById(int id) {
        Islemci e = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from islemci where islemci_id=" + id);
            rs.next();
            e = new Islemci(rs.getInt("islemci_id"), rs.getString("islemci_adı"), rs.getString("islemci_turu"), rs.getString("islemci_nesil"), rs.getInt("temel_frekans"), rs.getInt("turbo_frekans"), rs.getString("onbellek"), rs.getInt("cekirdek_sayisi"), rs.getString("soket_turu"), rs.getInt("islemci_fiyat"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }

    public void create(Islemci c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into islemci (islemci_adı,islemci_turu,islemci_nesil,temel_frekans,turbo_frekans,onbellek,cekirdek_sayisi,soket_turu,islemci_fiyat) values ('" + c.getIslemci_adı() + "','" + c.getIslemci_turu() + "','" + c.getIslemci_nesil() + "','" + c.getTemel_frekans() + "','" + c.getTurbo_frekans() + "','" + c.getOnbellek() + "','" + c.getCekirdek_sayisi() + "','" + c.getSoket_turu() + "','" + c.getIslemci_fiyat() + "')");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Islemci> read() {
        List<Islemci> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from islemci order by islemci_id asc");
            while (rs.next()) {
                Islemci tmp = new Islemci(rs.getInt("islemci_id"), rs.getString("islemci_adı"), rs.getString("islemci_turu"), rs.getString("islemci_nesil"), rs.getInt("temel_frekans"), rs.getInt("turbo_frekans"), rs.getString("onbellek"), rs.getInt("cekirdek_sayisi"), rs.getString("soket_turu"), rs.getInt("islemci_fiyat"));
                list.add(tmp);

            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Islemci c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update islemci set islemci_adı='" + c.getIslemci_adı() + "',islemci_turu='" + c.getIslemci_turu() + "',islemci_nesil='" + c.getIslemci_nesil() + "',temel_frekans='" + c.getTemel_frekans() + "',turbo_frekans='" + c.getTurbo_frekans() + "',onbellek='" + c.getOnbellek() + "',cekirdek_sayisi='" + c.getCekirdek_sayisi() + "',soket_turu='" + c.getSoket_turu() + "',islemci_fiyat='" + c.getIslemci_fiyat() + "'where islemci_id=" + c.getIslemci_id());

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Islemci c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from islemci where islemci_id=" + c.getIslemci_id());

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }
}
