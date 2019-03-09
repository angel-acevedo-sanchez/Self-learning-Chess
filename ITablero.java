import java.util.LinkedList;

public interface ITablero {

    static int SIZE = 8;

    Figura[][] get(); 

    void set(Figura[][] tablero);

    Figura get(Posicion posicion);

    void set(Figura figura);

    void setNull(Posicion posicion); 

    int valor(Figura.Color color); 

    void initTablero(); 

    int size(); 

    int size(Figura.Color color); 

    int sizePeones(Figura.Color color); 

    int sizeAlfiles(Figura.Color color); 

    int sizeTorres(Figura.Color color); 

    int sizeCaballos(Figura.Color color);

    boolean Reina(Figura.Color color); 

    LinkedList<Posicion> peones(Figura.Color color); 

    LinkedList<Posicion> alfiles(Figura.Color color); 

    LinkedList<Posicion> torres(Figura.Color color);

    LinkedList<Posicion> caballos(Figura.Color color);

    Posicion reina(Figura.Color color); 

    Posicion rey(Figura.Color color);

    LinkedList<Posicion> allFiguras(Figura.Color color);

    LinkedList<ITablero> escenarios(Figura.Color color); 

    ITablero estrategia(LinkedList<ITablero> escenarios, Figura.Color color);

    Posicion[] movimiento(ITablero tableroDestino); 

    ITablero clone();

    String toString();

}
