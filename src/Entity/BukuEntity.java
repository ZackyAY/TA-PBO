package Entity;
import Model.*;

public class BukuEntity extends KoleksiEntity {
    // Atribut Class Entity.BukuEntity


    private String judul;
    private int Halaman;
    private String kategori;
    private String tanggalTerbit;
    private PenulisEntity penulis;
    private PenerbitEntity penerbit;

    public BukuEntity(String judul, int halaman, String tanggalterbit, PenulisEntity penulis, PenerbitEntity penerbit, boolean b) {

    }

    public BukuEntity(String judul, int halaman, String kategori, String tanggalTerbit, PenulisEntity penulis, PenerbitEntity penerbit) {
        this.judul = judul;
        Halaman = halaman;
        this.kategori = kategori;
        this.tanggalTerbit = tanggalTerbit;
        this.penulis = penulis;
        this.penerbit = penerbit;
    }

    public BukuEntity(String judulBuku,
                int Halaman, String kategori, String tanggalTerbit,
                PenulisEntity penulis, PenerbitEntity penerbit, boolean status) {
        idBukuBaru();
        this.judul = judulBuku;
        this.Halaman = Halaman;
        this.kategori = kategori;
        this.tanggalTerbit = tanggalTerbit;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.status = status;
    }

    private void idBukuBaru() {

        if (LibraryModel.dataBuku.size() == 0) {
            // Jika ArrayList buku MASIH Kosong,
            // maka atur idBuku menjadi 1
            this.idKoleksi = 1;
        } else {
            // Jika ArrayList Buku TIDAK Kosong, maka

            // Ambil index Terakhir dalam List
            int indexTerakhirDalamList = LibraryModel.dataBuku.size() - 1;

            // Ambil Object Buku dalam List berdasarkan indexnya.
            BukuEntity bukuTerakhirDalamList = LibraryModel.dataBuku.get(indexTerakhirDalamList);

            // Ambil idBuku pada Object Buku terakhir
            int idBukuTerakhir = bukuTerakhirDalamList.idKoleksi;

            // Id Buku yang baru
            this.idKoleksi = idBukuTerakhir + 1;
        }
    }

    // Method
    public void dataBuku() {
        System.out.println("ID buku  :" + idKoleksi);
        System.out.println("Judul Buku  : " + judul);
        System.out.println("jumlah halaman : " + Halaman);
        System.out.println("Genre Buku  : " + kategori);
        System.out.println("Tanggal terbit : " + tanggalTerbit);
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getHalaman() {
        return Halaman;
    }

    public void setHalaman(int halaman) {
        Halaman = halaman;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getTanggalTerbit() {
        return tanggalTerbit;
    }

    public void setTanggalTerbit(String tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public PenulisEntity getPenulis() {
        return penulis;
    }

    public void setPenulis(PenulisEntity penulis) {
        this.penulis = penulis;
    }

    public PenerbitEntity getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(PenerbitEntity penerbit) {
        this.penerbit = penerbit;
    }
}