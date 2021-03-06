/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.modelo;

import capa.controlador.Controlador;

/**
 *
 * @author daniel
 */
public final class TableroJEA extends Tablero {

    public TableroJEA() {
        setGrillas(new int[6][7]);
        setCaida(new CaidaJEA());
    }
    
    @Override
    public void mantener(Juego juego) {
        int[] coordenada = {juego.fila, juego.columna};
        grillas = caida.ponerFicha(coordenada, juego.turno, grillas);
        Controlador.getInstancia().mostrarJugada(grillas);
    }
    
}
