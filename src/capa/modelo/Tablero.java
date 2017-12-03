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
public abstract class Tablero {
    
    protected int[][] grillas = null;
    protected Caida caida = null;
    public abstract void mantener(Juego juego);
    
    public int[][] getGrillas() {
        return grillas;
    }
    
    public void setGrillas(int[][] grillas) {
        this.grillas = grillas;
    }

    public Caida getCaida() {
        return caida;
    }
    
    public void setCaida(Caida caida) {
        this.caida = caida;
    }
    
}
