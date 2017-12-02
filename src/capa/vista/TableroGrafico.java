/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.vista;

import capa.controlador.Controlador;
import capa.modelo.Ganado;
import capa.modelo.Gravedad;
import capa.modelo.JEA;
import capa.modelo.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author daniel
 */
public class TableroGrafico extends JPanel implements KeyListener {
    private int[][] matriz;
    private int tecla;
    private final int[] coordenada = {-1, -1};

    public TableroGrafico(int juego) {
        tecla = -1;
        if (juego == 1)
            Juego.setInstancia(new JEA());
        else if (juego == 2)
            Juego.setInstancia(new Gravedad());
        matriz = Juego.getInstancia().getTablero().getGrillas();
        Juego.getInstancia().iniciar();
        crear();
    }
    
    private void crear() {
        Controlador.getInstancia(this);
        addKeyListener(this);
        setFocusable(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    if (matriz[i][j] == 1)
                        g.setColor(Color.red);
                    else if (matriz[i][j] == 2)
                        g.setColor(Color.blue);
                    g.fillOval(j * 60, i * 60, 60, 60);
                }
                g.setColor(Color.black);
                g.drawOval(j * 60, i * 60, 60, 60);
            }
        }
    }
    
    public void mostrarJugada(int[][] grillas) {
        matriz = grillas;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int filas, columnas;
        tecla = e.getKeyChar() - 48;
        if (Juego.getInstancia().getClass().getName().equals("capa.modelo.JEA")) {
            columnas = Juego.getInstancia().getTablero().getGrillas()[0].length;
            if (tecla > -1 && tecla < columnas) {
                if (!Juego.getInstancia().getEstado().verificar()) {
                    coordenada[0] = tecla;
                    Juego.getInstancia().jugar(coordenada);
                    if (Juego.getInstancia().chequearGanador()) {
                        Juego.getInstancia().setEstado(new Ganado());
                        JOptionPane.showConfirmDialog(this, "Ganaste", "OJO", JOptionPane.CLOSED_OPTION);
                    }
                    Juego.getInstancia().getEstado().verificar();
                    Juego.getInstancia().darTurno();
                }
                else {
                    JOptionPane.showConfirmDialog(this, "Ya perdiste", "OJO", JOptionPane.CLOSED_OPTION);
                    JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                }
            }
        }
        else if (Juego.getInstancia().getClass().getName().equals("capa.modelo.Gravedad")) {
            if (coordenada[0] == -1)
                coordenada[0] = tecla;
            else {
                filas = Juego.getInstancia().getTablero().getGrillas().length;
                columnas = Juego.getInstancia().getTablero().getGrillas()[0].length;
                coordenada[1] = tecla;
                if (coordenada[0] > -1 && coordenada[0] < filas && coordenada[1] > -1 && coordenada[1] < columnas) {
                    if (!Juego.getInstancia().getEstado().verificar()) {
                        Juego.getInstancia().jugar(coordenada);
                        if (Juego.getInstancia().chequearGanador()) {
                            Juego.getInstancia().setEstado(new Ganado());
                            JOptionPane.showConfirmDialog(this, "Ganaste", "OJO", JOptionPane.CLOSED_OPTION);
                        }
                        Juego.getInstancia().getEstado().verificar();
                        Juego.getInstancia().darTurno();
                    }
                    else {
                        JOptionPane.showConfirmDialog(this, "Ya perdiste", "OJO", JOptionPane.CLOSED_OPTION);
                        JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                    }
                }
                coordenada[0] = -1; coordenada[1] = -1;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
