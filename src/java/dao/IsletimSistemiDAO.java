package dao;

import entity.IsletimSistemi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class IsletimSistemiDAO extends DBConnection {

    public IsletimSistemi getById(int id) {
        IsletimSistemi f = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from isletim_sistemi where isletim_id=" + id);
            rs.next();
            f = new IsletimSistemi(rs.getInt("isletim_id"), rs.getString("isletim_adı"), rs.getString("lisans_surum"), rs.getString("win_surum"), rs.getString("dil"), rs.getInt("isletimsistemi_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return f;
    }

    public void create(IsletimSistemi c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into isletim_sistemi (isletim_adı,lisans_surum,win_surum,dil,isletimsistemi_fiyat) values ('" + c.getIsletim_adı() + "','" + c.getLisans_surum() + "','" + c.getWin_surum() + "','" + c.getDil() + "','" + c.getIsletimsistemi_fiyat() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<IsletimSistemi> read() {
        List<IsletimSistemi> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from isletim_sistemi order by isletim_id asc");
            while (rs.next()) {
                IsletimSistemi tmp = new IsletimSistemi(rs.getInt("isletim_id"), rs.getString("isletim_adı"), rs.getString("lisans_surum"), rs.getString("win_surum"), rs.getString("dil"), rs.getInt("isletimsistemi_fiyat"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(IsletimSistemi c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update isletim_sistemi set isletim_adı='" + c.getIsletim_adı() + "',lisans_surum='" + c.getLisans_surum() + "',win_surum='" + c.getWin_surum() + "',dil='" + c.getDil() + "',isletimsistemi_fiyat='" + c.getIsletimsistemi_fiyat() + "'where isletim_id=" + c.getIsletim_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(IsletimSistemi c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from isletim_sistemi where isletim_id=" + c.getIsletim_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
