package dao;

import entity.Kampanya;
import entity.Kullanici;
import entity.KullaniciKampanya;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KullaniciKampanyaDAO extends DBConnection {

    private KullaniciDAO kullaniciDao;
    private KampanyaDAO kampanyaDao;

    public KullaniciDAO getKullaniciDao() {
        if (kullaniciDao == null) {
            kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public KampanyaDAO getKampanyaDao() {
        if (kampanyaDao == null) {
            kampanyaDao = new KampanyaDAO();
        }
        return kampanyaDao;
    }

    public void setKampanyaDao(KampanyaDAO kampanyaDao) {
        this.kampanyaDao = kampanyaDao;
    }

    public void create(KullaniciKampanya a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into kullanicikampanya(kampanya_id,kullanici_id) VALUES(?,?)");

            pst.setInt(1, a.getKampanyaEntity().getKampanya_id());
            pst.setInt(2, a.getKullaniciEntity().getKullanici_id());

            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(KullaniciKampanya a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from kullanicikampanya where kullaniciKampanya_id= ?");
            pst.setInt(1, a.getKullaniciKampanya_id());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(KullaniciKampanya a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("update kullanicikampanya set kampanya_id= ? , kullanici_id= ? "
                    + " where kullaniciKampanya_id= ?");

            pst.setInt(1, a.getKampanyaEntity().getKampanya_id());
            pst.setInt(2, a.getKullaniciEntity().getKullanici_id());
            pst.setInt(3, a.getKullaniciKampanya_id());

            pst.executeUpdate();
            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<KullaniciKampanya> read(int page, int pageSize) {
        List<KullaniciKampanya> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from kullanicikampanya order by kullaniciKampanya_id asc limit ? , ?");
            pst.setInt(1, start);
            pst.setInt(2, pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Kampanya kam = this.getKampanyaDao().getById(rs.getInt(3));
                Kullanici kul = this.getKullaniciDao().getById(rs.getInt(2));
                KullaniciKampanya kulkamp = new KullaniciKampanya(rs.getInt(1), kul, kam, rs.getDate(4));
                aList.add(kulkamp);
            }
            pst.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }
    
    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.connect().prepareStatement("select  count(kullaniciKampanya_id) as kullaniciKampanya_count from kullanicikampanya");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("kullaniciKampanya_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

}
