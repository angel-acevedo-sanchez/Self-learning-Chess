import javafx.scene.control.Tab;

import java.util.LinkedList;

public class Torre extends Figura {

    char representacion;

    public Torre(Color color, Posicion  posicion){
        super(color, posicion);
        this.representacion ='T';
    }
    @Override
    public Figura clone() {
        Torre torre = new Torre(this.getColor(), this.getPosicion());
        return torre;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    @Override
    public int getValor() {
        return 5;
    }

    @Override
    public LinkedList<Posicion> movimientos(ITablero tablero) {

        LinkedList<Posicion> movimientos = new LinkedList<>();
        Posicion posicion;
        boolean figuraEncontrada = false;
        int i;
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();


        i = y +1;

        while(!figuraEncontrada && y < Tablero.SIZE  - 1 && i < Tablero.SIZE){//movimiento en horizontal hacia la derecha


                posicion = new Posicion(x, i);

            if(tablero.get(posicion) != null) {
                figuraEncontrada = true;

                if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                    movimientos.add(posicion);

            }
                 if(!figuraEncontrada)
                     movimientos.add(posicion);

            i++;
        }

        figuraEncontrada = false;
        i = y -1;

        while(!figuraEncontrada && y > 0 && i >= 0){ //movimiento en horizontal hacia la izquierda



                posicion = new Posicion(x,i);

            if(tablero.get(posicion) != null) {
                figuraEncontrada = true;

                if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                    movimientos.add(posicion);

            }
                if(!figuraEncontrada)
                    movimientos.add(posicion);

            i--;


        }

        figuraEncontrada = false;

        i = x -1;

        while(!figuraEncontrada && x > 0 && i >=0){ //movimiento vertical hacia arriba

            posicion = new Posicion(i,y);

            if(tablero.get(posicion) != null) {
                figuraEncontrada = true;

                if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                    movimientos.add(posicion);

            }
            if(!figuraEncontrada)
                movimientos.add(posicion);

            i--;
        }

        figuraEncontrada = false;
        i = x +1;

        while(!figuraEncontrada && x < Tablero.SIZE -1 && i < Tablero.SIZE){ //movimiento vertical hacia abajo

            posicion = new Posicion(i, y);

            if(tablero.get(posicion) != null) {
                figuraEncontrada = true;

                if(tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                    movimientos.add(posicion);

            }

            if(!figuraEncontrada)
                movimientos.add(posicion);

            i++;
        }
        return movimientos;





    }
}
