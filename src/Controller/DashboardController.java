package Controller;

import Entity.BukuEntity;
import Entity.StaffEntity;
import Model.AuthModel;
import Model.LibraryModel;

import java.util.ArrayList;

public class DashboardController {
    public void toView() {

    }
    public StaffEntity StaffLogged() {
        return AuthModel.getStaffLogged();
    }
    public ArrayList<BukuEntity> databuku(){
        return LibraryModel.dataBuku;
    }

    public void delete(int index) {
        LibraryModel.delete(index);
    }

}
