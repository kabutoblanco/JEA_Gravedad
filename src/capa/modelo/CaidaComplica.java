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
public class CaidaComplica implements Caida {

    @Override
    public int[][] ponerFicha(int[] coordenada, int turno, int[][] grillas) {
        System.err.println(coordenada[0] + " - " + coordenada[1]);
        for (int i = grillas.length - 1; i > -1; i--) {
            if (grillas[i][coordenada[0]] == 0) {
                grillas[i][coordenada[0]] = turno;
                break;
            }
            else if (i == 0 && grillas[i][coordenada[0]] != 0) {
                System.out.println("tope");
                for (int j = grillas.length - 1; j > 0; j--)
                    grillas[j][coordenada[0]] = grillas[j - 1][coordenada[0]];
                grillas[i][coordenada[0]] = turno;
                return grillas;
            }
        }
        return grillas;
    }
    
}
