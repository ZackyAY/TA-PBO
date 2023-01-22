package Controller;

import View.BukuPage;
public class HomeController {
    private BukuPage bukuPage;

    public void HomeController(){
        bukuPage = new BukuPage();
        initialPage();
    }
    public void initialPage() {
        int menu = 0;
        do {

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
                break;
        }
    }
}

