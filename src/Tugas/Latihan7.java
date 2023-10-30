/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class Latihan7 extends JFrame {
    private boolean checkBoxSelected;  // Properti checkBoxSlected untuk menyimpan nilai apakah checkBox dicentang atau tidak
    
    public Latihan7() {
        this.checkBoxSelected = false; // Mengatur nilai awal checkBoxSelected menjadi false
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Method untuk menutup frame ketika tombol X ditekan
        
        this.addWindowListener(new WindowAdapter() {
         @Override
            public void windowClosing(WindowEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(Latihan7.this,
                        "Apakah Anda yakin ingin menutup aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0); // Menutup aplikasi jika user memilih "Yes"
                }
            }
        });
        
        // Instansiasi objek JLabel untuk Header dengan nama labelNama yang diberikan nilai "Form Biodata:" dan diletakan pada posisi tengah
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        // Mengatur posisi, lebar dan tinggi objek
        labelHeader.setBounds(0, 20, 350, 10);
        
        // Instansiasi objek JLabel dengan nama labelNama untuk inputan Nama
        JLabel labelNama = new JLabel("Nama: ");
        // Mengatur posisi, lebar dan tinggi objek
        labelNama.setBounds(15, 40, 350, 10);

        // Instansiasi objek JTextField dengan nama textFieldNama
        JTextField textFieldNama = new JTextField();
        // Mengatur posisi, lebar dan tinggi objek
        textFieldNama.setBounds(15, 60, 480, 30);

        // Instansiasi objek JLabel dengan nama labelTelepon untuk inputan Nomor Telepon
        JLabel labelTelepon = new JLabel("Nomor Telepon: ");
        // Mengatur posisi, lebar dan tinggi objek
        labelTelepon.setBounds(15, 100, 350, 10);

        // Instansiasi objek JTextField dengan nama textFieldTelepon
        JTextField textFieldTelepon = new JTextField();
        // Mengatur posisi, lebar dan tinggi objek
        textFieldTelepon.setBounds(15, 120, 480, 30);

        // Instansiasi objek JLabel dengan nama labelInput yang diberikan nilai "Jenis Kelamin:"
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        // Mengatur posisi, lebar dan tinggi objek
        labelRadio.setBounds(15, 160, 350, 10);

        // Instansiasi objek JRadioButton dengan nama radioButton1 dengan pesan "Laki-Laki"
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true); //Nilai true berarti dicentang
        // Mengatur posisi, lebar dan tinggi objek
        radioButton1.setBounds(15, 180, 350, 30);

        // Instansiasi objek JRadioButton dengan nama radioButton1 dengan pesan "Perempuan"
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        // Mengatur posisi, lebar dan tinggi objek
        radioButton2.setBounds(15, 220, 350, 30);

        // Instansiasi objek ButtonGroup
        ButtonGroup bg = new ButtonGroup();
        //Menambahkan JRadioButton bernama radioButton1 ke dalam objek
        bg.add(radioButton1);
        //Menambahkan JRadioButton bernama radioButton2 ke dalam objek
        bg.add(radioButton2);
        
        JLabel labelAlamat = new JLabel("Alamat: ");
        // Mengatur posisi, lebar dan tinggi objek
        labelAlamat.setBounds(15, 260, 350, 10);
        
        JTextArea txtAlamat = new JTextArea("");
        txtAlamat.setBounds(15, 280, 480, 100);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton button = new JButton("Simpan");
        // Mengatur posisi, lebar dan tinggi objek
        button.setBounds(15, 400, 100, 40);
        
        // Instansiasi JButton dengan nama button yang diberikan nilai "Edit"
        JButton buttonEdit = new JButton("Edit");
        // Mengatur posisi, lebar dan tinggi objek
        buttonEdit.setBounds(125, 400, 100, 40);
        
        // Instansiasi JButton dengan nama button yang diberikan nilai "Hapus"
        JButton buttonHapus = new JButton("Hapus");
        // Mengatur posisi, lebar dan tinggi objek
        buttonHapus.setBounds(235, 400, 100, 40);
        
        //Instansiasi JButton dengan nama button yang diberikan dengan nilai "Simpan ke file"
        JButton buttonFile = new JButton("Simpan ke File");
        buttonFile.setBounds(345, 400, 150, 40);
        
        // Instansiasi  objek JTable dengan nama table
        JTable table = new JTable();
        // Instansiasi objek JScrollPane dengan nama scrollableTable yang diberikan ke objek table
        JScrollPane scrollableTable = new JScrollPane(table);
        // Mengatur posisi, lebar dan tinggi objek
        scrollableTable.setBounds(15, 450,480,200);
        
        // Instansiasi class LatihanMyTableModel dengan nama tableModel
        MyTableModel tableModel = new MyTableModel();
        // Mengatur model dari table dengan objek tableModel
        table.setModel(tableModel);
        
        // Menambahkan actionListener ke button
        button.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {

                // Variable jenisKelamin untuk menyimpan nilai radioButton "Jenis Kelamin"
                String jenisKelamin = "";

                // Jika radioButton1 diklik
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText(); // Maka jenisKelamin akan bernilai Laki-Laki
                    radioButton1.setSelected(false); //Mengambalikan radioButton ke kondisi semula
                }
                // Jika radioButton2 diklik
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText(); // Maka jenisKelamin akan bernilai Perempuan
                    radioButton2.setSelected(false); //Mengambalikan radioButton ke kondisi semula
                }
                

                // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
                String nama = textFieldNama.getText();
                // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
                String telepon = textFieldTelepon.getText();
                //Variable alamat untuk menyimpan nilai objek txtAlamat
                String alamat = txtAlamat.getText();
                // Mengembalaikan isi textFieldNama ke kondisi semula (kosong)
                textFieldNama.setText("");
                // Mengembalaikan isi textFieldTelepon ke kondisi semula (kosong)
                textFieldTelepon.setText("");
                //Mengembalikan isi txtAlamat ke kondisi semua (kosong)
                txtAlamat.setText("");
                
                if(nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
                    //Menampilkan pesan Warning bahwa "PASTIKAN SEMUA DATA SUDAH TERISI!"
                    JOptionPane.showMessageDialog(Latihan7.this, "PASTIKAN SEMUA DATA SUDAH TERISI!", "Peringatan!",
                    JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    // Jika nama bernilai kosong
                    if (nama.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(Latihan7.this, "Nama tidak boleh kosong!", "Peringatan!",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika telepon bernilai kosong
                    if (telepon.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(Latihan7.this, "Nomor telepon tidak boleh kosong!", "Peringatan!",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    // Jika alamat bernilai kosong
                    if (alamat.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(Latihan7.this, "Alamat tidak boleh kosong!", "Peringatan!",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
                int confirmation = JOptionPane.showConfirmDialog(Latihan7.this,
            "Masukan Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                
                 if (confirmation == JOptionPane.YES_OPTION) {
                    // Tambahkan variable nama, telepon, jenisKelamin, dan alamat ke objek ArrayList dan dikirim lagi ke objek tableModel melalui method add
                    tableModel.add(new ArrayList<>(Arrays.asList(nama, telepon, jenisKelamin, alamat)));
                    //Menampilkan pesan Warning bahwa Data tersimpan
                    JOptionPane.showMessageDialog(Latihan7.this, "Data tersimpan", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                     JOptionPane.showMessageDialog(Latihan7.this, "Data tidak tersimpan", "Peringatan!",
                            JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
        
        
        buttonHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih

            if (selectedRow >= 0) { // Pastikan baris dipilih adalah valid
                int confirmation = JOptionPane.showConfirmDialog(Latihan7.this,
                        "Yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    // Memanggil method remove pada tableModel untuk menghapus baris yang dipilih
                    ((MyTableModel) table.getModel()).remove(selectedRow);
                    //Menampilkan pesan bahwa Data berhasil dihapus
                    JOptionPane.showMessageDialog(Latihan7.this, "Data berhasil dihapus", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                //Menampilkan pesan peringatan "Pilih baris yang akan dihapus!"
                JOptionPane.showMessageDialog(Latihan7.this, "Pilih baris yang akan dihapus!", "Peringatan!",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        buttonEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih

            if (selectedRow >= 0) { // Pastikan baris dipilih adalah valid
                String nama = textFieldNama.getText(); // Mengambil nilai nama dari textFieldNama
                String telepon = textFieldTelepon.getText(); // Mengambil nilai telepon dari textFieldTelepon
                String alamat = txtAlamat.getText(); // Mengambil nilai alamat dari txtAlamat
                
                textFieldNama.setText("");
                // Mengembalaikan isi textFieldTelepon ke kondisi semula (kosong)
                textFieldTelepon.setText("");
                //Mengembalikan isi txtAlamat ke kondisi semua (kosong)
                txtAlamat.setText("");

            if (!nama.isEmpty() && !telepon.isEmpty()) { // Pastikan nama dan telepon tidak kosong
                ArrayList<String> newData = new ArrayList<>(); // Membuat ArrayList baru untuk data yang akan diubah
                newData.add(nama); // Menambahkan nama ke dalam ArrayList newData
                newData.add(telepon); // Menambahkan telepon ke dalam ArrayList newData
                newData.add((radioButton1.isSelected()) ? "Laki-Laki" : "Perempuan"); // Menambahkan jenis kelamin ke dalam ArrayList newData
                newData.add(alamat); // Menambahkan alamat ke dalam ArrayList newData

                // Mengubah data pada baris yang dipilih dengan data baru
                ((MyTableModel) table.getModel()).remove(selectedRow);
                ((MyTableModel) table.getModel()).add(newData);
                
                //Menampilkan pesan informasi Data berhasil diubah
                JOptionPane.showMessageDialog(Latihan7.this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //Menampilkan pesan peringatan ketika Nama dan Nomor Telepon kosong/tidak diisi
                JOptionPane.showMessageDialog(Latihan7.this, "Nama dan Nomor Telepon tidak boleh kosong!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            //Menampilkan pesan peringatan "Pilih baris yang akan diubah!"
            JOptionPane.showMessageDialog(Latihan7.this, "Pilih baris yang akan diubah!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
               }
            }
        });
        
        // Menambahkan ActionListener pada tombol "Simpan ke File"
        buttonFile.addActionListener(new ActionListener() { // Mengatur aksi yang akan dijalankan saat tombol ditekan
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(); // Membuat objek JFileChooser untuk memilih lokasi penyimpanan file
                fileChooser.setDialogTitle("Tentukan directory file yang akan disimpan"); // Mengatur judul dialog (pesan) pemilihan file
                
                // Menampilkan dialog pemilihan lokasi penyimpanan file dan menyimpan responsnya dalam variabel userSelection
                int userSelection = fileChooser.showSaveDialog(Latihan7.this);
                
                // Jika userSelection menunjukkan bahwa lokasi file telah dipilih untuk disimpan
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath(); // Mendapatkan alamat (path) lengkap file yang telah dipilih
                    // Memanggil method saveTableData dari kelas TableDataSaver untuk menyimpan data tabel ke dalam file dengan ekstensi .txt
                    TableDataSaver.saveTableData(table, filePath + ".txt"); 
                    // Menampilkan pesan bahwa data berhasil disimpan ke dalam file
                    JOptionPane.showMessageDialog(Latihan7.this, "Data berhasil disimpan ke file", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        
        
        // Menambahkan objek-objek tersebut ke dalam Frame
        this.add(labelHeader);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelTelepon);
        this.add(textFieldTelepon);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelAlamat);
        this.add(txtAlamat);
        this.add(button);
        this.add(buttonEdit);
        this.add(buttonHapus);
        this.add(buttonFile);
        this.add(scrollableTable);
        
        // Atur ukuran frame menjadi 400 x 600
        this.setSize(600, 800);
        // Atur layout frame menjadi null
        this.setLayout(null);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan7 t = new Latihan7();
                t.setVisible(true);
            }
        });
    }
}