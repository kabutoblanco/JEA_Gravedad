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
public class CaidaJEA implements Caida {

    @Override
    public int[][] ponerFicha(int[] coordenada, int turno, int[][] grillas) {
        for (int i = grillas.length - 1; i > -1; i--) {
            if (grillas[i][coordenada[0]] == 0) {
                grillas[i][coordenada[0]] = turno;
                break;
            }
        }
        return grillas;
    }
    
}
