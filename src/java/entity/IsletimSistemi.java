package entity;

public class IsletimSistemi {

    private int isletim_id;
    private String isletim_adı;
    private String lisans_surum;
    private String win_surum;
    private String dil;
    private int isletimsistemi_fiyat;

    public IsletimSistemi() {
    }

    public IsletimSistemi(int isletim_id, String isletim_adı, String lisans_surum, String win_surum, String dil, int isletimsistemi_fiyat) {
        this.isletim_id = isletim_id;
        this.isletim_adı = isletim_adı;
        this.lisans_surum = lisans_surum;
        this.win_surum = win_surum;
        this.dil = dil;
        this.isletimsistemi_fiyat = isletimsistemi_fiyat;
    }

    public int getIsletim_id() {
        return isletim_id;
    }

    public void setIsletim_id(int isletim_id) {
        this.isletim_id = isletim_id;
    }

    public String getIsletim_adı() {
        return isletim_adı;
    }

    public void setIsletim_adı(String isletim_adı) {
        this.isletim_adı = isletim_adı;
    }

    public String getLisans_surum() {
        return lisans_surum;
    }

    public void setLisans_surum(String lisans_surum) {
        this.lisans_surum = lisans_surum;
    }

    public String getWin_surum() {
        return win_surum;
    }

    public void setWin_surum(String win_surum) {
        this.win_surum = win_surum;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public int getIsletimsistemi_fiyat() {
        return isletimsistemi_fiyat;
    }

    public void setIsletimsistemi_fiyat(int isletimsistemi_fiyat) {
        this.isletimsistemi_fiyat = isletimsistemi_fiyat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.isletim_id;
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
        final IsletimSistemi other = (IsletimSistemi) obj;
        if (this.isletim_id != other.isletim_id) {
            return false;
        }
        return true;
    }
}
