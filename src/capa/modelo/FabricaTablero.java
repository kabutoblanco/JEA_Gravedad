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
public class FabricaTablero {
    public Tablero crearTablero(int i) {
        if (i == 1)
            return new TableroJEA();
        else if (i == 2)
            return new TableroGravedad();
        return null;
    }
}
