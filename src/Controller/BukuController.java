package Controller;

import Entity.BukuEntity;
import Entity.StaffEntity;
import Model.LibraryModel;

import java.util.ArrayList;

public class BukuController implements InterfaceController{

    public  void lihatData() {
        for (BukuEntity buku : LibraryModel.dataBuku) {

        }
    }
    @Override
    public  BukuEntity findBukuById(int idbuku) {
        for (BukuEntity buku : LibraryModel.dataBuku) {
            if (buku.getIdKoleksi()==(idbuku)){

                return buku;
            }
        }
        return null;
    }

    public  int indexData(BukuEntity buku) {
        for (int i = 0;i<LibraryModel.dataBuku.size();i++){
            if (LibraryModel.dataBuku.get(i).getIdKoleksi()==buku.getIdKoleksi()){
                return i;
            }
        }
        return -1;
    }
    @Override
    public  BukuEntity findBukuByTitle(String judul) {
        for (BukuEntity buku : LibraryModel.dataBuku) {
            if (buku.getJudul().contains(judul)){
                return buku;
            }
        }
        return null;
    }
    @Override
    public  void tambahBuku(BukuEntity buku){
        LibraryModel.dataBuku.add(buku);
    }
    @Override
    public  void updateBuku(BukuEntity buku){
        int indexdataBuku = indexData(buku);
        if (indexdataBuku != -1){
            LibraryModel.dataBuku.set(indexdataBuku,buku);
        }
    }
    public  void deleteBuku(BukuEntity buku){
        LibraryModel.dataBuku.remove(buku);
    }
    public  ArrayList<BukuEntity> filterBukuByJudul(String judulBuku){
        ArrayList<BukuEntity>_bukuFound = new ArrayList<>();

        for (BukuEntity buku : LibraryModel.dataBuku){
            if (buku.getJudul().contains(judulBuku)){

                _bukuFound.add(buku);
            }
        }
        return _bukuFound;
    }
}
