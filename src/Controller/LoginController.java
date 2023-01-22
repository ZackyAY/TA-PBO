package Controller;

import Entity.StaffEntity;
import Model.AuthModel;
import Model.LibraryModel;

public class LoginController {
    public boolean loginController(String npm, String password){
        StaffEntity staff = LibraryModel.findStaff(npm);

        if (staff != null){
            if (staff.getPassword().equals(password)){
                AuthModel.staffLogged = staff;
                return true;
            }else {
                AuthModel.staffLogged = null;
            }
        }
        return false;
    }
    public void logout(){
        AuthModel.staffLogged = null;
    }
}

