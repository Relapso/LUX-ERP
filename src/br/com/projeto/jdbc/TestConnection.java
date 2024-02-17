/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Surfi
 */
public class TestConnection {
    public static void main(String[] args) {
        
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
                
        } catch (HeadlessException error) {
            
            JOptionPane.showMessageDialog(null, "Ops aconteceu o erro:" + error);
        }
    }
}
