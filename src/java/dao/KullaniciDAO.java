package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

    public void create(Kullanici a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into kullanici VALUES(?,?,?)");
            pst.setInt(1, a.getKullanici_id());
            pst.setString(2, a.getKullanici_ad());
            pst.setString(3, a.getKullanici_sifre());

            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kullanici a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from kullanici where kullanici_id=?");
            pst.setInt(1, a.getKullanici_id());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kullanici a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("update kullanici set kullanici_sifre= ? where kullanici_id=?");
            pst.setString(1, a.getKullanici_sifre());
            pst.setInt(2, a.getKullanici_id());
            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kullanici> read(int page, int pageSize) {
        List<Kullanici> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from kullanici order by kullanici_id asc limit ? , ?");
            pst.setInt(1, start);
            pst.setInt(2, pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Kullanici y = new Kullanici(rs.getInt(1), rs.getString(2), rs.getString(3));
                aList.add(y);
            }
            pst.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public Kullanici getById(int kullanici_id) {
        Kullanici y = null;
        try {

            if (kullanici_id != 0) {
                PreparedStatement pst = this.connect().prepareStatement("select *from kullanici where kullanici_id=?");
                pst.setLong(1, kullanici_id);

                ResultSet rs = pst.executeQuery();
                rs.next();

                y = new Kullanici(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return y;
    }

}
