package View;
import Controller.DashboardController;
import Entity.*;
import Entity.StaffEntity;
import Model.LibraryModel;

import java.awt.Font;
import java.util.ArrayList;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DashboardFrame extends MainFrame {
    private JLabel iconLabel;
    private JLabel titleLabel, subTitleLabel;
    private JButton CariBtn, tambahBtn, editBtn, hapusBtn;
    private JButton refreshBtn;
    private JButton bukuBtn, logoutBtn;

    protected JTable bukuTable;
    private JScrollPane scrollPane;

    private JTextField selectedField = new JTextField();

    private DashboardController _dashboardC = new DashboardController();
    // private AuthController auth = new AuthController();
    private StaffEntity staff;

    public DashboardFrame() {
        super("Dashboard", 800, 600);

        staff = _dashboardC.StaffLogged();
    }

    @Override
    protected void component() {
        ImageIcon imgLoad = loadImage("src/assets/img.png", 55, 55);
        iconLabel = new JLabel(imgLoad);
        boundedAdd(iconLabel, 34, 40, 55, 55);

        titleLabel = new JLabel("WELCOME");
        setFontSize(titleLabel, 15);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 102, 53, 73, 20);

        subTitleLabel = new JLabel(staff.getNamaStaff());
        setFontSize(subTitleLabel, 20);
        setFontStyle(subTitleLabel, Font.BOLD);
        boundedAdd(subTitleLabel, 102, 68, 200, 27);

        bukuBtn = new JButton("Buku");
        bukuBtn.setBackground(color("#CBE725"));
        bukuBtn.setForeground(color("#000000"));
        boundedAdd(bukuBtn, 0, 138, 103, 31);

//        cariStaffBtn = new JButton("Cari Staff");
//        cariStaffBtn.setBackground(color("#115797"));
//        cariStaffBtn.setForeground(color("#FFFFFF"));
//        boundedAdd(cariStaffBtn, 0, 169, 103, 31);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBackground(color("#35807B"));
        refreshBtn.setForeground(color("#000000"));
        refreshBtn.setFocusPainted(false);
        boundedAdd(refreshBtn, 690, 69, 80, 28);

        CariBtn = new JButton("Cari");
        CariBtn.setBackground(color("#35807B"));
        CariBtn.setForeground(color("#000000"));
        CariBtn.setFocusPainted(false);
        boundedAdd(CariBtn, 690, 107, 80, 28);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#35807B"));
        tambahBtn.setForeground(color("#000000"));
        tambahBtn.setFocusPainted(false);
        boundedAdd(tambahBtn, 600, 107, 80, 28);

        editBtn = new JButton("Edit");
        editBtn.setBackground(color("#35807B"));
        editBtn.setForeground(color("#000000"));
        editBtn.setFocusPainted(false);
        boundedAdd(editBtn, 510, 107, 80, 28);

        hapusBtn = new JButton("Hapus");
        hapusBtn.setBackground(color("#FF0000"));
        hapusBtn.setForeground(color("#000000"));
        hapusBtn.setFocusPainted(false);
        boundedAdd(hapusBtn, 420, 107, 80, 28);

        // Tabel
        bukuTable = new JTable();
        TableModel model = createTableModel();
        bukuTable.setModel(model);

        // Scroll Table
        scrollPane = new JScrollPane(bukuTable);
        boundedAdd(scrollPane, 109, 138, 671, 434);

//        logoutBtn = new JButton("?????");
//        logoutBtn.setBackground(color("#E50404"));
//        logoutBtn.setForeground(color("#FFFFFF"));
//        logoutBtn.setFocusPainted(false);
//        boundedAdd(logoutBtn, 14, 532, 76, 18);

        logoutBtn = new JButton("LOGOUT");
        logoutBtn.setBackground(color("#E50404"));
        logoutBtn.setForeground(color("#FFFFFF"));
        logoutBtn.setFocusPainted(false);
        boundedAdd(logoutBtn, 14, 552, 76, 18);
    }

    @Override
    protected void event() {
        bukuTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow();
                String selectedId = bukuTable.getValueAt(i, 0).toString();
                selectedField.setText(selectedId);
            }
        });

        refreshBtn.addActionListener((e) -> {
            bukuTable.setModel(createTableModel());
        });

        tambahBtn.addActionListener((event -> {
            new TambahBukuFrame().setVisible(true);
        }));

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow() + 1;
                BukuEntity buku = LibraryModel.findBukuById(i);
                if (buku != null) {
                    new EditFrame(buku).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih Buku Terlebih Dahulu", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

        });
//         editBtn.addActionListener((event -> {
//         new EditFrame().setVisible(true);
//         }));

        hapusBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = bukuTable.getSelectedRow();
                _dashboardC.delete(i);
                JOptionPane.showMessageDialog(null, "Hapus Buku berhasil", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

//        cariStaffBtn.addActionListener((event -> {
//            new CariStaffFrame().setVisible(true);
//        }));

        logoutBtn.addActionListener((event -> {
            new LogoutFrame().setVisible(true);
            dispose();
        }));
    }

    private TableModel createTableModel() {
        DefaultTableModel dataTable = new DefaultTableModel();

        Object[] column = {
                "ID",
                "Judul Buku",
                "Jumlah hal",
                "Kategori",
                "Tanggal Terbit",
                "Penulis",
                "Penerbit",

        };
        dataTable.setColumnIdentifiers(column);

        ArrayList<BukuEntity> bukuList = _dashboardC.databuku();

        for (BukuEntity buku : bukuList) {

            Object[] data = new String[] {
                    String.valueOf(buku.getIdKoleksi()),
                    buku.getJudul(),
                    String.valueOf(buku.getHalaman()),
                    buku.getKategori(),
                    buku.getTanggalTerbit(),
                    buku.getPenulis().getNama(),
                    buku.getPenerbit().getNama()
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }

}