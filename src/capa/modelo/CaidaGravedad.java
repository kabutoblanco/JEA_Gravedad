/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa.modelo;

import static capa.modelo.Juego.getInstancia;

/**
 *
 * @author daniel
 */
public class CaidaGravedad implements Caida {

    @Override
    public int[][] ponerFicha(int[] coordenada, int turno, int[][] grillas) {
        if (grillas[coordenada[0]][coordenada[1]] == 0) {
            grillas[coordenada[0]][coordenada[1]] = turno;
            int cont; boolean ficha;
            int filas = getInstancia().tablero.getGrillas().length;
            int columnas = getInstancia().tablero.getGrillas()[0].length;
            int x1 = coordenada[1];
            int x2 = grillas[0].length - x1 - 1;
            int y1 = coordenada[0];
            int y2 = grillas.length - y1 - 1;
            System.out.println("x1: " + x1);
            System.out.println("y1: " + y1);
            System.out.println("x2: " + x2);
            System.out.println("y2: " + y2);
            boolean izq = false, der = false, hor = false, arr = false, aba = false, ver = false;
            if (x1 - x2 < x2 - x1)
                izq = true;
            if (x1 - x2 > x2 - x1)
                der = true;
            if (x1 - x2 == x2 - x1)
                hor = true;
            if (y1 - y2 < y2 - y1)
                arr = true;
            if (y1 - y2 > y2 - y1)
                aba = true;
            if (y1 - y2 == y2 - y1)
                ver = true;
            System.out.println("Izq: " + Boolean.toString(izq));
            System.out.println("Der: " + Boolean.toString(der));
            System.out.println("Hor: " + Boolean.toString(hor));
            System.out.println("Arr: " + Boolean.toString(arr));
            System.out.println("Aba: " + Boolean.toString(aba));
            System.out.println("Ver: " + Boolean.toString(ver));
            if (arr && izq && Math.abs(x1) == Math.abs(y1)) {
                System.out.println("diagonal arr izq");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i > -1 && j > -1; i--, j--, cont++) {
                    if (i - 1 > -1 && j - 1 > -1) {
                        if (grillas[i - 1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i + 1][j + 1] = 0;
                    if (grillas[i][j] == 0 && ficha || i == 0 || j == 0)
                        grillas[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (arr && der && Math.abs(x2) == Math.abs(y1)) {
                System.out.println("diagonal arr der");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i > -1 && j < columnas; i--, j++, cont++) {
                    if (i - 1 > -1 && j + 1 < columnas) {
                        if (grillas[i - 1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i + 1][j - 1] = 0;
                    if (grillas[i][j] == 0 && ficha || i == 0 || j == columnas - 1)
                        grillas[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (aba && izq && Math.abs(x1) == Math.abs(y2)) {
                System.out.println("diagonal abj izq");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i < filas && j > -1; i++, j--, cont++) {
                    if (i + 1 < filas && j - 1 > -1) {
                        if (grillas[i + 1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i - 1][j + 1] = 0;
                    if (grillas[i][j] == 0 || i == filas - 1 || j == 0)
                        grillas[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (aba && der && Math.abs(x2) == Math.abs(y2)) {
                System.out.println("diagonal abj der");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i < filas && j < columnas; i++, j++, cont++) {
                    if (i + 1 < filas && j + 1 < columnas) {
                        if (grillas[i + 1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i - 1][j - 1] = 0;
                    if (grillas[i][j] == 0 || i == filas - 1 || j == columnas - 1)
                        grillas[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (hor && arr) {
                System.out.println("arr");
                cont = 0; ficha = false;
                for (int i = y1; i > -1; i--, cont++) {
                    if (i - 1 > -1) {
                        if (grillas[i - 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i + 1][x1] = 0;
                    if (grillas[i][x1] == 0 || i == 0)
                        grillas[i][x1] = turno;
                    if (ficha) break;
                }
            }
            else if (hor && aba) {
                System.out.println("aba");
                cont = 0; ficha = false;
                for (int i = y1; i < filas; i++, cont++) {
                    if (i + 1 < filas) {
                        if (grillas[i + 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i - 1][x1] = 0;
                    if (grillas[i][x1] == 0 || i == filas - 1)
                        grillas[i][x1] = turno;
                    if (ficha) break;
                }
            }
            else if (ver && izq) {
                System.out.println("izq");
                cont = 0; ficha = false;
                for (int j = x1; j > -1; j--, cont++) {
                    if (j - 1 > -1) {
                        if (grillas[y1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[y1][j + 1] = 0;
                    if (grillas[y1][j] == 0 || j == 0)
                        grillas[y1][j] = turno;
                    if (ficha) break;
                }
            }
            else if (ver && der) {
                cont = 0; ficha = false;
                for (int j = x1; j < columnas; j++, cont++) {
                    if (j + 1 < columnas) {
                        if (grillas[y1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[y1][j - 1] = 0;
                    if (grillas[y1][j] == 0 || j == columnas - 1)
                        grillas[y1][j] = turno;
                    if (ficha) break;
                }
            }
            else if (y1 > x1 && x2 > y2) {
                System.out.println("izq");
                cont = 0; ficha = false;
                for (int j = x1; j > -1; j--, cont++) {
                    if (j - 1 > -1) {
                        if (grillas[y1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[y1][j + 1] = 0;
                    if (grillas[y1][j] == 0 || j == 0)
                        grillas[y1][j] = turno;
                    if (ficha) break;
                }
                
            }
            else if (x1 > y1 && y2 > x2 && !arr) {
                System.out.println("der");
                cont = 0; ficha = false;
                for (int j = x1; j < columnas; j++, cont++) {
                    if (j + 1 < columnas) {
                        if (grillas[y1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[y1][j - 1] = 0;
                    if (grillas[y1][j] == 0 || j == columnas - 1)
                        grillas[y1][j] = turno;
                    if (ficha) break;
                }
            }
            else if (x1 > y2 && x2 > y2) {
                System.out.println("aba");
                cont = 0; ficha = false;
                for (int i = y1; i < filas; i++, cont++) {
                    if (i + 1 < filas) {
                        if (grillas[i + 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i - 1][x1] = 0;
                    if (grillas[i][x1] == 0 || i == filas - 1)
                        grillas[i][x1] = turno;
                    if (ficha) break;
                }
            }
            else if (x2 > x1 && y2 > y1) {
                System.out.println("arr");
                cont = 0; ficha = false;
                for (int i = y1; i > -1; i--, cont++) {
                    if (i - 1 > -1) {
                        if (grillas[i - 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grillas[i + 1][x1] = 0;
                    if (grillas[i][x1] == 0 || i == 0)
                        grillas[i][x1] = turno;
                    if (ficha) break;
                }
            }
        }
        return grillas;
    }
    
}
