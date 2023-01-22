package Model;

import Entity.StaffEntity;
import Model.*;

public class AuthModel {
    public static StaffEntity staffLogged = null;

    public static void initialStaff(){
        StaffEntity staff1 = new StaffEntity("Zacky","07409","70262413");
        StaffEntity staff2 = new StaffEntity("Mimma","07410","27012006");

        LibraryModel.staffAktif.add(staff1);
        LibraryModel.staffAktif.add(staff2);
    }
    public static boolean login(String npm, String password){
        StaffEntity staff = LibraryModel.findStaff(npm);

        if (staff != null){
            if (staff.getPassword().equals(password)){
                staffLogged = staff;
                return true;
            }else {
                staffLogged = null;
            }
        }
        return false;
    }

    public static StaffEntity getStaffLogged() {
        return staffLogged;
    }

    public static void setUserLogged(StaffEntity staffLogged) {
        StaffEntity.staffLogged = staffLogged;
    }
    public static void logout(){
        staffLogged = null;
    }
}
