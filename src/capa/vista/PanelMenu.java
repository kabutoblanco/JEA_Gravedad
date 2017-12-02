/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.vista;

import capa.controlador.Controlador;
import capa.modelo.CaidaGravedad;
import capa.modelo.CaidaJEA;
import capa.modelo.Juego;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class PanelMenu extends javax.swing.JPanel {

    /**
     * Creates new form PanelMenu
     */
    public PanelMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoJuego = new javax.swing.ButtonGroup();
        butonJugar = new javax.swing.JButton();
        radioJEA = new javax.swing.JRadioButton();
        radioGravedad = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        butonJugar.setText("Jugar");
        butonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonJugarActionPerformed(evt);
            }
        });

        grupoJuego.add(radioJEA);
        radioJEA.setText("Normal");
        radioJEA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioJEAMouseClicked(evt);
            }
        });

        grupoJuego.add(radioGravedad);
        radioGravedad.setText("Gravedad");
        radioGravedad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioGravedadMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioJEA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioGravedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butonJugar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonJugar)
                    .addComponent(radioJEA)
                    .addComponent(radioGravedad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butonJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonJugarActionPerformed
        // TODO add your handling code here:
        JEA_Gravedad._tablero.setFocusable(true);
        butonJugar.setFocusable(false);
        try {
            if (grupoJuego.getSelection().equals(radioJEA.getModel())) {
                JEA_Gravedad._tablero = new TableroGrafico(1);
                butonJugar.setEnabled(false);
            }
            else {
                JEA_Gravedad._tablero = new TableroGrafico(2);
                butonJugar.setEnabled(false);
            }
            Controlador.getInstancia().mostrarJugada(Juego.getInstancia().getTablero().getGrillas());
        }
        catch (NullPointerException ex) {
            JOptionPane.showConfirmDialog(this, "Selecciona un juego", "OJO", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_butonJugarActionPerformed

    private void radioJEAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioJEAMouseClicked
        // TODO add your handling code here:
        JEA_Gravedad._frame.setTitle("JEA - Normal");
        if (JEA_Gravedad._tablero.getMatriz().length != 0) {
            JEA_Gravedad._tablero.reiniciar();
            Juego.getInstancia().getTablero().setCaida(new CaidaJEA());
            JEA_Gravedad._tablero.setFocusable(true);
            radioJEA.setFocusable(false);
            radioGravedad.setFocusable(false);
        }
    }//GEN-LAST:event_radioJEAMouseClicked

    private void radioGravedadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioGravedadMouseClicked
        // TODO add your handling code here:
        JEA_Gravedad._frame.setTitle("JEA - Gravedad");
        if (JEA_Gravedad._tablero.getMatriz().length != 0) {
            JEA_Gravedad._tablero.reiniciar();
            Juego.getInstancia().getTablero().setCaida(new CaidaGravedad());
            JEA_Gravedad._tablero.setFocusable(true);
            radioJEA.setFocusable(false);
            radioGravedad.setFocusable(false);
        }
    }//GEN-LAST:event_radioGravedadMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonJugar;
    private javax.swing.ButtonGroup grupoJuego;
    private javax.swing.JRadioButton radioGravedad;
    private javax.swing.JRadioButton radioJEA;
    // End of variables declaration//GEN-END:variables

    public JButton getButonJugar() {
        return butonJugar;
    }
    
}
