package Entity;

public class PenulisEntity extends IdentitasEntity {
    private String emailPenulis;

    public PenulisEntity() {

    }

    public PenulisEntity(String namaPenulis) {
        this.nama = namaPenulis;
        this.emailPenulis = "-";
    }

    public PenulisEntity(String namaPenulis, String emailPenulis) {
        this.nama = namaPenulis;
        this.emailPenulis = emailPenulis;
    }

    // Method
    public void dataPenulis() {
        System.out.println("Nama Penulis    :" + nama);
        System.out.println("Email Penulis :" + emailPenulis);

    }

    public String getEmailPenulis() {
        return emailPenulis;
    }

    public void setEmailPenulis(String emailPenulis) {
        this.emailPenulis = emailPenulis;
    }
}
