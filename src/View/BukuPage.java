package View;

import Entity.BukuEntity;
import Entity.PenerbitEntity;
import Entity.PenulisEntity;
import Model.*;


import java.util.Scanner;

public class BukuPage {
    private Scanner input = new Scanner(System.in);

    private void lihatBuku(BukuEntity buku){
        PenulisEntity penulis = buku.getPenulis();
        PenerbitEntity penerbit = buku.getPenerbit();

        System.out.println("---------------------------------------");
        System.out.println("ID Buku         :"+buku.getIdKoleksi());
        System.out.println("Judul Buku      :"+buku.getJudul());
        System.out.println("Jumlah Halaman  :"+buku.getHalaman());
        if (penulis != null){
            System.out.println("Nama Penulis    :"+penulis.getNama());
        }else {
            System.out.println("Nama Penulis    : Tidak diketahui");
        }
        if (penerbit != null){
            System.out.println("Penerbit        :"+penerbit.getNama());
            System.out.println("Alamat penerbit :"+penerbit.getAlamatPenerbit());
        }else {
            System.out.println("Penerbit        : Tidak diketahui");
        }
        System.out.println("Tanggal Terbit  :"+buku.getTanggalTerbit());
        System.out.println("---------------------------------------");
    }
    public void lihatbuku(){
        System.out.println("============== LIHAT BUKU =============");
        for (BukuEntity buku : LibraryModel.dataBuku){
            lihatBuku(buku);
        }
        System.out.println("=======================================");

        System.out.print("Lanjut....");

        System.out.println();
    }
    public void tambahBuku() {
        String judul;
        int halaman;
        String tanggalterbit;
        PenulisEntity penulis = null;
        PenerbitEntity penerbit = null;

        System.out.println("============ TAMBAH BUKU ============");
        System.out.print("Judul Buku          :");
        judul = input.nextLine();

        System.out.print("Jumlah Halaman      :");
        halaman = input.nextInt();
        input.nextLine();

        System.out.print("Tanggal Terbit      :");
        tanggalterbit = input.nextLine();

        System.out.print("Masukkan Penulis  (y/n) ?");
        char masukkanPenulis = input.next().charAt(0);
        input.nextLine();

        if (masukkanPenulis == 'y') {
            String namaPenulis;
            System.out.print("Nama Penulis        :");
            namaPenulis = input.nextLine();
            penulis = new PenulisEntity(namaPenulis);
        }

        System.out.print("Masukan Penerbit (y/n) ? ");
        char masukanPenerbit = input.nextLine().charAt(0);

        if (masukanPenerbit == 'y') {
            String namaPenerbit, alamatPenerbit;

            System.out.print("Nama Penerbit       :");
            namaPenerbit = input.nextLine();

            System.out.print("Alamat Penerbit     :");
            alamatPenerbit = input.nextLine();
            penerbit = new PenerbitEntity(namaPenerbit,alamatPenerbit);
        }
        BukuEntity bukuBaru = new BukuEntity(judul,halaman,tanggalterbit, penulis,penerbit,true);
        LibraryModel.tambahBuku(bukuBaru);

        System.out.println("Berhasil Menambahkan Buku");

        System.out.println("=======================================");

        System.out.print("Lanjut ...");

        System.out.println();
    }
    public void editBuku(BukuEntity buku, int pilihEdit) {
        switch (pilihEdit) {
            case 1:
                String judulBukuBaru;
                System.out.println("Judul Buku          : " + buku.getJudul());
                System.out.print("Masukan Judul Baru  : ");
                judulBukuBaru = input.nextLine();
                buku.setJudul(judulBukuBaru);
                break;
            case 2:
                int jmlHalaman;
                System.out.println("Jumlah Halaman              : " + buku.getHalaman());
                System.out.print("Masukan Jumlah Halaman Baru : ");
                jmlHalaman = input.nextInt();
                input.nextLine();
                buku.setHalaman(jmlHalaman);
                break;
        }
        LibraryModel.updateBuku(buku);
        System.out.println("Berhasil mengubah data buku");

        System.out.println("Lanjut....");

        System.out.println();
    }

    public void editBuku(BukuEntity buku) {
        System.out.println("---------------------------------------");
        System.out.println("Ingin mengubah apa ? ");

        int pilihEdit;
        System.out.print("""
                1. Judul Buku
                2. Jumlah Halaman
                3. Tanggal Terbit
                4. Entity.Penulis
                5. Entity.Penerbit
                6. Status
                0. Selesai
                Pilih: """);
        pilihEdit = input.nextInt();
        input.nextLine();

        editBuku(buku, pilihEdit);
        System.out.println("---------------------------------------");
    }

    public void editBuku() {
        int idKoleksi;

        System.out.println("============= EDIT BUKU =============");

        System.out.print("Masukan ID Entity.Buku: ");
        idKoleksi = input.nextInt();
        input.nextLine();

        BukuEntity buku = LibraryModel.findBukuById(idKoleksi);

        if (buku != null) {
            editBuku(buku);
        } else {
            System.out.println("Data Entity.Buku Tidak Ditemukan !");
        }

        System.out.println("=======================================");
    }

    private void hapusBuku(BukuEntity buku) {
        System.out.println("============ KONFIRMASI ============");

        lihatBuku(buku);

        System.out.println("Ingin Menghapus Entity.Buku ini ? (y/n) ");
        char konf = input.nextLine().charAt(0);

        if (konf == 'y') {
            LibraryModel.deleteBuku(buku);
        }

    }

    public void hapusBuku() {
        int idKoleksi;

        System.out.println("============ HAPUS  BUKU ============");

        System.out.print("Masukan ID Entity.Buku: ");
        idKoleksi = input.nextInt();
        input.nextLine();

        BukuEntity buku = LibraryModel.findBukuById(idKoleksi);

        if (buku != null) {
            hapusBuku(buku);
        } else {
            System.out.println("Data Entity.Buku Tidak Ditemukan !");
        }

        System.out.println("=======================================");
    }
    public void findBukuById () {
        int idbuku;
        System.out.printf("masukkan id buku:");
        idbuku = input.nextInt();
        input.nextLine();

        for (BukuEntity buku : LibraryModel.dataBuku) {
            if (buku.getIdKoleksi()==(idbuku)){
                System.out.println("--------------------------------");
                System.out.println("ID BUKU:" + buku.getIdKoleksi());
                System.out.println("Halaman:" + buku.getHalaman());
                System.out.println("Judul:" + buku.getJudul());
                System.out.println("tahun terbit:" + buku.getTanggalTerbit());
                System.out.println("penulis:"+ buku.getPenulis().getNama());
                System.out.println("penerbit:"+ buku.getPenerbit().getNama());
                System.out.println("Alamat penerbit :"+ buku.getPenerbit().getAlamatPenerbit());
                System.out.println("--------------------------------");

                LibraryModel.findBukuById(idbuku);
            }
        }
    }
    public void findBukuByTitle() {
        String judul;
        System.out.printf("masukkan judul buku:");
        judul = input.nextLine();

        for (BukuEntity buku : LibraryModel.dataBuku) {
            if (buku.getJudul().equals(judul)) {
                System.out.println("--------------------------------");
                System.out.println("ID BUKU:" + buku.getIdKoleksi());
                System.out.println("Halaman:" + buku.getHalaman());
                System.out.println("Judul:" + buku.getJudul());
                System.out.println("tahun terbit:" + buku.getTanggalTerbit());
                System.out.println("penulis:" + buku.getPenulis().getNama());
                System.out.println("penerbit:" + buku.getPenerbit().getNama());
                System.out.println("Alamat penerbit :"+ buku.getPenerbit().getAlamatPenerbit());
                System.out.println("--------------------------------");

                LibraryModel.findBukuByTitle(judul);
            }
        }
    }
    public void filterBukuByAbjad(){

        String judul;
        System.out.print("masukkan huruf :");
        judul = input.nextLine();

        for (BukuEntity buku : LibraryModel.dataBuku){
            if (buku.getJudul().contains(judul)){
                System.out.println("--------------------------------");
                System.out.println("ID BUKU:" + buku.getIdKoleksi());
                System.out.println("Halaman:" + buku.getHalaman());
                System.out.println("Judul:" + buku.getJudul());
                System.out.println("tahun terbit:" + buku.getTanggalTerbit());
                System.out.println("penulis:" + buku.getPenulis().getNama());
                System.out.println("penerbit:" + buku.getPenerbit().getNama());
                System.out.println("Alamat penerbit :"+ buku.getPenerbit().getAlamatPenerbit());
                System.out.println("--------------------------------");

                LibraryModel.filterBukuByJudul(judul);
            }
        }

    }
}
