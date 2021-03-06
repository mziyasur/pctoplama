package dao;

import entity.Harddisk;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class HarddiskDAO extends DBConnection {

    public Harddisk getById(int id) {
        Harddisk d = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hard_disk where harddisk_id=" + id);
            rs.next();
            d = new Harddisk(rs.getInt("harddisk_id"), rs.getString("harddisk_adı"), rs.getFloat("harddisk_kapasite"), rs.getFloat("harddisk_inc"), rs.getString("harddisk_arabirim"), rs.getInt("harddisk_donushizi"), rs.getInt("harddisk_onbellek"), rs.getInt("harddisk_fiyat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return d;
    }

    public void create(Harddisk c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into hard_disk (harddisk_adı,harddisk_kapasite,harddisk_inc,harddisk_arabirim,harddisk_donushizi,harddisk_onbellek,harddisk_fiyat) values ('" + c.getHarddisk_adı() + "','" + c.getHarddisk_kapasite() + "','" + c.getHarddisk_inc() + "','" + c.getHarddisk_arabirim() + "','" + c.getHarddisk_donushizi() + "','" + c.getHarddisk_onbellek() + "','" + c.getHarddisk_fiyat() + "')");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public List<Harddisk> read(int page, int pageSize) {
        List<Harddisk> list = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hard_disk order by harddisk_id asc limit " + start + "," + pageSize);

            while (rs.next()) {
                Harddisk tmp = new Harddisk(rs.getInt("harddisk_id"), rs.getString("harddisk_adı"), rs.getFloat("harddisk_kapasite"), rs.getFloat("harddisk_inc"), rs.getString("harddisk_arabirim"), rs.getInt("harddisk_donushizi"), rs.getInt("harddisk_onbellek"), rs.getInt("harddisk_fiyat"));
                list.add(tmp);

            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;

    }

    public void update(Harddisk c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update hard_disk set harddisk_adı='" + c.getHarddisk_adı() + "',harddisk_kapasite='" + c.getHarddisk_kapasite() + "',harddisk_inc='" + c.getHarddisk_inc() + "',harddisk_arabirim='" + c.getHarddisk_arabirim() + "',harddisk_donushizi='" + c.getHarddisk_donushizi() + "',harddisk_onbellek='" + c.getHarddisk_onbellek() + "',harddisk_fiyat='" + c.getHarddisk_fiyat() + "'where harddisk_id=" + c.getHarddisk_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void delete(Harddisk c) {

        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hard_disk where harddisk_id=" + c.getHarddisk_id());

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public int count() {
        int count = 0;

        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(harddisk_id) as hard_disk_count from hard_disk");
            rs.next();

            count = rs.getInt("hard_disk_count");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return count;

    }
}
