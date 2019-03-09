import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vista extends Canvas implements PropertyChangeListener {

    public static int CASILLA_SIZE = 30;
    public static int MARGEN = 40;
    Graphics2D g2d;
    Graphics2D g2d_1;
    Graphics2D g2d_2;
    Graphics2D g2d_3;
    Posicion posicion;

    TableroAprendizaje tablero;


    public Vista(TableroAprendizaje tablero){

        this.tablero = tablero;

    }

    public void paint(Graphics g){

        g2d = (Graphics2D) g;
        g2d_1 = (Graphics2D) g;
        g2d_2 = (Graphics2D) g;
        g2d_3 = (Graphics2D) g;




        for(int i= 0; i<8; i++){
            for(int j = 0; j < 8; j++){


                posicion = new Posicion(i,j);



                if(ITableroAprendizaje.getColor(posicion) == ITableroAprendizaje.Casilla.BLANCA) {
                    g2d_1.setColor(Color.WHITE);
                    g2d_1.fillRect(MARGEN+j*CASILLA_SIZE, MARGEN+i*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE);

                }else {
                    g2d_1.setColor(Color.BLACK);
                    g2d_1.fillRect(MARGEN+j*CASILLA_SIZE, MARGEN+i*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE);

                }

                //Pinta las casillas donde puede transitar la figura

                if(tablero.getEstado(posicion) == ITableroAprendizaje.Estado.MOVIMIENTO_POSIBLE) {
                    g2d_3.setColor(Color.YELLOW);
                    g2d_3.fillRect(MARGEN+j*CASILLA_SIZE, MARGEN+i*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE);

                }




                if(tablero.get(posicion ) != null) {
                    g2d_2.setFont(new Font("TimesRoman", Font.PLAIN, 25));

                    if(tablero.get(posicion).getColor() == Figura.Color.BLANCA)
                        g2d_2.setColor(Color.GRAY);
                    else g2d_2.setColor(Color.RED);


                    if (tablero.get(posicion).getRepresentacion() == 'P')
                        g2d_2.drawString("P", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);
                    else if (tablero.get(posicion).getRepresentacion() == 'A')
                        g2d_2.drawString("A", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);
                    else if (tablero.get(posicion).getRepresentacion() == 'T')
                        g2d_2.drawString("T", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);
                    else if (tablero.get(posicion).getRepresentacion() == 'C')
                        g2d_2.drawString("C", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);
                    else if (tablero.get(posicion).getRepresentacion() == 'D')
                        g2d_2.drawString("D", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);
                    else g2d_2.drawString("R", MARGEN + j * CASILLA_SIZE + 5, MARGEN + i * CASILLA_SIZE + 25);

                }



                g2d.setColor(Color.black);
                g2d.drawRect(MARGEN+j*CASILLA_SIZE, MARGEN+i*CASILLA_SIZE, CASILLA_SIZE, CASILLA_SIZE); //


            }

        }

    }


    @Override
   public void propertyChange(PropertyChangeEvent evt) {


        repaint();

    }
}
