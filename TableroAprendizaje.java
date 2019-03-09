import com.sun.nio.sctp.AbstractNotificationHandler;

import java.beans.PropertyChangeSupport;
import java.util.SplittableRandom;

public class TableroAprendizaje extends Tablero implements ITableroAprendizaje {

    private ITableroAprendizaje.Estado[][] tableroA;


    public TableroAprendizaje(){ 

        super();
        tableroA = new ITableroAprendizaje.Estado[8][8];
        this.initEstados();


    }

    @Override
    public void initEstados() {

        int i, j;

        for(i = 0; i<tableroA.length; i++){
            for(j = 0; j< tableroA.length; j++)
                tableroA[i][j] = Estado.VACIO;

        }

    }

    @Override
    public void setEstado(Posicion posicion, Estado estado) { // Actualiza el tablero

        int x = posicion.getX();
        int y = posicion.getY();



        tableroA[x][y] = estado;

    }

    public void setEstados(TableroAprendizaje.Estado[][] tableroVisual){

        for(int i = 0; i  < Tablero.SIZE; i++){
            for(int j = 0; j< Tablero.SIZE; j++){

                tableroA[i][j] = tableroVisual[i][j];
            }
        }

    }

    @Override
    public Estado getEstado(Posicion posicion) {

        int x = posicion.getX();
        int y = posicion.getY();

        return tableroA[x][y];
    }

    public String toString(){

        String resul = "";
        Posicion posicion;

        for(int i= 0; i< Tablero.SIZE; i++){
            for(int j = 0; j < Tablero.SIZE; j++){
                posicion = new Posicion(i,j);
                resul = resul + this.getEstado(posicion) + "  ";
            }
            resul+="\n";
        }

        return resul;
    }
}
