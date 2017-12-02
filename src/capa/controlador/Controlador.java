/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.controlador;

import capa.modelo.Tablero;
import capa.vista.TableroGrafico;

/**
 *
 * @author daniel
 */
public class Controlador {
    
    private static Controlador instancia;
    private TableroGrafico monitor;

    private Controlador() {
    }

    private Controlador(TableroGrafico monitor) {
        this.monitor = monitor;
    }
    
    public void mostrarJugada(int[][] grillas) {
        monitor.mostrarJugada(grillas);
    }
    
    public static Controlador getInstancia() {
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }
    
    public static Controlador getInstancia(TableroGrafico monitor) {
        if (instancia == null)
            instancia = new Controlador(monitor);
        return instancia;
    }

    public void setMonitor(TableroGrafico monitor) {
        this.monitor = monitor;
    }
    
}
