/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class JEA_Gravedad {
    public static TableroGrafico _tablero;
    public static PanelMenu _menu;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        _tablero = new TableroGrafico(1);
        _menu = new PanelMenu();
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.add(_tablero, BorderLayout.CENTER);
        frame.add(_menu, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(3);
        frame.setSize(430, 470);
        frame.setVisible(true);
    }
    
}
