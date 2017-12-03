/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.vista;

import capa.controlador.Controlador;
import capa.modelo.Complica;
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

    public TableroGrafico() {
        matriz = new int[0][0];
        crear();
    }

    public TableroGrafico(int juego) {
        switch (juego) {
            case 1:
                Juego.setInstancia(new JEA());
                break;
            case 2:
                Juego.setInstancia(new Gravedad());
                break;
            case 3:
                Juego.setInstancia(new Complica());
                break;
            default:
                break;
        }
        matriz = Juego.getInstancia().getTablero().getGrillas();
        Juego.getInstancia().iniciar();
        crear();
    }
    
    private void crear() {
        tecla = -1;
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
                    g.fillRect(j * 60, i * 60, 60, 60);
                }
                g.setColor(Color.black);
                g.drawRect(j * 60, i * 60, 60, 60);
            }
        }
    }
    
    public void mostrarJugada(int[][] grillas) {
        matriz = grillas;
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int filas, columnas;
        tecla = e.getKeyChar() - 48;
        switch (Juego.getInstancia().getTablero().getCaida().getClass().getName()) {
            case "capa.modelo.CaidaJEA":
                System.out.println("JEA: " + coordenada[0] + " - " + coordenada[1]);
                columnas = Juego.getInstancia().getTablero().getGrillas()[0].length;
                if (tecla > -1 && tecla < columnas) {
                    if (!Juego.getInstancia().getEstado().verificar()) {
                        coordenada[0] = tecla;
                        Juego.getInstancia().jugar(coordenada);
                        if (Juego.getInstancia().chequearGanador()) {
                            Juego.getInstancia().terminar();
                            JOptionPane.showConfirmDialog(this, "Ganaste", "OJO", JOptionPane.CLOSED_OPTION);
                            JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                        }
                        Juego.getInstancia().getEstado().verificar();
                        Juego.getInstancia().darTurno();
                    }
                    else {
                        JOptionPane.showConfirmDialog(this, "Ya perdiste", "OJO", JOptionPane.CLOSED_OPTION);
                        JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                    }
                }   reiniciar(); 
                break;
            case "capa.modelo.CaidaGravedad":
                System.out.println("Gravedad: " + coordenada[0] + " - " + coordenada[1]);
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
                                Juego.getInstancia().terminar();
                                JOptionPane.showConfirmDialog(this, "Ganaste", "OJO", JOptionPane.CLOSED_OPTION);
                                JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                            }
                            Juego.getInstancia().getEstado().verificar();
                            Juego.getInstancia().darTurno();
                        }
                        else {
                            JOptionPane.showConfirmDialog(this, "Ya perdiste", "OJO", JOptionPane.CLOSED_OPTION);
                            JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                        }
                    }
                    reiniciar();
                }   break;
            case "capa.modelo.CaidaComplica":
                System.out.println("JEA: " + coordenada[0] + " - " + coordenada[1]);
                columnas = Juego.getInstancia().getTablero().getGrillas()[0].length;
                if (tecla > -1 && tecla < columnas) {
                    if (!Juego.getInstancia().getEstado().verificar()) {
                        coordenada[0] = tecla;
                        Juego.getInstancia().jugar(coordenada);
                        if (Juego.getInstancia().chequearGanador()) {
                            Juego.getInstancia().terminar();
                            JOptionPane.showConfirmDialog(this, "Ganaste", "OJO", JOptionPane.CLOSED_OPTION);
                            JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                        }
                        Juego.getInstancia().getEstado().verificar();
                        Juego.getInstancia().darTurno();
                    }
                    else {
                        JOptionPane.showConfirmDialog(this, "Ya perdiste", "OJO", JOptionPane.CLOSED_OPTION);
                        JEA_Gravedad._menu.getButonJugar().setEnabled(true);
                    }
                }   reiniciar(); 
                break;
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public void reiniciar() {
        coordenada[0] = -1; coordenada[1] = -1;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
}
