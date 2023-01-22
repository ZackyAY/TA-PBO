package View;
import java.awt.Font;
import javax.swing.*;

import Entity.*;
import Model.LibraryModel;
public class TambahBukuFrame extends MainFrame{
    private JLabel titleLabel;
    private JLabel namaBukuLabel;
    private JLabel halamanBukuLabel;
    private JLabel genreBukuLabel;
    private JLabel tanggalTerbitLabel;
    private JLabel penulisLabel;
    private JLabel namaPenulisLabel, namaPenerbitLabel;
    private JTextField namaPenulisField, namaPenerbitField;
    private JLabel penerbitLabel, yLabel1, yLabel2, tLabel1, tLabel2;
    private JTextField namaBukuField, halamanField, genreField, tanggalField;
    private JRadioButton yaButton1, yaButton2, tidakButton1, tidakButton2;
    private JButton tambahBtn, batalBtn;
    private ButtonGroup G1, G2;

    public TambahBukuFrame() {
        super("Tambah Buku", 400, 600);
    }

    @Override
    protected void component() {

        titleLabel = new JLabel("TAMBAH BUKU");
        setFontSize(titleLabel, 32);
        setFontStyle(titleLabel, Font.BOLD);
        boundedAdd(titleLabel, 80, 19, 239, 59);

        namaBukuLabel = new JLabel("Judul Buku");
        setFontSize(namaBukuLabel, 15);
        setFontStyle(namaBukuLabel, Font.BOLD);
        boundedAdd(namaBukuLabel, 34, 79, 82, 18);

        namaBukuField = new JTextField();
        boundedAdd(namaBukuField, 34, 105, 333, 24);

        halamanBukuLabel = new JLabel("Jumlah Halaman");
        setFontSize(halamanBukuLabel, 15);
        setFontStyle(halamanBukuLabel, Font.BOLD);
        boundedAdd(halamanBukuLabel, 34, 135, 163, 18);

        halamanField = new JTextField();
        boundedAdd(halamanField, 34, 161, 333, 24);

        genreBukuLabel = new JLabel("Genre");
        setFontSize(genreBukuLabel, 15);
        setFontStyle(genreBukuLabel, Font.BOLD);
        boundedAdd(genreBukuLabel, 34, 191, 86, 18);

        genreField = new JTextField();
        boundedAdd(genreField, 34, 217, 333, 24);

        tanggalTerbitLabel = new JLabel("Tanggal");
        setFontSize(tanggalTerbitLabel, 15);
        setFontStyle(tanggalTerbitLabel, Font.BOLD);
        boundedAdd(tanggalTerbitLabel, 34, 247, 106, 18);

        tanggalField = new JTextField();
        boundedAdd(tanggalField, 34, 273, 333, 24);

        penulisLabel = new JLabel("Penulis");
        setFontSize(penulisLabel, 15);
        setFontStyle(penulisLabel, Font.BOLD);
        boundedAdd(penulisLabel, 34, 304, 54, 18);

        yaButton1 = new JRadioButton();
        boundedAdd(yaButton1, 32, 331, 9, 9);

        yLabel1 = new JLabel("Ya");
        setFontSize(yLabel1, 10);
        setFontStyle(yLabel1, Font.BOLD);
        boundedAdd(yLabel1, 46, 330, 12, 12);

        tidakButton1 = new JRadioButton();
        boundedAdd(tidakButton1, 77, 331, 9, 9);

        tLabel1 = new JLabel("Tidak");
        setFontSize(tLabel1, 10);
        setFontStyle(tLabel1, Font.BOLD);
        boundedAdd(tLabel1, 92, 331, 28, 12);

        G1 = new ButtonGroup();
        G1.add(yaButton1);
        G1.add(tidakButton1);

        namaPenulisLabel = new JLabel("Nama Penulis :");
        setFontSize(namaPenulisLabel, 10);
        setFontStyle(namaPenulisLabel, Font.BOLD);
        boundedAdd(namaPenulisLabel, 37, 354, 72, 12);

        namaPenulisField = new JTextField();
        boundedAdd(namaPenulisField, 114, 349, 248, 24);

        penerbitLabel = new JLabel("Penerbit");
        setFontSize(penerbitLabel, 15);
        setFontStyle(penerbitLabel, Font.BOLD);
        boundedAdd(penerbitLabel, 33, 423, 63, 18);

        yaButton2 = new JRadioButton();
        boundedAdd(yaButton2, 36, 451, 9, 9);

        yLabel2 = new JLabel("Ya");
        setFontSize(yLabel2, 10);
        setFontStyle(yLabel2, Font.BOLD);
        boundedAdd(yLabel2, 52, 450, 12, 12);

        tidakButton2 = new JRadioButton();
        boundedAdd(tidakButton2, 81, 451, 9, 9);

        tLabel2 = new JLabel("Tidak");
        setFontSize(tLabel2, 10);
        setFontStyle(tLabel2, Font.BOLD);
        boundedAdd(tLabel2, 96, 450, 28, 12);

        G2 = new ButtonGroup();
        G2.add(yaButton2);
        G2.add(tidakButton2);

        namaPenerbitLabel = new JLabel("Nama Penerbit :");
        setFontSize(namaPenerbitLabel, 10);
        setFontStyle(namaPenerbitLabel, Font.BOLD);
        boundedAdd(namaPenerbitLabel, 37, 467, 78, 12);

        namaPenerbitField = new JTextField();
        boundedAdd(namaPenerbitField, 119, 461, 248, 24);

        tambahBtn = new JButton("Tambah");
        tambahBtn.setBackground(color("#5BFF40"));
        tambahBtn.setForeground(color("#000000"));
        boundedAdd(tambahBtn, 292, 540, 74, 30);

        batalBtn = new JButton("Batal");
        batalBtn.setBackground(color("#FF4040"));
        batalBtn.setForeground(color("#000000"));
        boundedAdd(batalBtn, 196, 540, 74, 30);

    }

    PenulisEntity penulis;
    PenerbitEntity penerbit;

    @Override
    protected void event() {

        yaButton1.addActionListener((event -> {
            namaPenulisField.setEditable(true);
        }));

        tidakButton1.addActionListener((event -> {
            namaPenulisField.setEditable(false);
        }));

        yaButton2.addActionListener((event -> {
            namaPenerbitField.setEditable(true);
        }));

        tidakButton2.addActionListener((event -> {
            namaPenerbitField.setEditable(false);
        }));

        tambahBtn.addActionListener((event -> {
            String judulBuku = namaBukuField.getText();
            int halamanBuku = Integer.parseInt(halamanField.getText());
            String kategori = genreField.getText();
            String tanggalTerbit = tanggalField.getText();
            if (yaButton1.isSelected()) {
                // namaPenulisField.setEditable(true);
                penulis = new PenulisEntity(namaPenulisField.getText());
            } else if (tidakButton1.isSelected()) {
                String namaPenulis = " - ";
                // namaPenulisField.setEditable(false);
                penulis = new PenulisEntity(namaPenulis);
            }

            if (yaButton2.isSelected()) {
                // namaPenerbitField.setEditable(true);
                penerbit = new PenerbitEntity(namaPenerbitField.getText());
            } else if (tidakButton2.isSelected()) {
                String namaPenerbit = " - ";
                // namaPenulisField.setEditable(false);
                penerbit = new PenerbitEntity(namaPenerbit);
            }
            BukuEntity bukuBaru = new BukuEntity(judulBuku, halamanBuku,kategori, tanggalTerbit, penulis, penerbit,
                    true);
            LibraryModel.tambahBuku(bukuBaru);

            JOptionPane.showMessageDialog(null,
                    "Tambah Buku Berhasil");

            dispose();
        }));

        batalBtn.addActionListener((event -> {
            dispose();
        }));

    }

}
