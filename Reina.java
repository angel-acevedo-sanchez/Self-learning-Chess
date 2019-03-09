import java.util.LinkedList;

public class Reina extends Figura {

    private char representacion;

    public Reina(Color color, Posicion posicion){
        super(color, posicion);
        this.representacion = 'D';
    }
    @Override
    public Figura clone() {

        Reina reina = new Reina(this.getColor(), this.getPosicion());
        return reina;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    @Override
    public int getValor() {
        return 10;
    }

    @Override
    public LinkedList<Posicion> movimientos(ITablero tablero) {

        LinkedList<Posicion> movimientos = new LinkedList<>();
        Posicion posicion ;


        boolean figuraEncontrada = false;
        int i;
        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();


        i = y +1;

        while(!figuraEncontrada && y < Tablero.SIZE - 1 && i < Tablero.SIZE){//movimiento en horizontal hacia la derecha


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

        while (!figuraEncontrada && x < Tablero.SIZE -1 && i < Tablero.SIZE){ //movimiento vertical hacia abajo

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


        int l = this.getPosicion().getX();
        int k = this.getPosicion().getY();
        figuraEncontrada = false;

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
