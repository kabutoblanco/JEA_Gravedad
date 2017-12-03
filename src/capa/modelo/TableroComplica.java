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
public final class TableroComplica extends Tablero {

    public TableroComplica() {
        setGrillas(new int[7][4]);
        setCaida(new CaidaComplica());
    }

    @Override
    public void mantener(Juego juego) {
        int[] coordenada = {juego.fila, juego.columna};
        grillas = caida.ponerFicha(coordenada, juego.turno, grillas);
        Controlador.getInstancia().mostrarJugada(grillas);
    }
    
}
