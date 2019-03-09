

public interface ITableroAprendizaje {

    enum Casilla {BLANCA, NEGRA};
    enum Estado {MOVIMIENTO_DESTINO, MOVIMIENTO_ORIGEN, MOVIMIENTO_POSIBLE, MOVIMIENTO_REAL, VACIO};


    static ITableroAprendizaje.Casilla valueOf(String name){


        if(name == "BLANCA")
            return Casilla.BLANCA;
        else if (name == "NEGRA")
            return Casilla.NEGRA;
        else return null;
    }

    static ITableroAprendizaje.Casilla[] values(){

        ITableroAprendizaje.Casilla[] valores = new ITableroAprendizaje.Casilla[2];

        valores[0] = Casilla.BLANCA;
        valores[1] = Casilla.NEGRA;

        return valores;

    }

    void initEstados(); 

    void setEstado(Posicion posicion, ITableroAprendizaje.Estado estado); 

    static ITableroAprendizaje.Casilla getColor(Posicion posicion){

        if((posicion.getX() % 2 == 0 && posicion.getY() % 2 == 0) || (posicion.getX() % 2 != 0 && posicion.getY() % 2 != 0))
            return Casilla.BLANCA;
        else return Casilla.NEGRA;

    }

    ITableroAprendizaje.Estado getEstado(Posicion posicion);


}
