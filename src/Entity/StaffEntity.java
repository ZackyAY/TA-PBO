package Entity;

public class StaffEntity extends AkunEntity {
    public static StaffEntity staffLogged;
    private String NamaStaff;

    public StaffEntity(String namaStaff, String npm, String password) {
        this.NamaStaff = namaStaff;
        this.npm = npm;
        this.password = password;
    }

    public String getNamaStaff() {
        return NamaStaff;
    }

    public void setNamaStaff(String namaStaff) {
        NamaStaff = namaStaff;
    }
}
