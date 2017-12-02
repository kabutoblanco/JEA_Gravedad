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
public class Jugando implements Estado {

    @Override
    public boolean verificar() {
        System.out.println("Aun se puede jugar");
        return false;
    }
    
}
