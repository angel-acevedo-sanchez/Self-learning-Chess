import javafx.scene.control.Tab;

import java.util.LinkedList;

public class Alfil extends Figura {

    char representacion;

    public Alfil(Color color, Posicion posicion) {
        super(color, posicion);
        this.representacion = 'A';
    }


    @Override
    public Figura clone() {

        Figura alfil = new Alfil(this.getColor(), this.getPosicion());

        return alfil;

    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    @Override
    public int getValor() {
        return 3;
    }

    @Override
    public LinkedList<Posicion> movimientos(ITablero tablero) { 


        Posicion posicion;
        boolean figuraEncontrada = false;
        LinkedList<Posicion> movimientos = new LinkedList<>();



                    int l = this.getPosicion().getX();
                    int k = this.getPosicion().getY();

                    while (k < Tablero.SIZE - 1 && l < Tablero.SIZE - 1 && !figuraEncontrada) { //diagonal inferior hacia la derecha

                        posicion = new Posicion(l + 1, k + 1);

                        if(tablero.get(posicion) != null) {
                            figuraEncontrada = true;

                            if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                                movimientos.add(posicion);

                        }

                        else movimientos.add(posicion);
                        l++;
                        k++;
                    }

                    l = this.getPosicion().getX();
                    k = this.getPosicion().getY();
                    figuraEncontrada = false;

                    while (l < Tablero.SIZE - 1 && k > 0 && !figuraEncontrada) { // digaonal inferior hacia la izquierda

                        posicion = new Posicion(l + 1, k - 1);

                        if(tablero.get(posicion) != null) {
                            figuraEncontrada = true;

                            if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                                movimientos.add(posicion);

                        }

                        else movimientos.add(posicion);

                        l++;
                        k--;

                    }

                    l = this.getPosicion().getX();
                    k = this.getPosicion().getY();
                    figuraEncontrada = false;

                    while (k < Tablero.SIZE - 1 && l > 0 && !figuraEncontrada) { //diagonal superior derecha

                        posicion = new Posicion(l - 1, k + 1);

                        if(tablero.get(posicion) != null) {
                            figuraEncontrada = true;

                            if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                                movimientos.add(posicion);

                        }

                        else movimientos.add(posicion);
                        l--;
                        k++;
                    }

                    l = this.getPosicion().getX();
                    k = this.getPosicion().getY();
                    figuraEncontrada = false;

                    while (k > 0 && l > 0 && !figuraEncontrada) { //diagonal superior izquierda

                        posicion = new Posicion(l - 1, k - 1);

                        if(tablero.get(posicion) != null) {
                            figuraEncontrada = true;

                            if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                                movimientos.add(posicion);

                        }

                        else movimientos.add(posicion);
                        l--;
                        k--;

                    }



        return movimientos;


    }
}
