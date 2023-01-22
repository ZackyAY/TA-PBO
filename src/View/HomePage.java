package View;

import View.BukuPage;

import java.util.Scanner;


public class HomePage {
    private Scanner input = new Scanner(System.in);
    private BukuPage bukuPage;

    public HomePage(){
        bukuPage = new BukuPage();
        initialPage();
    }
    public void initialPage() {
        System.out.println("===========================");
        System.out.println("----------LIBRARY----------");
        System.out.println("===========================");
        int menu;
        do {
            System.out.printf("""
                    MENU
                    1. LIHAT BUKU
                    2. TAMBAH BUKU
                    3. EDIT BUKU
                    4. HAPUS BUKU
                    5. CARI BUKU BY JUDUL
                    6. CARI BUKU BY ID
                    7. FILTER BUKU BY ABJAD
                    0. KELUAR
                    PILIH:""");
            menu = input.nextInt();
            input.nextLine();

            System.out.println();
            switchMenu(menu);
        } while (menu != 0);
    }

    private void switchMenu (int menu) {
        switch (menu){
            case 1:
                bukuPage.lihatbuku();
                break;
            case 2:
                bukuPage.tambahBuku();
                break;

            case 3:
                bukuPage.editBuku();
                break;

            case 4:
                bukuPage.hapusBuku();
                break;
            case 5:
                bukuPage.findBukuByTitle();
                break;
            case 6:
                bukuPage.findBukuById();
                break;
            case 7:
                bukuPage.filterBukuByAbjad();
                break;

            default:
                System.out.println("Menu Tidak Valid!");
                break;
        }
    }
}

