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
public class Ganado implements Estado {
    
    @Override
    public boolean verificar() {
        System.out.println("Ya hay ganador");
        return true;
    }
    
}
