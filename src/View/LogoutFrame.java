package View;

import java.awt.Font;
import javax.swing.*;

;

public class LogoutFrame extends MainFrame{
    private JLabel titleLabel;
    private JLabel captionLabel;
    private JButton yakinBtn, batalBtn;

    public LogoutFrame() {
        super("LOGOUT", 400, 200);
    }

    @Override
    protected void component() {
        titleLabel = new JLabel("LOGOUT");
        setFontSize(titleLabel, 24);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 148, 25, 103, 29);

        captionLabel = new JLabel("YAKIN INGIN LOGOUT?");
        setFontSize(captionLabel, 13);
        setFontStyle(captionLabel, Font.BOLD);
        boundedAdd(captionLabel, 127, 84, 146, 16);

        yakinBtn = new JButton("YAKIN");
        yakinBtn.setBackground(color("#FF4040"));
        yakinBtn.setForeground(color("#FFFFFF"));
        boundedAdd(yakinBtn, 314, 151, 70, 30);

        batalBtn = new JButton("BATAL");
        batalBtn.setBackground(color("#5BFF40"));
        batalBtn.setForeground(color("#FFFFFF"));
        boundedAdd(batalBtn, 225, 151, 70, 30);

    }

    @Override
    protected void event() {
        yakinBtn.addActionListener((event -> {
            new LoginFrame().setVisible(true);
            dispose();
        }));
        batalBtn.addActionListener((event -> {
            new DashboardFrame().setVisible(true);
            dispose();

        }));
    }
}
