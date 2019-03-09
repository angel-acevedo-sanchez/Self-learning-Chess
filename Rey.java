import java.util.LinkedList;

public class Rey extends Figura {

    private char representacion;

    public Rey(Color color, Posicion posicion){
        super(color, posicion);
        this.representacion = 'R';
    }
    @Override
    public Figura clone() {

        Rey rey = new Rey(this.getColor(), this.getPosicion());
        return rey;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    @Override
    public int getValor() {
        return 20;
    }

    @Override
    public LinkedList<Posicion> movimientos(ITablero tablero) {

        LinkedList<Posicion> movimientos = new LinkedList<>();
        Posicion posicion;

        int x = this.getPosicion().getX();
        int y = this.getPosicion().getY();



                if(x > 0) {

                    posicion = new Posicion(x - 1, y); //justo arriba

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if(y > 0) {
                    posicion = new Posicion(x, y - 1); //justo a la izquierda

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R'  && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if(y < Tablero.SIZE -1) {
                    posicion = new Posicion(x, y + 1); //justo a la derecha

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if(x > 0 && y > 0) {

                    posicion = new Posicion(x - 1, y - 1); //diagonal superior izq

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if(x > 0 && y < Tablero.SIZE - 1) {

                    posicion = new Posicion(x - 1, y + 1); //diagonal superior derecha

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }


                if(x < Tablero.SIZE - 1 && y > 0) {

                    posicion = new Posicion(x + 1, y - 1); //diagonal inferior izquierda

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if(x < Tablero.SIZE -1) {

                    posicion = new Posicion(x + 1, y); //justo abajo

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }

                if (x < Tablero.SIZE - 1 && y < Tablero.SIZE - 1) {


                    posicion = new Posicion(x + 1, y + 1); //diagonal inferior derecha

                    if(tablero.get(posicion) != null && tablero.get(posicion).getRepresentacion() != 'R' && tablero.get(posicion).getColor() != this.getColor())
                        movimientos.add(posicion);
                    else if (tablero.get(posicion) == null)
                        movimientos.add(posicion);
                }




        return movimientos;
    }
}
