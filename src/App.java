import Model.AuthModel;
import View.DashboardFrame;
import View.LoginFrame;
import View.LoginPage;

public class App {
    public static void main(String[] args) {
        AuthModel.initialStaff();
//        new LoginPage();
        new LoginFrame().setVisible(true);

//        new  DashboardFrame().setVisible(true);
    }
}