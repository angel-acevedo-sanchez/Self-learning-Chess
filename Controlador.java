import javafx.geometry.Pos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Controlador extends MouseAdapter {

    private TableroAprendizaje tablero;
    private Figura figuraPulsada = null;
    private Posicion posicionInicial;

    public Controlador(TableroAprendizaje tablero) {

        this.tablero = tablero;

    }

    public void mousePressed(MouseEvent e) {

        int x, y;

        x = e.getX();
        y = e.getY();

        LinkedList<Posicion> posiciones;

        int f = (y - Vista.MARGEN) / Vista.CASILLA_SIZE;
        int c = (x - Vista.MARGEN) / Vista.CASILLA_SIZE;


        posicionInicial = new Posicion(f, c);

        if (f >= 0 && f < ITablero.SIZE && c >= 0 && c < ITablero.SIZE) {

            if (tablero.get(posicionInicial) != null) {

                figuraPulsada = tablero.get(posicionInicial); 

                if (figuraPulsada.getRepresentacion() == 'A') {

                    Alfil alfil = new Alfil(figuraPulsada.getColor(), figuraPulsada.getPosicion());
                    System.out.println("Alfil seleccionado");

                    posiciones = alfil.movimientos(tablero);

                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);

                } else if (figuraPulsada.getRepresentacion() == 'P') {

                    Peon peon = new Peon(figuraPulsada.getColor(), figuraPulsada.getPosicion());

                    System.out.println("Peon seleccionado");

                    posiciones = peon.movimientos(tablero);


                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);


                } else if (figuraPulsada.getRepresentacion() == 'C') {

                    Caballo caballo = new Caballo(figuraPulsada.getColor(), figuraPulsada.getPosicion());
                    posiciones = caballo.movimientos(tablero);

                    System.out.println("Caballo seleccionado");

                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);
                } else if (figuraPulsada.getRepresentacion() == 'T') {

                    Torre torre = new Torre(figuraPulsada.getColor(), figuraPulsada.getPosicion());
                    tablero.setEstado(posicionInicial, ITableroAprendizaje.Estado.MOVIMIENTO_ORIGEN);

                    posiciones = torre.movimientos(tablero);
                    System.out.println("Torre seleccionada");

                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);

                } else if (figuraPulsada.getRepresentacion() == 'R') {

                    Rey rey = new Rey(figuraPulsada.getColor(), figuraPulsada.getPosicion());
                    posiciones = rey.movimientos(tablero);

                    System.out.println("Rey seleccionado");

                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);

                } else if (figuraPulsada.getRepresentacion() == 'D') {

                    Reina reina = new Reina(figuraPulsada.getColor(), figuraPulsada.getPosicion());

                    posiciones = reina.movimientos(tablero);


                    System.out.println("Dama seleccionada");

                    for (Posicion pos : posiciones)
                        tablero.setEstado(pos, ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE);

                }

                tablero.setNull(figuraPulsada.getPosicion());
                tablero.set(tablero.get()); //actualizo la vista -> se muestran los posibles movimientos

            }
        }



    }

    public void mouseReleased(MouseEvent e) { 

        int i, j;
        Posicion posicion;
        i = e.getX();
        j = e.getY();

        Figura[][] figuras = tablero.get();


        int f = (j - Vista.MARGEN) / Vista.CASILLA_SIZE;
        int c = (i - Vista.MARGEN) / Vista.CASILLA_SIZE;

        if (f >= 0 && f < ITablero.SIZE && c >= 0 && c < ITablero.SIZE && figuraPulsada != null) {

            System.out.println(f + ", " + c);

            posicion = new Posicion(f, c); //posicion de arrastre


            if (tablero.getEstado(posicion) != ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE) {

                tablero.setEstado(posicion, ITableroAprendizaje.Estado.MOVIMIENTO_REAL);
                tablero.set(figuraPulsada);
                tablero.set(tablero.get());


            } else if (tablero.getEstado(posicion) == ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE) {

                tablero.setEstado(posicion, ITableroAprendizaje.Estado.MOVIMIENTO_REAL);
                tablero.setEstado(posicionInicial, ITableroAprendizaje.Estado.MOVIMIENTO_ORIGEN);

                figuraPulsada.setPosicion(posicion); 
                tablero.set(figuraPulsada);


                tablero.set(tablero.get());
                System.out.println(tablero);


            } else {
                figuraPulsada.setPosicion(posicionInicial);
                tablero.set(figuraPulsada);
                tablero.set(figuras);
            }


        } else if ((f < 0 || f >= ITablero.SIZE || c < 0 || c >= ITablero.SIZE) && figuraPulsada != null) { 
            figuraPulsada.setPosicion(posicionInicial);
            tablero.set(figuraPulsada);
            tablero.set(figuras);
        }

        figuraPulsada = null;
        posicionInicial = null;
        tablero.initEstados();

    }
}



