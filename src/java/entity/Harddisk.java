
package entity;

public class Harddisk {

    private int harddisk_id;
    private String harddisk_adı;
    private String harddisk_kapasite;
    private int harddisk_inc;
    private String harddisk_arabirim;
    private String harddisk_donushizi;
    private String harddisk_onbellek;
    private int harddisk_fiyat;

    public Harddisk() {
    }

    public Harddisk(int harddisk_id, String harddisk_adı, String harddisk_kapasite, int harddisk_inc, String harddisk_arabirim, String harddisk_donushizi, String harddisk_onbellek, int harddisk_fiyat) {
        this.harddisk_id = harddisk_id;
        this.harddisk_adı = harddisk_adı;
        this.harddisk_kapasite = harddisk_kapasite;
        this.harddisk_inc = harddisk_inc;
        this.harddisk_arabirim = harddisk_arabirim;
        this.harddisk_donushizi = harddisk_donushizi;
        this.harddisk_onbellek = harddisk_onbellek;
        this.harddisk_fiyat = harddisk_fiyat;
    }

    public int getHarddisk_id() {
        return harddisk_id;
    }

    public void setHarddisk_id(int harddisk_id) {
        this.harddisk_id = harddisk_id;
    }

    public String getHarddisk_adı() {
        return harddisk_adı;
    }

    public void setHarddisk_adı(String harddisk_adı) {
        this.harddisk_adı = harddisk_adı;
    }

    public String getHarddisk_kapasite() {
        return harddisk_kapasite;
    }

    public void setHarddisk_kapasite(String harddisk_kapasite) {
        this.harddisk_kapasite = harddisk_kapasite;
    }

    public int getHarddisk_inc() {
        return harddisk_inc;
    }

    public void setHarddisk_inc(int harddisk_inc) {
        this.harddisk_inc = harddisk_inc;
    }

    public String getHarddisk_arabirim() {
        return harddisk_arabirim;
    }

    public void setHarddisk_arabirim(String harddisk_arabirim) {
        this.harddisk_arabirim = harddisk_arabirim;
    }

    public String getHarddisk_donushizi() {
        return harddisk_donushizi;
    }

    public void setHarddisk_donushizi(String harddisk_donushizi) {
        this.harddisk_donushizi = harddisk_donushizi;
    }

    public String getHarddisk_onbellek() {
        return harddisk_onbellek;
    }

    public void setHarddisk_onbellek(String harddisk_onbellek) {
        this.harddisk_onbellek = harddisk_onbellek;
    }

    public int getHarddisk_fiyat() {
        return harddisk_fiyat;
    }

    public void setHarddisk_fiyat(int harddisk_fiyat) {
        this.harddisk_fiyat = harddisk_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.harddisk_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Harddisk other = (Harddisk) obj;
        if (this.harddisk_id != other.harddisk_id) {
            return false;
        }
        return true;
    }

}
