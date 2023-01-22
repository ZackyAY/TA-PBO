package View;

import Model.AuthModel;

import java.util.Scanner;
public class LoginPage {
    private Scanner input = new Scanner(System.in);
    public LoginPage(){
        if (true){
            login();
        }
    }
    public void login(){
        String npm,password;

        System.out.println("---------------------------------");
        System.out.println("----------LOGIN STAFF------------");
        System.out.println("---------------------------------");
        System.out.println();
        System.out.print("NPM       :");
        npm = input.nextLine();
        System.out.print("Password  :");
        password = input.nextLine();
        System.out.println("---------------------------------");

        if (AuthModel.login(npm,password)){
            new HomePage();
            System.out.println("Berhasil Login");
        }else {
            loginGagal();
            login();
        }
    }
    void loginGagal(){
        System.out.println("---------------------------------");
        System.out.println("----------LOGIN GAGAL------------");
        System.out.println("     NPM atau Password SALAH!    ");
        System.out.println("---------------------------------");
    }
}

