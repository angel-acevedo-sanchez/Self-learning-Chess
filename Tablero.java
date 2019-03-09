import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class Tablero implements ITablero{


    private PropertyChangeSupport soporte;
    private Figura[][] tableroFiguras;
    private ITablero tablero;

    public void addPropertyChangeListener(PropertyChangeListener Pc1){

        soporte.addPropertyChangeListener(Pc1);

    }

    public PropertyChangeSupport getSupport(){
        return soporte;
    }

    public Tablero(){

        tableroFiguras = new Figura[8][8];
        this.initTablero();
        soporte = new PropertyChangeSupport(this);

    }

    public Tablero(Figura[][] tablero){

        this.set(tablero);
        soporte = new PropertyChangeSupport(this);


    }

    public Tablero(ITablero tablero){

        tableroFiguras = tablero.get();
        soporte = new PropertyChangeSupport(this);


    }





    @Override
    public Figura[][] get() {
        return tableroFiguras;
    }

    @Override
    public void set(Figura[][] tablero) {

        System.out.println("Tablero.set()");

        soporte.firePropertyChange("tablero", this.tablero, tablero);


        int i;
        int j;

        String resul = "";

        for(i = 0; i< Tablero.SIZE; i++){
            for(j = 0; j< Tablero.SIZE; j++) {
                this.tableroFiguras[i][j] = tablero[i][j];

                if(this.tableroFiguras[i][j] != null)
                    resul = resul + this.tableroFiguras[i][j].getRepresentacion() + " ";
                else resul+= " ";

            }
            resul +="\n";
        }
        System.out.println(resul);




    }

    @Override
    public Figura get(Posicion posicion) {

        int x = posicion.getX();
        int y = posicion.getY();

        return tableroFiguras[x][y];
    }

    @Override
    public void set(Figura figura) {

        Posicion p = figura.getPosicion();

        int x = p.getX();
        int y = p.getY();

        tableroFiguras[x][y] = figura;

    }

    @Override
    public void setNull(Posicion posicion) {

        int x = posicion.getX();
        int y = posicion.getY();

        tableroFiguras[x][y] = null;

    }

    @Override
    public int valor(Figura.Color color) {

        return 0;
    }

    @Override
    public void initTablero() {

        Posicion posicion; 


        //coloco los peones del jugador de figuras negras

        Peon peon;

        for(int i = 0; i < 8 ; i++) {

            posicion = new Posicion(1, i);
            peon = new Peon(Figura.Color.NEGRA, posicion);

            tableroFiguras[1][i] = peon;
        }

        //coloco los peones del jugador de figuras blancas

        for(int i = 0; i < 8 ; i++){

            posicion = new Posicion(6, i);
            peon = new Peon(Figura.Color.BLANCA, posicion);

            tableroFiguras[6][i] = peon;
        }


        //coloco las torres del jugador de figuras negras

        Torre torre;

        posicion = new Posicion(0,0);
        torre = new Torre(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][0] = torre;

        posicion = new Posicion(0,7);
        torre = new Torre(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][7] = torre;


        //coloco las torres del jugador de figuras blancas

        posicion = new Posicion(7,0);
        torre = new Torre(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][0] = torre;

        posicion = new Posicion(7, 7);
        torre = new Torre(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][7] = torre;


        //coloco los cabllaos del jugador de figuras negras

        Caballo caballo;

        posicion = new Posicion(0,1);
        caballo = new Caballo(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][1] = caballo;

        posicion = new Posicion(0,6);
        caballo = new Caballo(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][6] = caballo;

        //coloco los caballos del jugador de figuras BLANCAS

        posicion = new Posicion(7,1);
        caballo = new Caballo(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][1] = caballo;

        posicion = new Posicion(7,6);
        caballo = new Caballo(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][6] = caballo;

        //Coloco los alfiles del jugador de figuras NEGRAS

        Alfil alfil;

        posicion = new Posicion(0,2);
        alfil = new Alfil(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][2] = alfil;

        posicion = new Posicion(0,5);
        alfil = new Alfil(Figura.Color.NEGRA, posicion);
        tableroFiguras[0][5] = alfil;

        //coloco los alfiles del jugador de BLANCAS

        posicion = new Posicion(7,2);
        alfil = new Alfil(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][2] = alfil;

        posicion = new Posicion(7,5);
        alfil = new Alfil(Figura.Color.BLANCA, posicion);
        tableroFiguras[7][5] = alfil;

        //Coloco la reinas del jugador de negras

        Reina reina;

        posicion = new Posicion(0,3);
        reina = new Reina(Figura.Color.NEGRA, posicion);
        this.set(reina);

        //Coloco las reinas del jugador de blancas

        posicion = new Posicion(7,3);
        reina = new Reina(Figura.Color.BLANCA, posicion);
        this.set(reina);

        //Coloco el Rey del jugador de NEGRAS

        Rey rey;

        posicion = new Posicion(0,4);
        rey = new Rey(Figura.Color.NEGRA, posicion);
        this.set(rey);

        //coloco el Rey del jugador de BLANCAS

        posicion = new Posicion(7,4);
        rey = new Rey(Figura.Color.BLANCA, posicion);
        this.set(rey);




    }

    @Override
    public int size() {
         int contador = 0;

         for(int i = 0; i<8; i++){
             for(int j=0; j<8; j++){
                 if(this.tableroFiguras[i][j] != null)
                     contador++;
             }
         }

         return contador;
    }

    @Override

    public int size(Figura.Color color) {

        int contador = 0;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j] != null && this.tableroFiguras[i][j].getColor() == color)
                    contador++;
            }
        }

        return contador;

    }

    @Override
    public int sizePeones(Figura.Color color) {

        int contador = 0;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j] != null &&this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'P')
                    contador++;
            }
        }

        return contador;

    }

    @Override
    public int sizeAlfiles(Figura.Color color) {

        int contador = 0;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j] != null && this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'A')
                    contador++;
            }
        }

        return contador;

    }

    @Override
    public int sizeTorres(Figura.Color color) {
        int contador = 0;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j] != null && this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'T')
                    contador++;
            }
        }

        return contador;
    }

    @Override
    public int sizeCaballos(Figura.Color color) {
        int contador = 0;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j] != null && this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'C')
                    contador++;
            }
        }

        return contador;
    }

    @Override
    public boolean Reina(Figura.Color color) {

        boolean encontrado = false;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'D')
                    encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public LinkedList<Posicion> peones(Figura.Color color) {

        LinkedList<Posicion> posicionPeon = new LinkedList<>();
        Posicion posicion;



        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'P') {

                    posicion = new Posicion(i,j);
                    posicionPeon.add(posicion);
                }
            }
        }

        return posicionPeon;


    }

    @Override
    public LinkedList<Posicion> alfiles(Figura.Color color) {

        int i, j;
        LinkedList<Posicion> posicionAlfil = new LinkedList<>();
        Posicion posicion;

        for(i = 0; i<8; i++){
            for(j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'A') {

                    posicion = new Posicion(i,j);
                    posicionAlfil.add(posicion);
                }
            }
        }

        return posicionAlfil;
    }

    @Override
    public LinkedList<Posicion> torres(Figura.Color color) {

        LinkedList<Posicion> posicionTorres = new LinkedList<>();
        Posicion posicion;

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'T') {

                    posicion = new Posicion(i,j);
                    posicionTorres.add(posicion);
                }
            }
        }
        return posicionTorres;
    }

    @Override
    public LinkedList<Posicion> caballos(Figura.Color color) {

        LinkedList<Posicion> posicionCaballos = new LinkedList<>();
        Posicion posicion;




        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'C') {

                    posicion = new Posicion(i,j);
                    posicionCaballos.add(posicion);
                }
            }
        }

        return posicionCaballos;
    }

    @Override
    public Posicion reina(Figura.Color color) {

        Posicion posicion = new Posicion(0,0);

        for(int i = 0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.tableroFiguras[i][j].getColor() == color &&  tableroFiguras[i][j].getRepresentacion() == 'D') {

                    posicion.setX(i);
                    posicion.setY(j);

                }
            }
        }

        return posicion;
    }

    @Override
    public Posicion rey(Figura.Color color) {

        Posicion posicion = new Posicion(0, 0);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.tableroFiguras[i][j].getColor() == color && tableroFiguras[i][j].getRepresentacion() == 'R') {

                    posicion.setX(i);
                    posicion.setY(j);

                }
            }
        }

        return posicion;
    }

    @Override
    public LinkedList<Posicion> allFiguras(Figura.Color color) {

        Posicion posicion;
        LinkedList<Posicion> posicionAllFiguras = new LinkedList<>();


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.tableroFiguras[i][j].getColor() == color) {

                    posicion = new Posicion(i,j);
                    posicionAllFiguras.add(posicion);


                }
            }
        }

        return posicionAllFiguras;
    }

    @Override
    public LinkedList<ITablero> escenarios(Figura.Color color) {


        LinkedList<ITablero> escenarios = new LinkedList<ITablero>();

        ITablero tablero;

        Posicion posicion;
        Alfil alfil;
        Torre torre;
        Reina reina;
        Rey rey;
        Peon peon;
        Caballo caballo;

        for(int i= 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                if(tableroFiguras[i][j].getColor() == color){ //busco las figuras del color pasado por parametro

                    if(tableroFiguras[i][j].getRepresentacion() == 'P'){

                        if(color == Figura.Color.NEGRA){

                            if(tableroFiguras[i+1][j] == null){

                                tablero = new Tablero(tableroFiguras);

                                posicion = new Posicion(i+1,j);
                                peon = new Peon(color,posicion);
                                tablero.set(peon);
                                escenarios.add(tablero);

                                posicion = new Posicion(i,j); // borro el peon de la posicion inicial
                                tablero.setNull(posicion);
                            }

                            if(tableroFiguras[i+2][j] == null && i == 1){ //si esta en la posicion inicial puedo mover 2 posiciones tambien

                                tablero = new Tablero(tableroFiguras);

                                posicion = new Posicion(i+1, j);
                                peon = new Peon(color, posicion);
                                tablero.set(peon);
                                escenarios.add(tablero);

                                posicion = new Posicion(i, j); //borro el peon de la posicion inicial
                                tablero.setNull(posicion);
                            }

                        }else{ //si la figura es BLANCA

                            if(tableroFiguras[i-1][j] == null){

                                tablero = new Tablero(tableroFiguras);

                                posicion = new Posicion(i-1,j);
                                peon = new Peon(color,posicion);
                                tablero.set(peon);
                                escenarios.add(tablero);

                                posicion = new Posicion(i,j); // borro el peon de la posicion inicial
                                tablero.setNull(posicion);
                            }

                            if(tableroFiguras[i-2][j] == null && i == 6){ //si esta en la posicion inicial puedo mover 2 posiciones tambien

                                tablero = new Tablero(tableroFiguras);

                                posicion = new Posicion(i-2, j);
                                peon = new Peon(color, posicion);
                                tablero.set(peon);
                                escenarios.add(tablero);

                                posicion = new Posicion(i, j); //borro el peon de la posicion inicial
                                tablero.setNull(posicion);
                            }

                        }



                    }
                    else if(tableroFiguras[i][j].getRepresentacion() == 'C'){



                        posicion = new Posicion(i-1,j+2); // L hacia la derecha y hacia arriba

                        if(posicion.getX() >= 0 && posicion.getY() < Tablero.SIZE && tableroFiguras[i-1][j+2] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j); //posicion original
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }


                        posicion = new Posicion(i + 1, j +2);//movimiento en L hacia la derecha y hacia abajo


                        if(posicion.getX() < Tablero.SIZE && posicion.getY() < Tablero.SIZE && tableroFiguras[i+1][j+2] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }


                        posicion = new Posicion(i - 2,j + 1);

                        // movimiento  en L hacia arriba y hacia la derecha

                        if(posicion.getX() >= 0 && posicion.getY() < Tablero.SIZE && tableroFiguras[i-2][j+1] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }

                        posicion = new Posicion(i - 2, j - 1);// movimiento en L hacia arriba y hacia la izquierda

                        if((posicion.getX() >= 0  && posicion.getY() >= 0) && tableroFiguras[i-2][j-1] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }

                        posicion = new Posicion(i - 1, j - 2);//hacia la izquierda y hacia arriba

                        if((posicion.getX() >= 0 && posicion.getY() >= 0) && tableroFiguras[i-1][j-2] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);
                        }

                        posicion = new Posicion(i+1, j-2); //hacia la izquierda y hacia abajo


                        if((posicion.getX() < Tablero.SIZE && posicion.getY() >= 0 )&& tableroFiguras[i+1][j-2] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }

                        posicion = new Posicion(i +2, j -1);//hacia abajo y hacia la izquierda


                        if((posicion.getX() < Tablero.SIZE && posicion.getY() >= 0) && tableroFiguras[i+2][j-1] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);


                        }

                        posicion = new Posicion(i+2, j+1);

                        //hacia abajo y hacia la derecha


                        if((posicion.getX() < Tablero.SIZE && posicion.getY() < Tablero.SIZE) && tableroFiguras[i+2][j+1] == null) {

                            tablero = new Tablero(tableroFiguras);

                            caballo = new Caballo(color, posicion);
                            tablero.set(caballo);

                            posicion = new Posicion(i,j);
                            tablero.setNull(posicion);

                            escenarios.add(tablero);

                        }





                    }
                    else if(tableroFiguras[i][j].getRepresentacion() == 'A'){

                        int l = i;
                        int k = j;
                        boolean figuraEncontrada = false;

                        while (k < Tablero.SIZE - 1 && l < Tablero.SIZE - 1 && !figuraEncontrada) { //diagonal inferior hacia la derecha

                            tablero = new Tablero(tableroFiguras);

                            posicion = new Posicion(l + 1, k + 1);

                            if(tablero.get(posicion) != null)
                                figuraEncontrada = true;

                            else {
                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l++;
                            k++;
                        }

                        l = i;
                        k = j;

                        figuraEncontrada = false;

                        while (l < Tablero.SIZE - 1 && k > 0 && !figuraEncontrada) { // digaonal inferior hacia la izquierda

                            posicion = new Posicion(l + 1, k - 1);
                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l+1][k-1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }

                            l++;
                            k--;

                        }

                        l = i;
                        k = j;
                        figuraEncontrada = false;

                        while (k < Tablero.SIZE - 1 && l > 0 && !figuraEncontrada) { //diagonal superior derecha

                            posicion = new Posicion(l - 1, k + 1);
                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l-1][k+1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l--;
                            k++;
                        }

                        l = i;
                        k = j;
                        figuraEncontrada = false;

                        while (k > 0 && l > 0 && !figuraEncontrada) { //diagonal superior izquierda

                            posicion = new Posicion(l - 1, k - 1);

                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l-1][k-1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l--;
                            k--;

                        }

                    }
                    else if(tableroFiguras[i][j].getRepresentacion() == 'T'){

                        boolean figuraEncontrada = false;

                        int k = j +1;

                        while(!figuraEncontrada && j < Tablero.SIZE - 1 && k < Tablero.SIZE){//movimiento en horizontal hacia la derecha


                            posicion = new Posicion(i, k);

                            if(tableroFiguras[i][k] != null)
                                figuraEncontrada = true;
                            if(!figuraEncontrada) {
                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            k++;
                        }

                        figuraEncontrada = false;

                        k = j -1;

                        while(!figuraEncontrada && j > 0 && k >= 0){ //movimiento en horizontal hacia la izquierda



                            posicion = new Posicion(i,k);

                            if(tableroFiguras[i][k] != null)
                                figuraEncontrada = true;

                            if(!figuraEncontrada) {


                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);


                            }

                            k--;


                        }

                        figuraEncontrada = false;

                        int l = i -1;

                        while(!figuraEncontrada && i > 0 && l >=0){ //movimiento vertical hacia arriba

                            posicion = new Posicion(l,j);

                            if(tableroFiguras[l][j] != null)
                                figuraEncontrada = true;

                            if(!figuraEncontrada) {

                                tablero = new Tablero(tableroFiguras);

                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            l--;
                        }

                        figuraEncontrada = false;
                        l = i +1;

                        while(!figuraEncontrada && i < Tablero.SIZE -1 && l < Tablero.SIZE){ //movimiento vertical hacia abajo

                            posicion = new Posicion(l, j);

                            if(tableroFiguras[l][j] != null)
                                figuraEncontrada = true;
                            if(!figuraEncontrada) {

                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            l++;
                        }
                    }
                    else if(tableroFiguras[i][j].getRepresentacion() == 'R'){

                        if(i > 0) {

                            posicion = new Posicion(i - 1, j); //justo arriba
                            if (tableroFiguras[i-1][j] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }
                        }

                        if(j > 0) {
                            posicion = new Posicion(i, j - 1); //justo a la izquierda

                            if (tableroFiguras[i][j-1] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);

                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }
                        }

                        if(j < Tablero.SIZE -1) {

                            posicion = new Posicion(i, j + 1); //justo a la derecha

                            if (tableroFiguras[i][j+1] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }
                        }

                        if(i> 0 && j > 0) {

                            posicion = new Posicion(i- 1, j - 1); //diagonal superior izq
                            if (tableroFiguras[i-1][j-1] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }
                        }

                        if(i > 0 && j< Tablero.SIZE - 1) {

                            posicion = new Posicion(i - 1, j + 1); //diagonal superior derecha
                            if (tableroFiguras[i-1][j+1] == null){
                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }

                        }


                        if(i < Tablero.SIZE - 1 && j > 0) {

                            posicion = new Posicion(i + 1, j- 1); //diagonal inferior izquierda
                            if (tableroFiguras[i+1][j-1] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                        }

                        if(i < Tablero.SIZE -1) {

                            posicion = new Posicion(i+ 1, j); //justo abajo
                            if (tableroFiguras[i+1][j] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                        }

                        if (i < Tablero.SIZE - 1 && j < Tablero.SIZE - 1) {


                            posicion = new Posicion(i + 1, j + 1); //diagonal inferior derecha
                            if (tableroFiguras[i+1][j+1] == null) {

                                tablero = new Tablero(tableroFiguras);
                                rey = new Rey(color, posicion);

                                tablero.set(rey);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }
                        }

                    }

                    else if(tableroFiguras[i][j].getRepresentacion() == 'D'){


                        boolean figuraEncontrada = false;

                        int k = j +1;

                        while(!figuraEncontrada && j < Tablero.SIZE - 1 && k < Tablero.SIZE){//movimiento en horizontal hacia la derecha


                            posicion = new Posicion(i, k);

                            if(tableroFiguras[i][k] != null)
                                figuraEncontrada = true;
                            if(!figuraEncontrada) {
                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            k++;
                        }

                        figuraEncontrada = false;

                        k = j -1;

                        while(!figuraEncontrada && j > 0 && k >= 0){ //movimiento en horizontal hacia la izquierda



                            posicion = new Posicion(i,k);

                            if(tableroFiguras[i][k] != null)
                                figuraEncontrada = true;

                            if(!figuraEncontrada) {


                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);


                            }

                            k--;


                        }

                        figuraEncontrada = false;

                        int l = i -1;

                        while(!figuraEncontrada && i > 0 && l >=0){ //movimiento vertical hacia arriba

                            posicion = new Posicion(l,j);

                            if(tableroFiguras[l][j] != null)
                                figuraEncontrada = true;

                            if(!figuraEncontrada) {

                                tablero = new Tablero(tableroFiguras);

                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            l--;
                        }

                        figuraEncontrada = false;
                        l = i +1;

                        while(!figuraEncontrada && i < Tablero.SIZE -1 && l < Tablero.SIZE){ //movimiento vertical hacia abajo

                            posicion = new Posicion(l, j);

                            if(tableroFiguras[l][j] != null)
                                figuraEncontrada = true;
                            if(!figuraEncontrada) {

                                tablero = new Tablero(tableroFiguras);
                                torre = new Torre(color, posicion);

                                tablero.set(torre);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);

                            }

                            l++;
                        }


                        l = i;
                        k = j;

                       figuraEncontrada = false;

                        while (k < Tablero.SIZE - 1 && l < Tablero.SIZE - 1 && !figuraEncontrada) { //diagonal inferior hacia la derecha

                            tablero = new Tablero(tableroFiguras);

                            posicion = new Posicion(l + 1, k + 1);

                            if(tablero.get(posicion) != null)
                                figuraEncontrada = true;

                            else {
                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l++;
                            k++;
                        }

                        l = i;
                        k = j;

                        figuraEncontrada = false;

                        while (l < Tablero.SIZE - 1 && k > 0 && !figuraEncontrada) { // digaonal inferior hacia la izquierda

                            posicion = new Posicion(l + 1, k - 1);
                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l+1][k-1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }

                            l++;
                            k--;

                        }

                        l = i;
                        k = j;
                        figuraEncontrada = false;

                        while (k < Tablero.SIZE - 1 && l > 0 && !figuraEncontrada) { //diagonal superior derecha

                            posicion = new Posicion(l - 1, k + 1);
                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l-1][k+1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l--;
                            k++;
                        }

                        l = i;
                        k = j;
                        figuraEncontrada = false;

                        while (k > 0 && l > 0 && !figuraEncontrada) { //diagonal superior izquierda

                            posicion = new Posicion(l - 1, k - 1);

                            tablero = new Tablero(tableroFiguras);

                            if(tableroFiguras[l-1][k-1] != null)
                                figuraEncontrada = true;

                            else{

                                alfil = new Alfil(color, posicion);
                                tablero.set(alfil);

                                posicion = new Posicion(i,j);
                                tablero.setNull(posicion);

                                escenarios.add(tablero);
                            }
                            l--;
                            k--;

                        }

                    }
                }
            }
        }


        return escenarios;

    }

    @Override
    public ITablero estrategia(LinkedList<ITablero> escenarios, Figura.Color color) {
        return null;
    }

    @Override
    public Posicion[] movimiento(ITablero tableroDestino) {

        Posicion[] posiciones = new Posicion[2];
        Posicion posicion;

        for(int i = 0; i< Tablero.SIZE; i++){
            for(int j = 0; j < Tablero.SIZE; j++){

                posicion = new Posicion(i,j);
                if(this.get(posicion) != tableroDestino.get(posicion)){

                    if(tableroDestino.get(posicion) == null){
                        posiciones[0] = posicion; //movimiento origen

                    }
                    if(tableroDestino.get(posicion) != null){
                        posiciones[1] = posicion; //movimiento destino
                    }

                }
            }


        }

        return posiciones;
    }

    @Override
    public ITablero clone() {

        ITablero tablero = new Tablero();
        Posicion posicion;


        for(int i = 0; i< Tablero.SIZE; i++){
            for(int j = 0; j < Tablero.SIZE; j++){

                posicion = new Posicion(i,j);
                tablero.set(this.get(posicion));
            }
        }

        return tablero;
    }

    public String toString(){

        String resul = "";


        for(int i = 0; i< Tablero.SIZE; i++){
            for(int j = 0; j < Tablero.SIZE; j++){

                resul = resul + tableroFiguras[i][j].getRepresentacion() + " ";
            }

            resul+="\n";
        }

        return resul;


    }
}
