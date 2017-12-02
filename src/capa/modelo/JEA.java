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
public final class JEA extends Juego {

    public JEA() {
        turno = 1;
        FabricaTablero fabricante = new FabricaTablero();
        setTablero(fabricante.crearTablero(1));
    }

    @Override
    public void iniciar() {
        setEstado(new Jugando());
    }

    @Override
    public void terminar() {
        setEstado(new Ganado());
    }
    
    @Override
    public void jugar(int[] coordenada) {
        fila = coordenada[0];
        columna = coordenada[1];
        notificar();
    }

    @Override
    public void darTurno() {
        if (turno == 1)
            setTurno(2);
        else if (turno == 2)
            setTurno(1);
    }

    @Override
    public boolean chequearGanador() {
        int cont;
        int filas = getInstancia().tablero.getGrillas().length;
        int columnas = getInstancia().tablero.getGrillas()[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cont = 0;
                for (int k = i, l = j; k < filas && l < columnas; k++, l++) {
                    if (tablero.grillas[k][l] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k > -1 && l < columnas; k--, l++) {
                    if (tablero.grillas[k][l] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k > -1 && l > - 1; k--, l--) {    
                    if (tablero.grillas[k][l] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k < filas && l > -1; k++, l--) {
                    if (tablero.grillas[k][l] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = j; k < columnas; k++) {
                    if (tablero.grillas[i][k] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = j; k > -1; k--) {
                    if (tablero.grillas[i][k] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = i; k < filas; k++) {
                    if (tablero.grillas[k][j] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
                cont = 0;
                for (int k = i; k > -1; k--) {
                    if (tablero.grillas[k][j] == turno) {
                        cont++;
                        if (cont == 4)
                            return true;
                    } else break;
                }
            }
        }
        return false;
    }
    
    @Override
    public void notificar() {
        tablero.mantener(getInstancia());
    }
    
}
