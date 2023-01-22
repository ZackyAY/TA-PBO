package View;

import Controller.AuthController;
import Model.AuthModel;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends MainFrame {
    //    public void setVisible(boolean b) {
//    }
    private JLabel iconLabel;
    private JLabel titleLabel;

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton masukBtn;

    private AuthController _authC = new AuthController();

    public LoginFrame() {
        super("Duke Humfey's Library", 400, 600);
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/sampul.png", 195, 195);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 103, 30, 195, 195);

        titleLabel = new JLabel("LOGIN");
        setFontSize(titleLabel, 30);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 155, 245, 92, 40);

        usernameLabel = new JLabel("Username");
        setFontSize(usernameLabel, 12);
        setFontStyle(usernameLabel, Font.BOLD);
        boundedAdd(usernameLabel, 172, 305, 56, 16);

        usernameField = new JTextField();
        usernameField.setBackground(color("#FFFFFF"));
        boundedAdd(usernameField, 35, 325, 333, 32);

        passwordLabel = new JLabel("Password");
        setFontSize(passwordLabel, 12);
        setFontStyle(passwordLabel, Font.BOLD);
        boundedAdd(passwordLabel, 172, 375, 55, 16);

        passwordField = new JPasswordField();
        passwordField.setBackground(color("#FFFFFF"));
        boundedAdd(passwordField, 35, 395, 333, 32);

        masukBtn = new JButton("Masuk");
        masukBtn.setBackground(color("#35807B")); // #00D4FF
        masukBtn.setForeground(color("#000000"));
        masukBtn.setFocusPainted(false);
        boundedAdd(masukBtn, 158, 467, 85, 32);
    }

    @Override
    protected void event() {
        masukBtn.addActionListener((e) -> {
            String nik = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean status = _authC.login(nik, password);

            if (AuthModel.login(nik,password)) {
                // View Dashboard / View Home
                new DashboardFrame().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
    }

}
