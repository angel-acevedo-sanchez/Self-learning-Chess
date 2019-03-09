import javafx.scene.control.Tab;

import java.util.LinkedList;

public class Caballo extends Figura {

    private char representacion;

    public Caballo(Color color, Posicion posicion){
        super(color, posicion);
        this.representacion = 'C';

    }

    @Override
    public Figura clone() {
        return null;
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

        LinkedList<Posicion> movimientos = new LinkedList<>();
        Posicion posicion;

        int i_inicial = this.getPosicion().getX();
        int j_inicial = this.getPosicion().getY();

        posicion = new Posicion(i_inicial-1,j_inicial+2); // L hacia la derecha y hacia arriba

        if(posicion.getX() >= 0 && posicion.getY() < Tablero.SIZE) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);

        }

        posicion = new Posicion(i_inicial+1, j_inicial+2);//movimiento en L hacia la derecha y hacia abajo


        if(posicion.getX() < Tablero.SIZE && posicion.getY() < Tablero.SIZE) {

            if (tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if (tablero.get(posicion) == null)
                movimientos.add(posicion);
        }


        posicion = new Posicion(i_inicial-2,j_inicial+1);

         // movimiento  en L hacia arriba y hacia la derecha

        if(posicion.getX() >= 0 && posicion.getY() < Tablero.SIZE ) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);
        }

        posicion = new Posicion(i_inicial-2, j_inicial-1);// movimiento en L hacia arriba y hacia la izquierda

        if((posicion.getX() >= 0  && posicion.getY() >= 0)) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);

        }

        posicion = new Posicion(i_inicial-1, j_inicial-2);//hacia la izquierda y hacia arriba

        if((posicion.getX() >= 0 && posicion.getY() >= 0)) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);
        }

        posicion = new Posicion(i_inicial+1, j_inicial -2); //hacia la izquierda y hacia abajo


        if((posicion.getX() < Tablero.SIZE && posicion.getY() >= 0 )) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);

        }
        posicion = new Posicion(i_inicial +2, j_inicial-1);//hacia abajo y hacia la izquierda


        if((posicion.getX() < Tablero.SIZE && posicion.getY() >= 0)) {

            if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
                movimientos.add(posicion);
            else if(tablero.get(posicion) == null)
                movimientos.add(posicion);
        }

        posicion = new Posicion(i_inicial+2, j_inicial+1);

     //hacia abajo y hacia la derecha


       if((posicion.getX() < Tablero.SIZE && posicion.getY() < Tablero.SIZE)) {

           if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' &&  tablero.get(posicion).getColor() != this.getColor())
               movimientos.add(posicion);
           else if(tablero.get(posicion) == null)
               movimientos.add(posicion);
       }



        return movimientos;
    }
}
