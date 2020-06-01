package dao;

import entity.Kampanya;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KampanyaDAO extends DBConnection {

    public void create(Kampanya a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("insert into kampanya VALUES(?,?,?,?)");
            pst.setInt(1, a.getKampanya_id());
            pst.setString(2, a.getKampanya_turu());
            pst.setString(3, a.getKampanya_adı());
            pst.setInt(4, a.getIndirim_yuzdesi());

            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kampanya a) {
        try {
            PreparedStatement pst = this.connect().prepareStatement("delete from kampanya where kampanya_id=?");
            pst.setInt(1, a.getKampanya_id());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kampanya a) {

        try {
            PreparedStatement pst = this.connect().prepareStatement("update kampanya set kampanya_turu= ? , kampanya_adı= ? , indirim_yuzdesi= ? where kampanya_id= ?");
            pst.setString(1, a.getKampanya_turu());
            pst.setString(2, a.getKampanya_adı());
            pst.setInt(3, a.getIndirim_yuzdesi());
            pst.setInt(4, a.getKampanya_id());

            pst.executeUpdate();

            pst.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kampanya> read(int page, int pageSize) {
        List<Kampanya> aList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.connect().prepareStatement("select *from kampanya order by kampanya_id asc limit ? , ?");
            pst.setInt(1, start);
            pst.setInt(2, pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Kampanya h = new Kampanya(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                aList.add(h);
            }
            pst.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return aList;
    }

    public Kampanya getById(int kampanya_id) {
        Kampanya h = null;
        try {

            if (kampanya_id != 0) {
                PreparedStatement pst = this.connect().prepareStatement("select *from kampanya where kampanya_id=?");
                pst.setLong(1, kampanya_id);

                ResultSet rs = pst.executeQuery();
                rs.next();

                h = new Kampanya(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return h;
    }

}
