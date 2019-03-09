import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JuegoAjedrez extends Frame {


    private Vista vista;
    private Controlador controlador;
    private TableroAprendizaje tablero;


    JuegoAjedrez(){

        tablero = new TableroAprendizaje();

        controlador = new Controlador(tablero);


        vista = new Vista(tablero);
        this.add(vista);

        tablero.addPropertyChangeListener(vista);

        vista.addMouseListener(controlador);


        this.setSize(Vista.MARGEN*2+Vista.CASILLA_SIZE*8 + 10,Vista.MARGEN*2+Vista.CASILLA_SIZE*8 + 10);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter()

        {public void windowClosing(WindowEvent e) {


            dispose();
            System.exit(0);}
        });



    }


    public static void main(String[] args){

        JuegoAjedrez juego = new JuegoAjedrez();
        System.out.println(juego.tablero);

        System.out.println(juego.tablero.sizeCaballos(Figura.Color.NEGRA));


    }


}
