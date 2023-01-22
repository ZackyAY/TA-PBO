package Controller;

import Entity.BukuEntity;

public interface InterfaceController {
    public Object findBukuById(int idbuku);

    public Object findBukuByTitle(String judul);

    public void tambahBuku(BukuEntity buku);

    public void updateBuku(BukuEntity buku);

}
