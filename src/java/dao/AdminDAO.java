package dao;

import entity.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class AdminDAO extends DBConnection {

    public Admin findByadminusername(String admin_ad) {
        try {

            PreparedStatement pst = this.connect().prepareStatement("select * from admin where admin_ad=?");
            pst.setString(1, admin_ad);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("admin_ad").equals(admin_ad)) {
                    Admin tmp = new Admin();
                    tmp.setAdmin_ad(rs.getString("admin_ad"));
                    tmp.setAdmin_sifre(rs.getString("admin_sifre"));
                    return tmp;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

}
