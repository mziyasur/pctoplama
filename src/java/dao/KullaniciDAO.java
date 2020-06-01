package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class KullaniciDAO extends DBConnection {

    public Kullanici findByusername(String kullanici_ad) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("select * from kullanici where kullanici_ad=?");
            pst.setString(1, kullanici_ad);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("kullanici_ad").equals(kullanici_ad)) {
                    Kullanici temp = new Kullanici();
                    temp.setKullanici_ad(rs.getString("kullanici_ad"));
                    temp.setKullanici_sifre(rs.getString("kullanici_sifre"));
                    return temp;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
