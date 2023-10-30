/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class TableDataSaver {
    public static void saveTableData(JTable table, String filePath) {
        try {
            // Membuat objek BufferedWriter untuk menulis ke file
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath));
            
            // Iterasi baris (i) dan kolom (j) pada JTable
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    // Menulis nilai dari JTable ke dalam file dengan menambahkan tab sebagai pemisah
                    bWriter.write(table.getValueAt(i, j).toString() + "\t");
                }
                // Pindah ke baris baru setelah semua kolom ditulis
                bWriter.newLine();
            }
            
            // Pindah ke baris baru setelah semua kolom ditulis
            bWriter.close();
        } catch (IOException e) {
            // Menangani eksepsi jika terjadi kesalahan saat menulis ke file
            e.printStackTrace(); // Mencetak informasi kesalahan
        }
    }
}