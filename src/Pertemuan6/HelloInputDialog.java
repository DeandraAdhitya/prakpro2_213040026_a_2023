/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class HelloInputDialog extends JFrame {
    
     public HelloInputDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JButton button = new JButton("Input");
        button.setBounds(130,100,100,40);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = JOptionPane.showInputDialog(HelloInputDialog.this,
                "Input nama anda :");
                JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello, "+nama);
                }
        });
        
        this.add(button);
        this.setSize(200,200);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloInputDialog h = new HelloInputDialog();
                h.setVisible(true);
            }
        });
    }
}

