package Model;

import Entity.BukuEntity;
import Entity.StaffEntity;



import java.util.ArrayList;

public class LibraryModel {
    public static ArrayList<BukuEntity> dataBuku = new ArrayList<>();

    public  static ArrayList<BukuEntity> getDataBuku(){
        return dataBuku;
    }
    public static ArrayList<StaffEntity> staffAktif = new ArrayList<>();
    public static int banyakData() {
        return dataBuku.size();
    }



    public static StaffEntity findStaff(String npm) {
        for (StaffEntity staff : staffAktif) {
            if (staff.getNpm().equals(npm)) {
                return staff;
            }
        }
        return null;
    }

    public static void lihatData() {
        for (BukuEntity buku : dataBuku) {

        }
    }

    public static BukuEntity findBukuById(int idbuku) {
        for (BukuEntity buku : dataBuku) {
            if (buku.getIdKoleksi()==(idbuku)){

                return buku;
            }
        }
        return null;
    }

    public static int indexData(BukuEntity buku) {
        for (int i = 0;i<dataBuku.size();i++){
            if (dataBuku.get(i).getIdKoleksi()==buku.getIdKoleksi()){
                return i;
            }
        }
        return -1;
    }

    public static BukuEntity findBukuByTitle(String judul) {
        for (BukuEntity buku : dataBuku) {
            if (buku.getJudul().contains(judul)){
                return buku;
            }
        }
        return null;
    }

    public static void tambahBuku(BukuEntity buku){
        dataBuku.add(buku);
    }

    public static void updateBuku(BukuEntity buku){
        int indexdataBuku = indexData(buku);
        if (indexdataBuku != -1){
            dataBuku.set(indexdataBuku,buku);
        }
    }

    public static void deleteBuku(BukuEntity buku){
        dataBuku.remove(buku);
    }

    public static ArrayList<BukuEntity> filterBukuByJudul(String judulBuku){
        ArrayList<BukuEntity>_bukuFound = new ArrayList<>();

        for (BukuEntity buku : dataBuku){
            if (buku.getJudul().contains(judulBuku)){

                _bukuFound.add(buku);
            }
        }
        return _bukuFound;
    }

    public static void delete(int index) {
        dataBuku.remove(index);
    }
}
