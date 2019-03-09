import java.util.LinkedList;

public abstract class Figura {


    public static enum Color {BLANCA, NEGRA};

    private Color c;
    private Posicion p;

    public Figura(Color color, Posicion posicion){
        this.c = color;
        this.p = posicion;
    }

    public abstract Figura clone();

    public abstract char getRepresentacion();

    public abstract int getValor();

    public abstract LinkedList<Posicion> movimientos(ITablero tablero);

    public LinkedList<ITablero> escenarios(ITablero tablero){

        return null;
    }

    public Color getColor(){
        return this.c;
    }

    public Posicion getPosicion(){
        return this.p;
    }

    public void setPosicion(Posicion posicion){
        this.p = posicion;
    }






}
