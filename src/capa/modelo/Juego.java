/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.modelo;

/**
 *
 * @author daniel
 */
public abstract class Juego {
    
    protected int turno = 0;
    protected int fila = 0;
    protected int columna = 0;
    protected static Juego instancia = null;
    protected Tablero tablero = null;
    protected Estado estado = null;
    
    public abstract void iniciar();
    public abstract void terminar();
    public abstract void jugar(int[] coordenada);
    public abstract void darTurno();
    public abstract boolean chequearGanador();
    public abstract void notificar();
    
    public static Juego getInstancia() {
        return instancia;
    }
    
    public static void setInstancia(Juego juego) {
        instancia = juego;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
