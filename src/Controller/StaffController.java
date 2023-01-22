package Controller;

import Entity.StaffEntity;
import Model.LibraryModel;

public class StaffController {
    public StaffEntity findStaff(String npm) {
        for (StaffEntity staff : LibraryModel.staffAktif) {
            if (staff.getNpm().equals(npm)) {
                return staff;
            }
        }
        return null;
    }
}
