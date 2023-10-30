/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;
import Tugas.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
class MyTableModel extends AbstractTableModel {  // Membuat class MyTableModel
    private String[] columnNames = {"Nama", "Nomor Telepon", "Jenis Kelamin", "Alamat"}; // Array columnNames untuk menyimpan nama-nama kolom
    
    //Membuat ArrayList dengan data nama yang berisi ArrayList bertipe String
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    @Override
    public int getRowCount() { // Fungsi untuk menambah/menghitung jumlah baris
        return data.size(); // Mengembalikan jumlah data yang diterima dari ArrayList data
    }

    @Override
    public int getColumnCount() { // Fungsi untuk menambah/menghitung jumlah kolom
        return columnNames.length; // Mengembalikan panjang/ukuran dari array columnNames
    }
    
    public String getColumnName(int col) { // Fungsi untuk mendapatkan nama dari kolom yang dipilih
        return columnNames[col]; // Mengembalikan elemen columnNames dengan index col
    }

    @Override
    public Object getValueAt(int row, int col) { // Fungsi untuk mendapatkan nilai dari baris atau kolom
        List<String> rowItem = data.get(row); // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        return rowItem.get(col); // Mengembalikan elemen rowItem dari index col
    }
    
    public boolean isCellEditable(int row, int col) { // Fungsi untuk mengatur apakah cell bisa diedit atau tidak
        return false; // Mengembalikan nilai false
    }
    
    public void remove(int row) {
        // Menghapus elemen dari ArrayList data dengan index row
        data.remove(row);
        // Memanggil fungsi fireTableRowsDeleted untuk menghapus nilai dari baris dan
        // kolom
        fireTableRowsDeleted(row, row);
    }
    
    public void edit(int row, ArrayList<String> newData) {
        if (row >= 0 && row < data.size()) {
            data.set(row, newData); // Mengubah data pada baris yang dipilih dengan data baru
            fireTableRowsUpdated(row, row); // Memperbarui tabel setelah pengubahan data
        }
    }
    
    public void add(ArrayList<String> value) { // Method untuk menambah nilai ke table
        data.add(value);  // Menambahkan input user ke ArrayList data
        fireTableRowsInserted(data.size() -1, data.size() -1); // Menambahkan elemen-elemen ArrayList data ke table
    }
}