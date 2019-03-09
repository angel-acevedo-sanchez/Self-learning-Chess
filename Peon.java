import java.util.LinkedList;

public class Peon extends Figura {

    private char representacion;

    public Peon (Color color, Posicion posicion){
        super(color, posicion);
        this.representacion = 'P';
    }
    @Override
    public Figura clone() {

        Peon peon = new Peon(this.getColor(), this.getPosicion());

        return peon;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    @Override
    public int getValor() {
        return 1;
    }

    @Override
    public LinkedList<Posicion> movimientos(ITablero tablero) {


        Posicion posicion;
        LinkedList<Posicion> movimientos = new LinkedList<>();


        posicion = this.getPosicion();
        Posicion posicionInicial = posicion;
        boolean figuraEncontrada = false;

        if(this.getColor() == Color.NEGRA) {

            if (posicionInicial.getX() == 1) { 

                for (int i = posicionInicial.getX() ; i < posicionInicial.getX() + 2; i++) {

                    posicion = new Posicion(i + 1, this.getPosicion().getY());

                    if(tablero.get(posicion) != null)
                        figuraEncontrada = true;
                    else if (tablero.get(posicion) == null && !figuraEncontrada)
                        movimientos.add(posicion);




                }
            } else { 

                posicion = new Posicion(this.getPosicion().getX() + 1, this.getPosicion().getY());

                if (this.getPosicion().getX() != 7 && tablero.get(posicion) == null) {

                    movimientos.add(posicion);

                }
            }
        }

        else if(this.getColor() == Color.BLANCA){

            if (posicionInicial.getX() == 6) { 

                for (int i = 1; i <  3; i++) {

                    posicion = new Posicion(posicionInicial.getX() - i, this.getPosicion().getY());

                    if(tablero.get(posicion) != null)
                        figuraEncontrada = true;
                    else if (tablero.get(posicion) == null && !figuraEncontrada) {

                        movimientos.add(posicion);
                    }


                }
            } else { 

                posicion = new Posicion(this.getPosicion().getX() - 1, this.getPosicion().getY());

                if (this.getPosicion().getX() != 0 && tablero.get(posicion) == null) {

                    movimientos.add(posicion);

                }
            }
        }


        return movimientos;
    }
}
