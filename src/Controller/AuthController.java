package Controller;

import Model.AuthModel;
import Model.LibraryModel;
import Entity.StaffEntity;
import View.LoginFrame;


public class AuthController {

    public void toViewLogin() {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    public boolean login(String nik, String password) {
        StaffEntity staff = LibraryModel.findStaff(nik);

        if (staff != null){
            if (staff.getPassword().equals(password)) {
                AuthModel.staffLogged = staff;
                return true;
            } else {
                AuthModel.staffLogged = null;
            }
        }
        return false;
    }
}
