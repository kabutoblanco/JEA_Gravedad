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
    public static JFrame _frame = new JFrame("JEA");
    public static TableroGrafico _tablero;
    public static PanelMenu _menu;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        _tablero = new TableroGrafico();
        _menu = new PanelMenu();
        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.add(_tablero, BorderLayout.CENTER);
        _frame.add(_menu, BorderLayout.SOUTH);
        _frame.setDefaultCloseOperation(3);
        _frame.setSize(430, 470);
        _frame.setVisible(true);
    }
    
}
