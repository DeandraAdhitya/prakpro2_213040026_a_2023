package Pertemuan2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
import java.awt.event.*;
import javax.swing.*;

public class HelloInput extends JFrame {
    
    public HelloInput(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelInput = new JLabel("Input Nama");
        labelInput.setBounds(130,40,100,10);
        
        JTextField textField = new JTextField();
        textField.setBounds(130,100,100, 40);
        
        JButton button = new JButton("Klik");
        button.setBounds(130,100,100, 40);
        
        JLabel labelOutput = new JLabel("");
        labelOutput.setBounds(130,150,100,10);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nama = textField.getText();
                labelOutput.setText("Hello "+nama);
            }
        });
        
        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(labelOutput);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                HelloInput h = new HelloInput();
                h.setVisible(true);
            }
        });
    }
}
